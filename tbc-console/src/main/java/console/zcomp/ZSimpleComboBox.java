package console.zcomp;

import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.messages.client.DefaultMessages;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.error.ToolTipErrorHandler;

import java.util.*;

public class ZSimpleComboBox<T> extends SimpleContainer implements HasValue<T>, HasKeyDownHandlers {

	private ComboBox<SimpleValue> combo;

	private List<T> values;

	// used in filtering of combo box
	private List<SimpleValue> simpleValues;

	private Comparator<T> comparator;

	private ModelKeyProvider<T> keyProvider;

	private LabelProvider<T> labelProvider;

	private SafeHtmlRenderer<T> renderer;

	private boolean triggerClicked;

    private boolean enableSort = true;

	private ZSimpleComboBox(ListStore<SimpleValue> store, ModelKeyProvider<T> keyProvider, LabelProvider<T> labelProvider, List<T> values, Comparator<T> comparator, SafeHtmlRenderer<T> renderer) {
		this.keyProvider = keyProvider;
		this.labelProvider = labelProvider;
		this.values = values;
		this.simpleValues = new ArrayList<>(store.getAll());
		this.comparator = comparator;
		this.renderer = renderer;

		if (renderer != null) {
			combo = new ComboBox<>(store, new LabelProvider<SimpleValue>() {
				@Override
				public String getLabel(SimpleValue item) {
					return item.getLabel();
				}
			}, new AbstractSafeHtmlRenderer<SimpleValue>() {
				@Override
				public SafeHtml render(SimpleValue object) {
					return object.getHtml();
				}
			});
		} else {
			combo = new ComboBox<>(store, new LabelProvider<SimpleValue>() {
				@Override
				public String getLabel(SimpleValue item) {
					return item.getLabel();
				}
			});
		}

		combo.setForceSelection(true);
		combo.setTypeAhead(false);
		combo.getStore().setAutoCommit(true);
		combo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
		setComboLoader();

		add(combo);
		addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					combo.finishEditing();
					combo.sinkEvents(KeyCodes.KEY_ENTER);
				}
			}
		});
	}

	private void setComboLoader() {
		RpcProxy<ListLoadConfig, ListLoadResult<SimpleValue>> proxy = new RpcProxy<ListLoadConfig, ListLoadResult<SimpleValue>>() {
			@Override
			public void load(ListLoadConfig loadConfig, final AsyncCallback<ListLoadResult<SimpleValue>> callback) {
				List<SimpleValue> filteredValues = new ArrayList<>();
				String query = combo.getText();
				if (triggerClicked || query == null || query.trim().isEmpty()) {
					filteredValues.addAll(simpleValues);
				} else {
					query = query.trim().toLowerCase();
					for (SimpleValue value : simpleValues) {
						if (value.getLabel().toLowerCase().contains(query)) {
							filteredValues.add(value);
						}
					}
				}
				callback.onSuccess(new ListLoadResultBean<>(filteredValues));
			}
		};
		ListLoader<ListLoadConfig, ListLoadResult<SimpleValue>> loader = new ListLoader<>(proxy);
		loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, SimpleValue, ListLoadResult<SimpleValue>>(combo.getStore()));

		combo.setLoader(loader);
		combo.setMinChars(0);

		combo.addTriggerClickHandler(new TriggerClickEvent.TriggerClickHandler() {
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
				triggerClicked = true;
			}
		});
		combo.addExpandHandler(new ExpandEvent.ExpandHandler() {
			@Override
			public void onExpand(ExpandEvent event) {
				triggerClicked = false;
			}
		});
	}

	@Override
	public T getValue() {
		T value = null;
		if (combo.getValue() != null && !"".equals(combo.getValue().getKey())) {
			value = findRealValueInternal(combo.getValue().getKey());
		}
		return value;
	}

	public T getCurrentValue(){
		T value = null;
		if (combo.getCurrentValue() != null && !"".equals(combo.getCurrentValue().getKey())) {
			value = findRealValueInternal(combo.getCurrentValue().getKey());
		}
		return value;
	}

	@Override
	public void setValue(T value) {
		if (value == null) {
			if (combo.getStore().getAll().size() > 0 && "".equals(combo.getStore().getAll().get(0).getKey())) {
				combo.setValue(combo.getStore().getAll().get(0));
			} else {
				combo.setValue(null);
			}
		} else {
			add(value);
			combo.setValue(findSimpleValueInternal(keyProvider.getKey(value)));
		}
	}

	@Override
	public void setValue(T value, boolean fireEvents) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<T> handler) {
		return combo.addValueChangeHandler(new ValueChangeHandler<SimpleValue>() {
			@Override
			public void onValueChange(ValueChangeEvent<SimpleValue> event) {
				handler.onValueChange(new ZSimpleComboBoxValueChangeEvent<T>(getValue()));
			}
		});
	}

	public void add(T value) {
		boolean alreadyExists = findRealValueInternal(keyProvider.getKey(value))  != null;
		if (!alreadyExists) {
			values.add(value);
            if (enableSort){
                sortValues();
            }

			int index = values.indexOf(value);
			SimpleValue simpleValue = renderer == null ? SimpleValue.create(value, keyProvider, labelProvider) : SimpleValue.create(value, keyProvider, labelProvider, renderer) ;
			simpleValues.add(index <= simpleValues.size() ? index : simpleValues.size(), simpleValue);
			combo.getStore().add(index < combo.getStore().size() ? index : combo.getStore().size() - 1 >= 0 ? combo.getStore().size() - 1 : 0, simpleValue);
		}
		combo.getStore().commitChanges();
	}

	public void add(int index, T value) {
		values.add(index, value);
		SimpleValue simpleValue = renderer == null ? SimpleValue.create(value, keyProvider, labelProvider) :  SimpleValue.create(value, keyProvider, labelProvider, renderer);
		simpleValues.add(index, simpleValue);
		combo.getStore().add(index, simpleValue);
		combo.getStore().commitChanges();
	}

	public void addAll(List<T> list) {
		for (T v : list) {
			add(v);
		}
	}

	private void sortValues() {
		Collections.sort(values, comparator);
	}

	public void remove(T value) {
		values.remove(value);
		Iterator<SimpleValue> it = simpleValues.iterator();
		while (it.hasNext()) {
			SimpleValue sv = it.next();
			if (sv.getKey() != null && sv.getKey().equals(keyProvider.getKey(value))) {
				it.remove();
				break;
			}
		}
		combo.getStore().remove(findSimpleValueInternal(keyProvider.getKey(value)));
		combo.getStore().commitChanges();
	}

	public void removeAll() {
		for (T value : new ArrayList<>(values)) {
			if (!"".equals(keyProvider.getKey(value))) {
				remove(value);
			}
		}
	}

	public void replaceAll(List<T> values) {
		removeAll();
		addAll(values);
	}

	public void setEnabled(boolean enabled) {
		combo.setEnabled(enabled);
	}

	public boolean isValid() {
		if (!combo.isAllowBlank() && getValue() == null) {
			combo.markInvalid(DefaultMessages.getMessages().textField_blankText());
			return false;
		}
		return combo.isValid();
	}

	public void setRequired(boolean required){
		combo.setAllowBlank(!required);
	}

	public void setTooltipErrorHandler() {
		combo.setErrorSupport(new ToolTipErrorHandler(combo));
	}

	public void markInvalid(String message) {
		if (message == null) {
			combo.markInvalid(DefaultMessages.getMessages().textField_blankText());
		} else {
			combo.markInvalid(message);
		}
	}

	public void setForceSelection(boolean selection) {
		combo.select(0);
	}

	public void setEmptyText(String emptyText) {
		combo.setEmptyText(emptyText);
	}

	public List<T> getValues() {
		return values;
	}

	private T findRealValueInternal(String key) {
		T value = null;
		for (T v : values) {
			if (key.equals(keyProvider.getKey(v))) {
				value = v;
				break;
			}
		}
		return value;
	}

	private SimpleValue findSimpleValueInternal(String key) {
		SimpleValue value = null;
		for (SimpleValue v : combo.getStore().getAll()) {
			if (v.getKey().equals(key)) {
				value = v;
				break;
			}
		}
		return value;
	}

	public void update(T value) {
		combo.getStore().update(renderer == null ? SimpleValue.create(value, keyProvider, labelProvider) : SimpleValue.create(value, keyProvider, labelProvider, renderer));
	}

	public void setWidth(int width) {
		combo.setWidth(width);
	}

	public HandlerRegistration addSelectionHandler(final SelectionHandler<T> handler) {
		return combo.addSelectionHandler(new com.google.gwt.event.logical.shared.SelectionHandler<SimpleValue>() {
			@Override
			public void onSelection(SelectionEvent<SimpleValue> evt) {
				T value = null;
				if (evt.getSelectedItem() != null && !"".equals(evt.getSelectedItem().getKey())) {
					value = findRealValueInternal(evt.getSelectedItem().getKey());
				}
				handler.onSelection(value);
			}
		});
	}

	public HandlerRegistration addBeforeSelectionHandler(final BeforeSelectionHandler<T> handler) {
		return combo.addBeforeSelectionHandler(new com.google.gwt.event.logical.shared.BeforeSelectionHandler<SimpleValue>() {
			@Override
			public void onBeforeSelection(BeforeSelectionEvent<SimpleValue> evt) {
				T value = null;
				if (evt.getItem() != null && !"".equals(evt.getItem().getKey())) {
					value = findRealValueInternal(evt.getItem().getKey());
				}
				handler.onBeforeSelection(value, evt);
			}
		});
	}

	@Override
	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return addDomHandler(handler, KeyDownEvent.getType());
	}

	public interface SelectionHandler<T> {
		void onSelection(T value);
	}

	public interface BeforeSelectionHandler<T> {
		void onBeforeSelection(T value, BeforeSelectionEvent<SimpleValue> evt);
	}

	public ComboBox<SimpleValue> getCombo() {
		return combo;
	}

	public void reset() {
		combo.reset();
	}

    public boolean isEnableSort() {
        return enableSort;
    }

    public void setEnableSort(boolean enableSort) {
        this.enableSort = enableSort;
    }

    public static class Builder<T> {
		private ModelKeyProvider<T> keyProvider;
		private LabelProvider<T> labelProvider;
		private String noSelectionLabel;
		private List<T> values = new ArrayList<>();
		private Comparator<T> comparator;
		private SafeHtmlRenderer<T> renderer;
		private int listWidth;
		private int width = 150;
		private boolean required;
		private String emptyText;
		private boolean enabled = true;
		private boolean editable = true;
        private boolean enableSorting = true;

		public Builder<T> keyProvider(ModelKeyProvider<T> keyProvider) {
			this.keyProvider = keyProvider;
			return this;
		}

		public Builder<T> labelProvider(LabelProvider<T> labelProvider) {
			this.labelProvider = labelProvider;
			return this;
		}

		public Builder<T> noSelectionLabel(String noSelectionLabel) {
			this.noSelectionLabel = noSelectionLabel;
			return this;
		}

		public Builder<T> values(List<T> values) {
			this.values = values;
			return this;
		}

		public Builder<T> comparator(Comparator<T> comparator) {
			this.comparator = comparator;
			return this;
		}

		public Builder<T> listWidth(int listWidth) {
			this.listWidth = listWidth;
			this.listWidth = 600;
			return this;
		}

		public Builder<T> width(int width) {
			this.width = width;
			return this;
		}

		public Builder<T> required(boolean required) {
			this.required = required;
			return this;
		}

		public Builder<T> emptyText(String emptyText) {
			this.emptyText = emptyText;
			return this;
		}

		public Builder<T> enabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

        public Builder<T> enableSorting(boolean enableSorting) {
            this.enableSorting = enableSorting;
            return this;
        }

		public Builder<T> editable(boolean editable) {
			this.editable = editable;
			return this;
		}

		public Builder<T> template (SafeHtmlRenderer<T> renderer) {
			this.renderer = renderer;
			return this;
		}

		public ZSimpleComboBox<T> build() {
			if (keyProvider == null) {
				throw new IllegalStateException("KeyProvider is required");
			}
			if (labelProvider == null) {
				throw new IllegalStateException("LabelProvider is required");
			}
			if (comparator == null) {
				initComparator();
			}
			ListStore<SimpleValue> store = new ListStore<>(new ModelKeyProvider<SimpleValue>() {
				@Override
				public String getKey(SimpleValue item) {
					return item.getKey();
				}
			});
			if (noSelectionLabel != null) {
				if ("".equals(noSelectionLabel.trim())) {
					//NOTE This is non-breakable space ALT + 0 1 6 0
					noSelectionLabel = " ";
				}
				store.add(new SimpleValue("", noSelectionLabel));
			}
			if (values.size() > 0) {
                if (enableSorting) {
                    sortValues();
                }
                for (T obj : values) {
                    store.add(renderer == null ? SimpleValue.create(obj, keyProvider, labelProvider) : SimpleValue.create(obj, keyProvider, labelProvider, renderer));
                }
            }
            ZSimpleComboBox<T> combo = new ZSimpleComboBox<>(store, keyProvider, labelProvider, values, comparator, renderer);
			if (noSelectionLabel != null) {
				combo.setValue(null);
			} else if (values.size() > 0) {
				combo.setValue(values.get(0));
			}
			if (listWidth > 0) {
				combo.getCombo().setMinListWidth(listWidth);
			}
			if (width > 0) {
				combo.setWidth(width);
			}

			if (emptyText != null) {
				combo.getCombo().setEmptyText(emptyText);
			}
            combo.setEnableSort(enableSorting);
			combo.getCombo().setAllowBlank(!required);
			combo.getCombo().setEnabled(enabled);
			combo.getCombo().setEditable(editable);
			return combo;
		}

		private void initComparator() {
			comparator = new Comparator<T>() {
				@Override
				public int compare(T a, T b) {
					return labelProvider.getLabel(a).compareTo(labelProvider.getLabel(b));
				}
			};
		}

		private void sortValues() {
			values = new ArrayList<>(values);
			Collections.sort(values, comparator);
		}
	}

	public static class SimpleValue {
		private String key;
		private String label;
		private SafeHtml html;

		public SimpleValue() {}

		public SimpleValue(String key, String label) {
			this.key = key;
			this.label = label;
		}

		public static <T> SimpleValue create(T obj, ModelKeyProvider<T> keyProvider, LabelProvider<T> labelProvider) {
			SimpleValue v = new SimpleValue();
			v.setKey(keyProvider.getKey(obj));
			v.setLabel(labelProvider.getLabel(obj));
			return v;
		}

		public static <T> SimpleValue create(T obj, ModelKeyProvider<T> keyProvider, LabelProvider<T> labelProvider, SafeHtmlRenderer<T> renderer) {
			SimpleValue v = new SimpleValue();
			v.setKey(keyProvider.getKey(obj));
			v.setLabel(labelProvider.getLabel(obj));
			v.setHtml(renderer.render(obj));
			return v;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public SafeHtml getHtml() {
			return html;
		}

		public void setHtml(SafeHtml html) {
			this.html = html;
		}
	}

	private static class ZSimpleComboBoxValueChangeEvent<T> extends ValueChangeEvent<T> {

		public ZSimpleComboBoxValueChangeEvent(T value) {
			super(value);
		}
	}
}