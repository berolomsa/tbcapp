package services;

import models.Device;

public interface DeviceManager {

	Device getDevice(String imei);

	void updateDevice(Device device);
}
