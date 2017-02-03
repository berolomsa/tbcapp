package console.zcomp;

import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;

public class ZFieldLabel extends FieldLabel {

	private static final String REQUIRED_STYLE = "<span style='color: red'>*</span>";

	private IsWidget field;

	private ZFieldLabel() {}

	public IsWidget getField() {
		return field;
	}

	public void setField(IsWidget field) {
		this.field = field;
	}

	public static class Builder {
		private ZFieldLabel fieldLabel;
		private IsWidget field;
		private String label;
		private String labelHtml;
		private int height = 22;
		private int width;
		private String widthStr;
		private int labelWidth;
		private boolean enabled = true;
		private boolean visible = true;
		private boolean required;
		private FormPanel.LabelAlign labelAlign = FormPanel.LabelAlign.LEFT;
		private String separator = ":";
		private String styleName;

		public Builder() {
			fieldLabel = new ZFieldLabel();
		}

		public Builder field(IsWidget field) {
			this.field = field;
			return this;
		}

		public Builder separator(String separator) {
			this.separator = separator;
			return this;
		}

		public Builder label(String label) {
			this.label = label;
			return this;
		}

		public Builder labelHtml(String labelHtml) {
			this.labelHtml = labelHtml;
			return this;
		}

		public Builder height(int height) {
			this.height = height;
			return this;
		}

		public Builder width(int width) {
			this.width = width;
			return this;
		}

		public Builder widthStr(String widthStr) {
			this.widthStr = widthStr;
			return this;
		}

		public Builder labelWidth(int labelWidth) {
			this.labelWidth = labelWidth;
			return this;
		}

		public Builder enabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Builder visible(boolean visible) {
			this.visible = visible;
			return this;
		}

		public Builder labelAlign(FormPanel.LabelAlign labelAlign) {
			this.labelAlign = labelAlign;
			return this;
		}

		public Builder required() {
			this.required(true);
			return this;
		}

		public Builder required(boolean required) {
			this.required = required;
			return this;
		}

		public Builder style(String styleName) {
			this.styleName = styleName;
			return this;
		}

		public ZFieldLabel build() {
			fieldLabel.setLabelAlign(labelAlign);
			fieldLabel.setLabelWordWrap(true);
			fieldLabel.setLabelPad(0);
			fieldLabel.setVisible(visible);
			fieldLabel.setLabelSeparator(separator);
			fieldLabel.setDeferHeight(true);

			if (field != null) {
				fieldLabel.setWidget(field);
				fieldLabel.setField(field);
			}
			if (label != null) {
				fieldLabel.setText(label);
			}
			if (labelHtml != null) {
				fieldLabel.setHTML(labelHtml);
			}
			if (widthStr != null) {
				fieldLabel.setWidth(widthStr);
			} else if (width > 0) {
				fieldLabel.setWidth(width);
			}
			if (labelWidth > 0) {
				fieldLabel.setLabelWidth(labelWidth);
			}
			if (height > 0) {
				fieldLabel.setHeight(height);
			}
			if (!enabled) {
				fieldLabel.setEnabled(false);
			}
			if (styleName != null) {
				fieldLabel.setStylePrimaryName(styleName);
			}
			if (required) {
				fieldLabel.setHTML(SafeHtmlUtils.fromTrustedString(labelHtml == null  ? label + REQUIRED_STYLE : labelHtml + REQUIRED_STYLE));
			}
			return fieldLabel;
		}
	}
}