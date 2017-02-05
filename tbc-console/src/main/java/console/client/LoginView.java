package console.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import console.shared.DeviceService;
import console.shared.DeviceServiceAsync;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {}

	@UiField
	Label errorLabel;

	@UiField
	HTMLPanel loginPanel;

	@UiField
	TextField username;
	
	@UiField
	PasswordField password;
	
	@UiField
	TextButton submitButton;

	private DeviceServiceAsync deviceService;
	public LoginView() {
		deviceService = GWT.create(DeviceService.class);
		initWidget(uiBinder.createAndBindUi(this));
		changeStyle();
		initHandler();
		loginPanel.setVisible(true);
	}

	private void initHandler() {
	    KeyDownHandler handler = new KeyDownHandler() {
	    	@Override
			public void onKeyDown(KeyDownEvent event) {
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					deviceService.checkUser(username.getCurrentValue(), password.getCurrentValue(), new AsyncCallback<Boolean>() {
						@Override
						public void onFailure(Throwable caught) {

						}

						@Override
						public void onSuccess(Boolean result) {
							if (result) {
								RootLayoutPanel.get().remove(0);
								RootLayoutPanel.get().add(new DevicesPage());
							} else {
								new MessageBox("ხარვეზი","მომხმარებლის სახელი ან პაროლი არასწორია").show();
							}
						}
					});
				}
			}
		};
		username.addKeyDownHandler(handler);
	    password.addKeyDownHandler(handler);
	}

	private void changeStyle() {
		username.setWidth("430px");
		username.setHeight("25px");
		password.setWidth("430px");
		password.setHeight("25px");
	}
	
	@UiHandler("submitButton")
	public void onSubmitClicked(@SuppressWarnings("UnusedParameters") SelectEvent e) {
		DomEvent.fireNativeEvent(Document.get().createKeyDownEvent(false, false, false, false, KeyCodes.KEY_ENTER), password);
	}
}
