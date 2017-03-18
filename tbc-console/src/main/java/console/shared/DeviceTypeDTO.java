package console.shared;

import com.google.gwt.core.shared.GwtIncompatible;
import com.google.gwt.user.client.rpc.IsSerializable;
import models.DeviceType;

public enum DeviceTypeDTO implements IsSerializable {
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
