package console.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.tips.QuickTip;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import console.client.resources.IconsFactory;
import console.shared.DeviceDTO;
import console.zcomp.*;
import console.zcomp.helper.GridClickHandler;

import java.util.ArrayList;
import java.util.List;

public class DevicesPage extends Composite {

	interface DevicesPageUiBinder extends UiBinder<Widget, DevicesPage> {}

	private static DevicesPageUiBinder uiBinder = GWT.create(DevicesPageUiBinder.class);

	@UiField(provided = true)
	ToolBar toolbar;

	@UiField(provided = true)
	TextField name =  new TextField();

	@UiField(provided = true)
	ZButton searchButton;

	@UiField(provided = true)
	TextButton addButton = new TextButton();

	@UiField(provided = true)
	Grid<DeviceDTO> grid;

	@UiField(provided = true)
	PagingToolBar paging;

	@UiField(provided = true)
	SeparatorToolItem separator1;

	@UiField(provided = true)
	SeparatorToolItem separator2;

	interface GridProperties extends PropertyAccess<DeviceDTO> {
		ModelKeyProvider<DeviceDTO> id();
		ValueProvider<DeviceDTO, String> fullName();
		ValueProvider<DeviceDTO, String> username();
	}

	private static GridProperties gridProps = GWT.create(GridProperties.class);

	private ListStore<DeviceDTO> gridStore = new ListStore<>(gridProps.id());

	private PagingLoader<PagingLoadConfig, PagingLoadResult<DeviceDTO>> loader;


	public DevicesPage() {
		initToolbar();
		initGrid();
		initPaging();
		initWidget(uiBinder.createAndBindUi(this));
		loader.load();
	}

	@SuppressWarnings("unchecked")
	private void initToolbar () {
		name.setEmptyText("Name");
		name.setWidth(200);

		searchButton = new  ZButton.Builder()
				.icon(IconsFactory.getIcons().search())
				.tooltip("Search")
				.handler(new SelectEvent.SelectHandler() {
					@Override
					public void onSelect(SelectEvent event) {
						loader.load();
					}
				})
				.build();

		addButton.setIcon(IconsFactory.getIcons().add());
		addButton.setToolTip("add");
		addButton.addSelectHandler(new SelectEvent.SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {

			}
		});

		separator1 = new SeparatorToolItem();
		separator2 = new SeparatorToolItem();
		toolbar = new ToolBar();
		toolbar.setSpacing(0);
		toolbar.setVerticalSpacing(5);

		new EnterKeyBinder.Builder(searchButton)
				.add(name)
				.bind();
	}

	private void initGrid() {
		RpcProxy<PagingLoadConfig, PagingLoadResult<DeviceDTO>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<DeviceDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, final AsyncCallback<PagingLoadResult<DeviceDTO>> callback) {
//				ServicesFactory.getDeviceService().findUsers(name.getValue(), userName.getValue(), comboBox.getValue() == null ? null : comboBox.getValue().getId(), loadConfig, new ServiceCallback<PagingLoadResult<DeviceDTO>>() {
//					@Override
//					public void onServiceSuccess(PagingLoadResult<DeviceDTO> result) {
//						callback.onSuccess(result);
//					}
//				});
			}
		};
		grid = new Grid<>(gridStore, getColumns(), new ZGridView<DeviceDTO>());
		new QuickTip(grid);

		loader = new PagingLoader<>(proxy);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, DeviceDTO, PagingLoadResult<DeviceDTO>>(gridStore));
		grid.setAllowTextSelection(true);
		grid.setLoader(loader);
		grid.getView().setColumnLines(true);
		grid.getView().setAutoFill(true);
		grid.getView().setForceFit(true);
	}

	private ColumnModel<DeviceDTO> getColumns() {
		List<ColumnConfig<DeviceDTO, ?>> columns = new ArrayList<>();
		columns.add(getUserNameColumn());
		columns.add(getFullNameColumn());
		columns.add(getEditColumn());
		columns.add(getDeleteColumn());

		return new ColumnModel<>(columns);
	}

    private ColumnConfig<DeviceDTO, ?> getDeleteColumn() {
		ColumnConfig<DeviceDTO, String> deleteColumn = new ColumnConfig<>(new ZEmptyValueProvider<DeviceDTO,String>(),35);
		deleteColumn.setCell(new ZIconButtonCell.Builder<DeviceDTO, String>()
				.gridStore(gridStore)
				.icon(IconsFactory.getIcons().delete())
				.tooltip("Delete")
				.clickHandler(new GridClickHandler<DeviceDTO>() {
					@Override
					public void onClick(Cell.Context context, DeviceDTO value) {

					}
				})
				.build());
		deleteColumn.setFixed(true);
		return deleteColumn;
	}

	private ColumnConfig<DeviceDTO, ?> getEditColumn() {
		ColumnConfig<DeviceDTO, String> editColumn = new ColumnConfig<>(new ZEmptyValueProvider<DeviceDTO, String>(),35);
		editColumn.setCell(new ZIconButtonCell.Builder<DeviceDTO, String>()
				.gridStore(gridStore)
				.tooltip("Edit")
				.icon(IconsFactory.getIcons().edit())
				.clickHandler(new GridClickHandler<DeviceDTO>() {
					@Override
					public void onClick(Cell.Context context, DeviceDTO value) {

					}
				})
				.build());
		editColumn.setFixed(true);
		return editColumn;
	}

	private ColumnConfig<DeviceDTO, ?> getFullNameColumn() {
		return new ColumnConfig<>(gridProps.fullName(), 150, "userFullname");
	}

	private ColumnConfig<DeviceDTO, ?> getUserNameColumn() {
		return new ColumnConfig<>(gridProps.username(), 150, "userUsername");
	}


	private void initPaging() {
		paging = new PagingToolBar(20);
		paging.bind(loader);
	}
}
