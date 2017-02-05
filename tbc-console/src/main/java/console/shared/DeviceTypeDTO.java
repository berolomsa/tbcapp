package console.shared;

import com.google.gwt.core.shared.GwtIncompatible;
import models.DeviceType;

import java.io.Serializable;

public enum DeviceTypeDTO implements Serializable {
	TABLO,
	HOMELESS;


	@GwtIncompatible
	public static DeviceType getDeviceType(DeviceTypeDTO deviceTypeDTO) {
		if(deviceTypeDTO == null) return null;
		return DeviceType.valueOf(deviceTypeDTO.toString());
	}

	@GwtIncompatible
	public static DeviceTypeDTO getDeviceTypeDTO(DeviceType deviceType) {
		if(deviceType == null) return null;
		return DeviceTypeDTO.valueOf(deviceType.toString());
	}
}
