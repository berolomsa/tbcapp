package console.zcomp;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesBuilder;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;

public class ZColumnConfig {

	public static SafeStylesBuilder safeHtmlBuilder = new SafeStylesBuilder()
			.whiteSpace(Style.WhiteSpace.PRE_WRAP)
			.appendTrustedString("word-wrap: normal;")
			.display(Style.Display.BLOCK);

	@SuppressWarnings("unchecked")
	public static class Builder<T> {
		private ValueProvider valueProvider;
		private AbstractCell cell;
		private int width;
		private String header;
		private boolean fixed = false;
		private boolean hideable = true;
		private boolean groupable = true;
		private boolean sortable = false;
		private String style;
		private SafeStyles safeStyle;

		public Builder() {}

		public Builder(ValueProvider valueProvider) {
			this.valueProvider = valueProvider;
		}

		public Builder<T> valueProvider(ValueProvider valueProvider) {
			this.valueProvider = valueProvider;
			return this;
		}

		public Builder<T> width(int width) {
			this.width = width;
			return this;
		}

		public Builder<T> header(String header) {
			this.header = header;
			return this;
		}

		public Builder<T> fixed() {
			this.fixed = true;
			return this;
		}

		public Builder<T> sortable() {
			this.sortable = true;
			return this;
		}

		public Builder<T> notHideable() {
			this.hideable = false;
			return this;
		}

		public Builder<T> notGroupable() {
			this.groupable = false;
			return this;
		}

		public Builder<T> style(String style) {
			this.style = style;
			return this;
		}

		public Builder<T> safeStyle(SafeStyles safeStyle) {
			this.safeStyle = safeStyle;
			return this;
		}

		public Builder<T> cell(AbstractCell cell) {
			this.cell = cell;
			return this;
		}

		public ColumnConfig<T, String> build() {
			ColumnConfig<T, String> config;
			if (valueProvider != null) {
				config = new ColumnConfig<>(valueProvider);
			} else {
				config = new ColumnConfig<>(new ZEmptyValueProvider());
			}
			if (safeStyle != null) {
				config.setColumnTextStyle(safeStyle);
			} else {
				config.setColumnTextStyle(ZColumnConfig.safeHtmlBuilder.toSafeStyles());
			}
			if (style != null) {
				config.setColumnTextClassName(style);
			}
			if (cell != null) {
				config.setCell(cell);
			}
			if (width > 0) {
				config.setWidth(width);
			}
			if (header != null) {
				config.setHeader(header);
			}
			config.setSortable(sortable);
			config.setFixed(fixed);
			config.setGroupable(groupable);
			config.setHideable(hideable);
			return config;
		}
	}
}
