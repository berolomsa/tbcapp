package console.shared;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import models.Device;
import services.DeviceManager;
import services.SystemUserManager;

import javax.inject.Inject;
import java.util.List;

public class DeviceServiceImpl extends RemoteServiceServlet implements DeviceService {

	@Inject
	private DeviceManager deviceManager;

	@Inject
	private SystemUserManager systemUserManager;

	@Override
	public List<DeviceDTO> findDevices(Boolean showTablos) {
		List<Device> devices = deviceManager.findDevices(showTablos);
		return DeviceDTO.getDTOS(devices);
	}

	@Override
	public boolean checkUser(String username, String password) {
		return systemUserManager.checkUser(username, password);
	}

	@Override
	public void addDevice(DeviceDTO deviceDTO) {
		deviceManager.addDevice(DeviceDTO.get(deviceDTO));
	}
}
