package console.shared;

import com.google.gwt.core.shared.GwtIncompatible;
import com.google.gwt.user.client.rpc.IsSerializable;
import models.Device;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceDTO implements IsSerializable {

	private long id;

	private String imei;

	private String address;

	private int voltage;

	private int current;

	private int voltageLive;

	private int currentLive;

	private boolean isHomeless;

	private boolean isHomeless2;

	private String mobile;

	private DeviceTypeDTO deviceTypeDTO;

	private boolean problematic;

	private Date lastReceivedPackageDate;

	private boolean online;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public boolean isHomeless() {
		return isHomeless;
	}

	public void setHomeless(boolean homeless) {
		isHomeless = homeless;
	}

	public boolean isHomeless2() {
		return isHomeless2;
	}

	public void setHomeless2(boolean homeless2) {
		isHomeless2 = homeless2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public DeviceTypeDTO getDeviceTypeDTO() {
		return deviceTypeDTO;
	}

	public void setDeviceTypeDTO(DeviceTypeDTO deviceTypeDTO) {
		this.deviceTypeDTO = deviceTypeDTO;
	}

	public boolean isProblematic() {
		return problematic;
	}

	public void setProblematic(boolean problematic) {
		this.problematic = problematic;
	}

	public Date getLastReceivedPackageDate() {
		return lastReceivedPackageDate;
	}

	public void setLastReceivedPackageDate(Date lastReceivedPackageDate) {
		this.lastReceivedPackageDate = lastReceivedPackageDate;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getCurrentLive() {
		return currentLive;
	}

	public void setCurrentLive(int currentLive) {
		this.currentLive = currentLive;
	}

	public int getVoltageLive() {
		return voltageLive;
	}

	public void setVoltageLive(int voltageLive) {
		this.voltageLive = voltageLive;
	}

	@GwtIncompatible
	public static List<DeviceDTO> getDTOS(List<Device> userGroups) {
		if (userGroups == null) {
			return null;
		}
		List<DeviceDTO> dtos = new ArrayList<>();
		for (Device group : userGroups) {
			dtos.add(getDTO(group));
		}
		return dtos;
	}

	@GwtIncompatible
	public static DeviceDTO getDTO(Device device) {
		if (device == null) {
			return null;
		}
		DeviceDTO dto = new DeviceDTO();
		dto.setId(device.getId());
		dto.setHomeless(device.isHomeless());
		dto.setHomeless2(device.isHomeless2());
		dto.setCurrent(device.getCurrent());
		dto.setVoltage(device.getVoltage());
		dto.setImei(device.getImei());
		dto.setAddress(device.getAddress());
		dto.setMobile(device.getMobile());
		dto.setDeviceTypeDTO(DeviceTypeDTO.getDeviceTypeDTO(device.getDeviceType()));
		dto.setProblematic(device.isProblematic());
		dto.setLastReceivedPackageDate(device.getLastReceivedPackageDate());
		dto.setOnline(device.isOnline());
		dto.setCurrentLive(device.getCurrentLive());
		dto.setVoltageLive(device.getVoltageLive());
		return dto;
	}

	@GwtIncompatible
	public static Device get(DeviceDTO dto) {
		if (dto == null) {
			return null;
		}
		Device device = new Device();
		device.setId(dto.getId());
		device.setImei(dto.getImei());
		device.setMobile(dto.getMobile());
		device.setAddress(dto.getAddress());
		device.setDeviceType(DeviceTypeDTO.getDeviceType(dto.getDeviceTypeDTO()));
		device.setProblematic(dto.isProblematic());

		return device;
	}

	@GwtIncompatible
	public static List<Device> get(List<DeviceDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<Device> groups = new ArrayList<>();
		for (DeviceDTO dto : dtos) {
			groups.add(get(dto));
		}
		return groups;
	}
}