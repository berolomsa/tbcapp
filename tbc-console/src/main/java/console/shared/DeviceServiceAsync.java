package console.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface DeviceServiceAsync {
	void findDevices(Boolean showTablos, AsyncCallback<List<DeviceDTO>> async);

	void checkUser(String username, String password, AsyncCallback<Boolean> async);

	void addDevice(DeviceDTO deviceDTO, AsyncCallback<Void> async);
}
