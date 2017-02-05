package console.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import console.client.resources.IconsFactory;
import console.shared.DeviceDTO;
import console.shared.DeviceServiceAsync;
import console.shared.DeviceTypeDTO;
import console.zcomp.ZButton;
import console.zcomp.ZFieldLabel;
import console.zcomp.ZSimpleComboBox;
import console.zcomp.ZTextField;

import java.util.Arrays;

public class DeviceAddWindow extends Window {

	private DeviceDTO device = new DeviceDTO();

	private ZTextField imei;

	private ZSimpleComboBox<DeviceTypeDTO> typeCombo;
	
	private ZTextField mobile;

	private ZTextField address;

	private int fieldWidth = 250;

	private DeviceServiceAsync service;

	public DeviceAddWindow(DeviceServiceAsync service) {
		this.service = service;
		imei = new ZTextField.Builder()
				.width(fieldWidth)
				.maxLength(15)
				.required(true)
				.build();
		typeCombo = new ZSimpleComboBox.Builder<DeviceTypeDTO>()
					.values(Arrays.asList(DeviceTypeDTO.values()))
					.labelProvider(new LabelProvider<DeviceTypeDTO>() {
						@Override
						public String getLabel(DeviceTypeDTO item) {
							if (item.equals(DeviceTypeDTO.HOMELESS)) {
								return "დეტექტორი";
							} else {
								return "მონიტორინგი";
							}
						}
					})
					.keyProvider(new ModelKeyProvider<DeviceTypeDTO>() {
						@Override
						public String getKey(DeviceTypeDTO item) {
							return item.name();
						}
					})
					.width(fieldWidth + 5)
					.required(true)
					.build();

		mobile = new ZTextField.Builder()
				.width(fieldWidth)
				.required(true)
				.build();

		address = new ZTextField.Builder()
				.width(fieldWidth)
				.required(true)
				.build();

		initWindow();

	}

	private void initWindow() {
		setHeadingText("მოწყობილობის დამატება");
		setHeight(240);
		setWidth(500);
		setModal(true);
		setBodyBorder(false);
		setResizable(false);
		setClosable(true);
		setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);
		initContainer();
		getButtonBar().setSpacing(10);
	}

	private void initContainer() {
		VerticalLayoutContainer container = new VerticalLayoutContainer();
		container.add(new ZFieldLabel.Builder().label("მოწყობილობის ტიპი").labelWidth(150).field(typeCombo).width(410).height(70).required().build());
		container.add(new ZFieldLabel.Builder().label("იმეი-კოდი").labelWidth(150).field(imei).width(410).height(22).required().build());
		container.add(new ZFieldLabel.Builder().label("მისამართი").labelWidth(150).field(address).width(410).height(22).required().build());
		container.add(new ZFieldLabel.Builder().label("ტელ").labelWidth(150).field(mobile).width(410).height(70).required().build());

		setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);

		getButtonBar().add(saveButton());
		getButtonBar().add(closeButton());

		add(container, new MarginData(10));
	}


	private ZButton closeButton() {
		return new ZButton.Builder()
				.icon(IconsFactory.getIcons().cancel())
				.text("დახურვა")
				.handler(new SelectEvent.SelectHandler() {
					@Override
					public void onSelect(SelectEvent event) {
						DeviceAddWindow.this.hide();
					}
				})
				.build();
	}

	private ZButton saveButton() {
		return new ZButton.Builder()
				.icon(IconsFactory.getIcons().save())
				.text("შენახვა")
				.handler(new SelectEvent.SelectHandler() {
					@Override
					public void onSelect(SelectEvent event) {
						if (isValid(mobile.getCurrentValue()) && isValid(address.getCurrentValue()) && isValidIMEI(imei.getCurrentValue())) {
							device.setAddress(address.getCurrentValue());
							device.setImei(imei.getCurrentValue());
							device.setMobile(mobile.getCurrentValue());
							device.setDeviceTypeDTO(typeCombo.getCurrentValue());
							service.addDevice(device, new AsyncCallback<Void>() {
								@Override
								public void onFailure(Throwable caught) {

								}

								@Override
								public void onSuccess(Void result) {
									DeviceAddWindow.this.hide();
								}
							});
						} else {
							new MessageBox("ხარვეზი", "შეყვანილი პარამეტრები არასწორია").show();
						}
					}
				})
				.build();
	}

	private boolean isValidIMEI(String currentValue) {
		return currentValue != null && currentValue.length() == 15 && currentValue.matches("\\d+");
	}

	public boolean isValid(String s) {
		return s != null && !s.isEmpty();
	}
}
