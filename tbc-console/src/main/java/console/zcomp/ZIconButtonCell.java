package console.zcomp;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Image;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.data.shared.ListStore;
import console.zcomp.helper.BooleanStateSelector;
import console.zcomp.helper.GridClickHandler;
import console.zcomp.helper.IconSelector;
import console.zcomp.helper.TooltipSelector;

@SuppressWarnings("unchecked")
public class ZIconButtonCell<ST, T> extends AbstractCell<T> {

	private ImageResource icon;

	private String tooltip;

	private IconSelector iconSelector;

	private TooltipSelector tooltipSelector;

	private BooleanStateSelector enabledSelector;

	private BooleanStateSelector visibilitySelector;

	private GridClickHandler clickHandler;

	private ListStore<ST> gridStore;

	private Style style = ((Resources) GWT.create(Resources.class)).style();

	private Template template = GWT.create(Template.class);

	private ZIconButtonCell() {
		super("click");
		this.style.ensureInjected();

	}

	public interface Template extends XTemplates {
		@XTemplate(value = "<div class='{style.cellButton} {style.cellButtonActive}' qtip='{tooltip}'>image</div>")
		SafeHtml getActiveButtonElement(Style style, String tooltip);

		@XTemplate(value = "<div class='{style.cellButton}' qtip='{tooltip}'>image</div>")
		SafeHtml getInactiveButtonElement(Style style, String tooltip);
	}

	public interface Style extends CssResource {
		@ClassName("cell-button")
		String cellButton();

		@ClassName("cell-button-active")
		String cellButtonActive();
	}

	public interface Resources extends ClientBundle {
		@Source("resources/ZIconButtonCellAppearance.css")
		Style style();
	}

	@Override
	public void render(Context context, T value, SafeHtmlBuilder sb) {
		ImageResource buttonIcon = icon;
		String buttonTooltip = tooltip;
		ST objectValue = getObjectValue(context);
		if (iconSelector != null) {
			buttonIcon = iconSelector.selectIcon(context, objectValue);
		}
		if (tooltipSelector != null) {
			buttonTooltip = tooltipSelector.selectTooltip(context, objectValue);
		}
		if (buttonTooltip == null) {
			buttonTooltip = "";
		}
		String image = (buttonIcon == null) ? "" : new Image(buttonIcon).getElement().getString();
		if (visibilitySelector != null && !visibilitySelector.check(context, objectValue)) {
			sb.appendHtmlConstant("");
		} else if (enabledSelector == null || enabledSelector.check(context, objectValue)) {
			sb.appendHtmlConstant(template.getActiveButtonElement(style, buttonTooltip)
					.asString().replace("image", image));
		} else {
			sb.appendHtmlConstant(template.getInactiveButtonElement(style, buttonTooltip)
					.asString().replace("image", image));
		}
	}
	@Override
	public void onBrowserEvent(Context context, Element parent, T value, NativeEvent event, ValueUpdater<T> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		if (("click").equals(event.getType())) {
			if (clickHandler != null) {
				ST objectValue = getObjectValue(context);
				if ((visibilitySelector == null || visibilitySelector.check(context, objectValue)) &&
						(enabledSelector == null || enabledSelector.check(context, objectValue))) {
					clickHandler.onClick(context, objectValue);
				}
			}
		}
	}

	private ST getObjectValue(Context context) {
		return gridStore.get(context.getIndex());
	}

	public static class Builder<ST, T> {

		private ImageResource icon;
		private String tooltip;
		private GridClickHandler clickHandler;
		private ListStore<ST> gridStore;
		private IconSelector iconSelector;
		private TooltipSelector tooltipSelector;
		private BooleanStateSelector enabledSelector;
		private BooleanStateSelector visibilitySelector;

		public Builder<ST, T> icon(ImageResource icon) {
			this.icon = icon;
			return this;
		}

		public Builder<ST, T> tooltip(String tooltip) {
			this.tooltip = tooltip;
			return this;
		}

		public Builder<ST, T> clickHandler(GridClickHandler<ST> clickHandler) {
			this.clickHandler = clickHandler;
			return this;
		}

		public Builder<ST, T> gridStore(ListStore<ST> gridStore) {
			this.gridStore = gridStore;
			return this;
		}

		public Builder<ST, T> dynamicIcon(IconSelector<ST> iconSelector) {
			this.iconSelector = iconSelector;
			return this;
		}

		public Builder<ST, T> dynamicTooltip(TooltipSelector<ST> tooltipSelector) {
			this.tooltipSelector = tooltipSelector;
			return this;
		}

		public Builder<ST, T> dynamicEnabling(BooleanStateSelector<ST> enabledSelector) {
			this.enabledSelector = enabledSelector;
			return this;
		}

		public Builder<ST, T> dynamicVisibility(BooleanStateSelector<ST> visibilitySelector) {
			this.visibilitySelector = visibilitySelector;
			return this;
		}

		public ZIconButtonCell<ST, T> build() {
			ZIconButtonCell<ST, T> cell = new ZIconButtonCell<ST, T>();
			if (icon != null) {
				cell.icon = icon;
			}
			if (tooltip != null) {
				cell.tooltip = tooltip;
			}
			if (clickHandler != null) {
				cell.clickHandler = clickHandler;
			}
			if (iconSelector != null) {
				cell.iconSelector = iconSelector;
			}
			if (tooltipSelector != null) {
				cell.tooltipSelector = tooltipSelector;
			}
			if (enabledSelector != null) {
				cell.enabledSelector = enabledSelector;
			}
			if (visibilitySelector != null) {
				cell.visibilitySelector = visibilitySelector;
			}
			if (gridStore != null) {
				cell.gridStore = gridStore;
			} else {
				throw new IllegalStateException("Grid store is required for ZIconButtonCell");
			}
			return cell;
		}
	}
}
