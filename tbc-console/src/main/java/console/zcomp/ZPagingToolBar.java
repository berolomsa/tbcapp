package console.zcomp;

import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;

import java.util.ArrayList;
import java.util.List;

public class ZPagingToolBar extends PagingToolBar {

	private ZPagingToolBar(int pageSize) {
		super(pageSize);
	}

	public static class Builder<T> {

		private PagingLoader<PagingLoadConfig, PagingLoadResult<T>> loader;

		private String tooltip = "numberOfRecordsOnOnePage";

		private List<Integer> possibleValues = new ArrayList<Integer>(){{add(20); add(100); add(200); add(500);}};

		public Builder(PagingLoader<PagingLoadConfig, PagingLoadResult<T>> loader) {
			this.loader = loader;
		}

		public Builder tooltip(String tooltip) {
			this.tooltip = tooltip;
			return this;
		}

		public Builder possibleValue(List<Integer> possibleValues) {
			this.possibleValues = possibleValues;
			return this;
		}

		public ZPagingToolBar build() {
			final ZPagingToolBar pagingToolBar = new ZPagingToolBar(possibleValues.get(0));
			pagingToolBar.bind(loader);

			ZSimpleComboBox pageSizeCombo = new ZSimpleComboBox.Builder<Integer>()
					.keyProvider(new ModelKeyProvider<Integer>() {
						@Override
						public String getKey(Integer value) {
							return String.valueOf(value);
						}
					})
					.labelProvider(new LabelProvider<Integer>() {
						@Override
						public String getLabel(Integer value) {
							return String.valueOf(value);
						}
					})
					.values(possibleValues)
					.width(60)
					.build();

			if (tooltip != null) {
				pageSizeCombo.setTitle(tooltip);
			}
			//noinspection unchecked
			pageSizeCombo.addSelectionHandler(new ZSimpleComboBox.SelectionHandler<Integer>() {
				@Override
				public void onSelection(Integer value) {
					pagingToolBar.setPageSize(value);
					pagingToolBar.bind(loader);
					pagingToolBar.refresh();
				}
			});
			pagingToolBar.insert(pageSizeCombo, 10);
			pagingToolBar.insert(new SeparatorToolItem(), 11);

			return pagingToolBar;
		}
	}
}
