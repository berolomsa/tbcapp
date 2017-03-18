package console.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("DeviceService")
public interface DeviceService extends RemoteService {
	List<DeviceDTO> findDevices(Boolean showTablos);

	boolean checkUser(String username, String password);

	void addDevice(DeviceDTO deviceDTO);

	void deleteDevice(long id);
}