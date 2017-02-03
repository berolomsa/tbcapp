package console.shared;

import com.google.gwt.core.shared.GwtIncompatible;
import models.Device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeviceDTO implements Serializable {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public static DeviceDTO getDTO(Device userGroup) {
		if (userGroup == null) {
			return null;
		}
		DeviceDTO dto = new DeviceDTO();
		dto.setId(userGroup.getId());
		return dto;
	}

	@GwtIncompatible
	public static Device get(DeviceDTO dto) {
		if (dto == null) {
			return null;
		}
		Device userGroup = new Device();
		userGroup.setId(dto.getId());
		return userGroup;
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