package console.zcomp;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.cell.core.client.ButtonCell.ButtonCellAppearance;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class ZButton extends TextButton {

	private HandlerRegistration handlerRegistration;

	private ZButton(ButtonCellAppearance<String> appearance) {
		super(appearance != null ? new TextButtonCell(appearance) : new TextButtonCell());
	}

	public void removeHandler() {
		if (handlerRegistration != null) this.handlerRegistration.removeHandler();
	}

	public void setHandlerRegistration(HandlerRegistration handlerRegistration) {
		this.handlerRegistration = handlerRegistration;
	}

	public static class Builder {

		private String text;

		private String tooltip;

		private ImageResource icon;

		private Integer width;

		private Integer height;

		private boolean visible = true;

		private boolean enable = true;

		private SelectEvent.SelectHandler handler;

		private ButtonCellAppearance<String> appearance;

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder tooltip(String tooltip) {
			this.tooltip = tooltip;
			return this;
		}

		public Builder icon(ImageResource icon) {
			this.icon = icon;
			return this;
		}

		public Builder width(Integer width) {
			this.width = width;
			return this;
		}

		public Builder height(Integer height) {
			this.height = height;
			return this;
		}

		public Builder handler(SelectEvent.SelectHandler handler) {
			this.handler = handler;
			return this;
		}

		public Builder visible(boolean visible) {
			this.visible = visible;
			return this;
		}

		public Builder enable(boolean enable) {
			this.enable = enable;
			return this;
		}

		public Builder appearance(ButtonCellAppearance<String> appearance) {
			this.appearance = appearance;
			return this;
		}

		public ZButton build() {
			ZButton b = new ZButton(appearance);
			if (text != null) {
				b.setText(text);
			}
			if (tooltip != null) {
				b.setToolTip(tooltip);
			}
			if (icon != null) {
				b.setIcon(icon);
			}
			if (width != null) {
				b.setWidth(width);
			}
			if (height != null) {
				b.setHeight(height);
			}
			if (handler != null) {
				b.setHandlerRegistration(b.addSelectHandler(handler));
			}
			if (!visible) {
				b.setVisible(false);
			}
			if (!enable) {
				b.setEnabled(false);
			}
			return b;
		}
	}
}
