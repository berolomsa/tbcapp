package services;

import models.Device;

import java.util.List;

public interface DeviceManager {

	Device getDevice(String imei);

	void updateDevice(Device device);

	List<Device> findDevices(Boolean showTablos);

	void addDevice(Device device);
}
