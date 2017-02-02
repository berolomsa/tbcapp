package console.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Application implements EntryPoint {
	@Override
	public void onModuleLoad() {
		LoginView loginPage = new LoginView();
		RootLayoutPanel.get().add(loginPage);
	}
}