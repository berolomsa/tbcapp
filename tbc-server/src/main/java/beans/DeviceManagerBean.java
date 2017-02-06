package beans;

import models.Device;
import models.DeviceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DeviceManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Stateless
public class DeviceManagerBean implements DeviceManager {

	@PersistenceContext
	private EntityManager em;

	private static final Logger log = LoggerFactory.getLogger(DeviceManagerBean.class);

	private static final int delta = 500;

	private final int differenceInMinutes = 5;

	public Device getDevice(String imei) {
		Query query = em.createQuery("SELECT d from Device d where d.imei =:imei");
		query.setParameter("imei", imei);

		List<Device> deviceList = query.getResultList();

		if (deviceList.isEmpty()) {
			log.info("Couldn't find device with imei=" + imei);
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
		Device merged = getDevice(device.getImei());
		if (merged != null) {
			checkIfProblematic(device, merged);
			merged.setHomeless(device.isHomeless());
			merged.setHomeless2(device.isHomeless2());
			merged.setClientIP(device.getClientIP());
			em.merge(merged);
		}
	}

	// TABLO TYPE DEVICE PROBLEM
	// Check Voltage * Current
	// if equals no problem
	// if not we got problem
	// HOMELESS TYPE DEVICE PROBLEM
	// If isHomeless=1 or isHomeless2=1 for 15 minutes it means problem
	private void checkIfProblematic(Device device, Device merged) {
		if (merged.getDeviceType().equals(DeviceType.TABLO)) {
			if (merged.getCurrent() == 0 && merged.getVoltage() == 0) {
				merged.setCurrent(device.getCurrent());
				merged.setVoltage(device.getVoltage());
				merged.setProblematic(false);
			} else {
				if (merged.getCurrent() !=0 && merged.getVoltage() !=0) {
					int multiplyNormal = merged.getCurrent() * merged.getVoltage();
					int multiplyCurrent  = device.getVoltage() * device.getCurrent();
					if (multiplyCurrent > multiplyNormal - delta && multiplyCurrent < multiplyNormal + delta ) {
						merged.setProblematic(true);
					} else {
						merged.setProblematic(false);
					}
				}
			}
		} else {
			if (device.isHomeless() || device.isHomeless2()) {
				if (merged.getLastHomelessDate() == null) {
					merged.setLastHomelessDate(new Date());
					merged.setProblematic(false);
				} else {
					long duration  = (new Date()).getTime() - merged.getLastHomelessDate().getTime();
					long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
					if (diffInMinutes >= differenceInMinutes) {
						merged.setProblematic(true);
					} else {
						merged.setProblematic(false);
					}
				}
			} else {
				merged.setLastHomelessDate(null);
				merged.setProblematic(false);
			}
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
