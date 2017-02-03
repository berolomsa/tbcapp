package console.zcomp;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;

import java.util.Date;

public class ZDateField extends DateField {

	private ZDateField() {}

	public static class Builder {
		private ZDateField field;
		private Date value;
		private int width = 150;
		private boolean required;
		private boolean enabled = true;
		private String emptyText;

		private String pattern = "dd/MM/yyyy";

		public Builder() {
			field = new ZDateField();
			field.addKeyDownHandler(new KeyDownHandler() {
				@Override
				public void onKeyDown(KeyDownEvent event) {
					if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
						field.finishEditing();
						field.sinkEvents(KeyCodes.KEY_ENTER);
					}
				}
			});
		}

		public Builder pattern(String pattern) {
			this.pattern = pattern;
			return this;
		}

		public Builder value(Date value) {
			this.value = value;
			return this;
		}

		public Builder width(int width) {
			this.width = width;
			return this;
		}

		public Builder required() {
			this.required = true;
			return this;
		}

		public Builder required(boolean required) {
			this.required = required;
			return this;
		}

		public Builder emptyText(String emptyText) {
			this.emptyText = emptyText;
			return this;
		}

		public Builder enabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public ZDateField build() {
			if (pattern != null) {
				field.setPropertyEditor(new DateTimePropertyEditor(pattern));
			}
			if (value != null) {
				field.setValue(value);
			}
			if (width > 0) {
				field.setWidth(width);
			}
			if (emptyText != null) {
				field.setEmptyText(emptyText);
			}
			field.setAllowBlank(!required);
			field.setEnabled(enabled);

			field.getDatePicker().addStyleName("z-DATE-field-style");
			return field;
		}
	}
}
