package console.zcomp;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ZDynamicComboBox<T> extends ComboBox<T> {

	private int maxResults;

	private boolean triggerClicked;

    private boolean loadAllOnTriggerClick = true;

	private T noSelection;

	private ZDynamicComboBox(final ListStore<T> store, final LabelProvider<? super T> labelProvider, final Builder.DataCallBack<T> dataCallBack, final Comparator<T> comparator, final T noSelection) {
		super(store, labelProvider);
		this.noSelection = noSelection;
		RpcProxy<ListLoadConfig, ListLoadResult<T>> proxy = new RpcProxy<ListLoadConfig, ListLoadResult<T>>() {
			@Override
			public void load(ListLoadConfig loadConfig, final AsyncCallback<ListLoadResult<T>> callback) {
				String query;
				if (triggerClicked && loadAllOnTriggerClick) {
					query = "";
				} else {
					query = getText();
				}
				dataCallBack.getData(query, maxResults, new AsyncCallback<List<T>>() {

					@Override
					public void onSuccess(List<T> result) {
						Collections.sort(result, comparator);
						if (noSelection != null) {
							result.add(0, noSelection);
						}
						callback.onSuccess(new ListLoadResultBean<>(result));
					}

					@Override
					public void onFailure(Throwable throwable) {
						// TODO Implement
					}
				});
			}
		};
		ListLoader<ListLoadConfig, ListLoadResult<T>> loader = new ListLoader<>(proxy);
		loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, T, ListLoadResult<T>>(store));
		setLoader(loader);
		addTriggerClickHandler(new TriggerClickEvent.TriggerClickHandler() {
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
				triggerClicked = true;
			}
		});
		addExpandHandler(new ExpandEvent.ExpandHandler() {
			@Override
			public void onExpand(ExpandEvent event) {
				triggerClicked = false;
			}
		});
        addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					finishEditing();
					sinkEvents(KeyCodes.KEY_ENTER);
				}
			}
		});
	}

	@Override
	public T getValue() {
		T selected = super.getValue();
		if (noSelection != null && selected == noSelection) {
			return null;
		}
		return selected;
	}

	@SuppressWarnings("JavaDoc")
	public static class Builder<T> {

		public interface DataCallBack<T> {

			void getData(String query, int maxResults, AsyncCallback<List<T>> callback);
		}

		private ListStore<T> store;

		private LabelProvider<T> labelProvider;

		private ModelKeyProvider<T> modelKeyProvider;

		private DataCallBack<T> dataCallBack;

		private Comparator<T> comparator;

		private int minChars;

		private int maxResults = 5;

		private int width = 150;

		private String emptyText;

		private boolean enabled = true;

        private boolean loadAllOnTriggerClick = true;

		private int listWidth;

		protected T noSelection;

        private boolean useQueryCache = false;

        public Builder<T> useQueryCache(boolean useQueryCache) {
            this.useQueryCache = useQueryCache;
            return this;
        }

		public Builder<T> labelProvider(LabelProvider<T> labelProvider){
			this.labelProvider = labelProvider;
			return this;
		}

		public Builder<T> dataCallback(DataCallBack<T> dataCallBack){
			this.dataCallBack = dataCallBack;
			return this;
		}

        public Builder<T> loadAllOnTriggerClick(boolean loadAllOnTriggerClick) {
            this.loadAllOnTriggerClick = loadAllOnTriggerClick;
            return this;
        }

		public Builder<T> comparator(Comparator<T> comparator){
			this.comparator = comparator;
			return this;
		}

		/**
		 * key პროვაიდერი ობიექტისთვის
		 * ნაგულისხმევად, ყოველი ობიექტისთვის key = object.toString();
		 * @param modelKeyProvider
		 * @return
		 */
		public Builder<T> keyProvider(ModelKeyProvider<T> modelKeyProvider){
			this.modelKeyProvider = modelKeyProvider;
			return this;
		}

		/**
		 * მინიმალური სიმბოლოების რაოდენობა, რომლებიც უნდა შეიყვანოს მომხმარებელმა კომბოში, რომ დაიწყოს ჩამოტვირთვა სიის
		 * @param minChars
		 * @return
		 */
		public  Builder<T> minChars(int minChars){
			this.minChars = minChars;
			return this;
		}

		/**
		 * მაქსიმუმ რამდენი ელემენტი გამოჩნდეს სიაში
		 * ნაგულისხმევი მნიშვნელობა არის 5
		 * @param maxResults
		 * @return
		 */
		public  Builder<T> maxResults(int maxResults){
			this.maxResults = maxResults;
			return this;
		}

		public  Builder<T> width(int width){
			this.width = width;
			return this;
		}

		public  Builder<T> emptyText(String emptyText){
			this.emptyText = emptyText;
			return this;
		}

		public  Builder<T> enabled(boolean enabled){
			this.enabled = enabled;
			return this;
		}

		public  Builder<T> listWidth(int listWidth) {
			this.listWidth = listWidth;
			return this;
		}

		public Builder<T> noSelection(T noSelection) {
			this.noSelection = noSelection;
			return this;
		}


		public ZDynamicComboBox<T> build() {
			if (modelKeyProvider == null){
				store = new ListStore<>(new ModelKeyProvider<T>() {
					@Override
					public String getKey(T item) {
						return item.toString();
					}
				});
			} else {
				store = new ListStore<>(modelKeyProvider);
			}
			if (comparator == null) {
				initComparator();
			}

			ZDynamicComboBox<T> combo = new ZDynamicComboBox<>(store, labelProvider, dataCallBack, comparator, noSelection);
			combo.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
			combo.maxResults = this.maxResults;
            combo.loadAllOnTriggerClick = loadAllOnTriggerClick;
			combo.setMinChars(minChars);
			combo.setWidth(width > 0 ? width : 150);
			combo.setTypeAhead(false);
			combo.setUseQueryCache(useQueryCache);
			if (emptyText != null) {
				combo.setEmptyText(emptyText);
			}
			combo.setEnabled(enabled);
			combo.setMinListWidth(listWidth);
			if (noSelection != null) {
				store.add(noSelection);
				combo.setValue(noSelection);
			}
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
	}
}
