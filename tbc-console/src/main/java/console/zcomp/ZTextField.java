package console.zcomp;

import com.google.gwt.event.dom.client.KeyPressHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.Validator;
import com.sencha.gxt.widget.core.client.form.validator.MaxLengthValidator;

public class ZTextField extends TextField {

	private ZTextField() {}

	@Override
	public String getValue() {
		if (super.getCurrentValue() == null) {
			return super.getValue();
		}
		return super.getCurrentValue();
	}

	public static class Builder {
		private ZTextField field;

		private String emptyText;

		private String toolTip;

		private int width;

		private int height;

		private boolean enabled = true;

		private int maxLength;

		private boolean required;

		private Validator<String> validator;

		private KeyPressHandler keyPressHandler;

		public Builder() {
			field = new ZTextField();
		}

		public Builder emptyText(String emptyText) {
			this.emptyText = emptyText;
			return this;
		}

		public Builder toolTip(String toolTip) {
			this.toolTip = toolTip;
			return this;
		}

		public Builder width(int width) {
			this.width = width;
			return this;
		}

		public Builder height(int height) {
			this.height = height;
			return this;
		}

		public Builder enable(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Builder maxLength(int maxLength) {
			this.maxLength = maxLength;
			return this;
		}

		public Builder required(boolean required) {
			this.required = required;
			return this;
		}

		public Builder validator(Validator<String> validator) {
			this.validator = validator;
			return this;
		}

		public Builder keyPressHandler(KeyPressHandler keyPressHandler) {
			this.keyPressHandler = keyPressHandler;
			return this;
		}

		public ZTextField build() {
			if (emptyText != null) {
				field.setEmptyText(emptyText);
			}
			if (toolTip != null) {
				field.setToolTip(toolTip);
			}
			if (width > 0) {
				field.setWidth(width);
			}
			if (height > 0) {
				field.setHeight(height);
			}
			if (!enabled) {
				field.setEnabled(false);
			}
			if (maxLength > 0) {
				field.addValidator(new MaxLengthValidator(maxLength));
			}
			if (validator != null) {
				field.addValidator(validator);
			}
			if (keyPressHandler != null) {
				field.addKeyPressHandler(keyPressHandler);
			}

			field.setAllowBlank(!required);

			return field;
		}
	}
}
