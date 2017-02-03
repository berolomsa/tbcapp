package console.zcomp;

import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;

public class ZNumberField<N extends Number> extends NumberField<N> {

	private ZNumberField(NumberPropertyEditor<N> editor) {
		super(editor);
	}

	public static class Builder<N extends Number> {
		NumberPropertyEditor editor;

		private String emptyText;
		private Integer width;
		private Integer height;
		private boolean required;
		private boolean allowNegative;
		private boolean enabled = true;

		public Builder(NumberPropertyEditor<N> editor) {
			this.editor = editor;
		}

		public Builder<N> emptyText(String emptyText) {
			this.emptyText = emptyText;
			return this;
		}

		public Builder<N> width(Integer width) {
			this.width = width;
			return this;
		}

		public Builder<N> height(Integer height) {
			this.height = height;
			return this;
		}

		public Builder<N> required() {
			return required(true);
		}

		public Builder<N> required(boolean required) {
			this.required = required;
			return this;
		}

		public Builder<N> allowNegative(boolean allowNegative) {
			this.allowNegative = allowNegative;
			return this;
		}

		public Builder<N> enabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public ZNumberField<N> build() {
			//noinspection unchecked
			ZNumberField<N> field = new ZNumberField<>(editor);
			if (emptyText != null) {
				field.setEmptyText(emptyText);
			}
			if (width != null) {
				field.setWidth(width);
			}
			if (height != null) {
				field.setHeight(height);
			}
			if (required) {
				field.setAllowBlank(false);
			}

			field.setEnabled(enabled);

			field.setAllowNegative(allowNegative);

			return field;
		}
	}
}