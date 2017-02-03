package console.zcomp;

import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.tips.QuickTip;

public class ZGrid<T> extends Grid<T> {

	public ZGrid(ListStore<T> store, ColumnModel<T> cm) {
		this(store, cm, Style.SelectionMode.SINGLE);
	}

	public ZGrid(ListStore<T> store, ColumnModel<T> cm, Style.SelectionMode selectionMode) {
		super(store, cm, new ZGridView<T>());
		getSelectionModel().setSelectionMode(selectionMode);
		setProperties();
		setRowDoubleClickHandler();
		new QuickTip(this);
	}

	private void setProperties() {
		setAllowTextSelection(true);
	}

	private void setRowDoubleClickHandler() {
		addRowDoubleClickHandler(new RowDoubleClickEvent.RowDoubleClickHandler() {
			@Override
			public void onRowDoubleClick(RowDoubleClickEvent event) {
				ZGrid.this.onRowDoubleClick(event);
			}
		});
	}

	@SuppressWarnings("UnusedParameters")
	protected void onRowDoubleClick(RowDoubleClickEvent event) {}
}

