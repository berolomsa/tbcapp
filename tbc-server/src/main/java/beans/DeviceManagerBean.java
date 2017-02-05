package beans;

import models.Device;
import models.DeviceType;
import services.DeviceManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DeviceManagerBean implements DeviceManager {

	@PersistenceContext
	private EntityManager em;

	public Device getDevice(String imei){
		Query query = em.createQuery("SELECT d from Device d where d.imei =:imei");
		query.setParameter("imei", imei);

		List<Device> deviceList = query.getResultList();

		if (deviceList.isEmpty()) {
			return null;
		} else {
			return deviceList.get(0);
		}
	}

	public void addDevice(Device device) {
		if (getDevice(device.getImei()) == null) {
			em.merge(device);
		}
	}

	public void updateDevice(Device device) {
		Device findDevice = getDevice(device.getImei());
		if (findDevice != null) {
			findDevice.setHomeless(device.isHomeless());
			findDevice.setHomeless2(device.isHomeless2());
			findDevice.setCurrent(device.getCurrent());
			findDevice.setVoltage(device.getVoltage());
			em.merge(findDevice);
		}
	}

	@Override
	public List<Device> findDevices(Boolean showTablos) {
		DeviceType deviceType = DeviceType.HOMELESS;
		if (showTablos) {
			deviceType = DeviceType.TABLO;
		}
		Query query = em.createQuery("SELECT d from Device d where d.deviceType =:deviceType");
		query.setParameter("deviceType", deviceType);

		return query.getResultList();
	}
}
