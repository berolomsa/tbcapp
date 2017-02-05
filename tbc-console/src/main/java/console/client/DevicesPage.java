package console.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.tips.QuickTip;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import console.client.resources.IconsFactory;
import console.shared.DeviceDTO;
import console.shared.DeviceService;
import console.shared.DeviceServiceAsync;
import console.zcomp.ZEmptyValueProvider;
import console.zcomp.ZGridView;
import console.zcomp.ZIconButtonCell;
import console.zcomp.helper.IconSelector;
import console.zcomp.helper.TooltipSelector;

import java.util.ArrayList;
import java.util.List;

public class DevicesPage extends Composite {

	interface DevicesPageUiBinder extends UiBinder<Widget, DevicesPage> {}

	private static DevicesPageUiBinder uiBinder = GWT.create(DevicesPageUiBinder.class);

	@UiField(provided = true)
	ToolBar toolbar;

	@UiField(provided = true)
	TextButton addButton = new TextButton();

	@UiField(provided = true)
	ToggleButton showTablos = new ToggleButton();

	@UiField(provided = true)
	Grid<DeviceDTO> grid;

	@UiField(provided = true)
	PagingToolBar paging;

	@UiField(provided = true)
	SeparatorToolItem separator2;

	interface GridProperties extends PropertyAccess<DeviceDTO> {
		ModelKeyProvider<DeviceDTO> id();
		ValueProvider<DeviceDTO, String> address();
		ValueProvider<DeviceDTO, String> mobile();
	}

	private static GridProperties gridProps = GWT.create(GridProperties.class);

	private ListStore<DeviceDTO> gridStore = new ListStore<>(gridProps.id());

	private PagingLoader<PagingLoadConfig, PagingLoadResult<DeviceDTO>> loader;


	private DeviceServiceAsync deviceService;

	private SoundController soundController;

	private Sound sound;

	public DevicesPage() {
		soundController = new SoundController();
		sound = soundController.createSound(Sound.MIME_TYPE_AUDIO_WAV_UNKNOWN,
				"alert.wav");
		deviceService = GWT.create(DeviceService.class);
		initToolbar();
		initGrid();
		initPaging();
		initWidget(uiBinder.createAndBindUi(this));
		loader.load();
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			@Override
			public void execute() {
				Timer timer = new Timer() {
					@Override
					public void run() {
						grid.getLoader().load();
					}
				};
				timer.scheduleRepeating(10000);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void initToolbar () {
		addButton.setIcon(IconsFactory.getIcons().add());
		addButton.setToolTip("დამატება");
		addButton.addSelectHandler(new SelectEvent.SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				new DeviceAddWindow(deviceService).show();
			}
		});

		showTablos.setText("ტაბლოების გამოჩენა");
		showTablos.addSelectHandler(new SelectEvent.SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				grid.getLoader().load();
			}
		});
		separator2 = new SeparatorToolItem();
		toolbar = new ToolBar();
		toolbar.setSpacing(0);
		toolbar.setVerticalSpacing(5);
	}

	private void initGrid() {
		RpcProxy<PagingLoadConfig, PagingLoadResult<DeviceDTO>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<DeviceDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, final AsyncCallback<PagingLoadResult<DeviceDTO>> callback) {
				deviceService.findDevices(showTablos.getValue(), new AsyncCallback<List<DeviceDTO>>() {
					@Override
					public void onFailure(Throwable caught) {

					}
					@Override
					public void onSuccess(List<DeviceDTO> result) {
						callback.onSuccess(new PagingLoadResultBean<>(result, result.size(), 0));
					}
				});
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
		columns.add(getAddressColumn());
		columns.add(getMobileColumn());
		columns.add(getProblemColumn());
		return new ColumnModel<>(columns);
	}

    private ColumnConfig<DeviceDTO, ?> getProblemColumn() {
		ColumnConfig<DeviceDTO, String> deleteColumn = new ColumnConfig<>(new ZEmptyValueProvider<DeviceDTO,String>(),35);
		deleteColumn.setCell(new ZIconButtonCell.Builder<DeviceDTO, String>()
				.gridStore(gridStore)
				.dynamicIcon(new IconSelector<DeviceDTO>() {
					@Override
					public ImageResource selectIcon(Cell.Context context, DeviceDTO value) {
						if (value.isProblematic()) {
							return IconsFactory.getIcons().deactivate();
						}
						return IconsFactory.getIcons().active();
					}
				})
				.dynamicTooltip(new TooltipSelector<DeviceDTO>() {
					@Override
					public String selectTooltip(Cell.Context context, DeviceDTO value) {
						if (value.isProblematic()) {
							sound.play();
							return "პრობლემა";
						}
						return "წესრიგი";
					}
				})
				.build());
		deleteColumn.setFixed(true);
		return deleteColumn;
	}

	private ColumnConfig<DeviceDTO, ?> getAddressColumn() {
		return new ColumnConfig<>(gridProps.address(), 150, "მისამართი");
	}

	private ColumnConfig<DeviceDTO, ?> getMobileColumn() {
		return new ColumnConfig<>(gridProps.mobile(), 150, "ტელ");
	}

	private void initPaging() {
		paging = new PagingToolBar(20);
		paging.bind(loader);
	}
}
