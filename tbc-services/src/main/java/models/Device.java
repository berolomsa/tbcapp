package models;

import javax.persistence.*;

@Entity
@Table(name = "Device")
public class Device {

	private long id;

	private String imei;

	private int voltage;

	private int current;

	private boolean isHomeless;

	private boolean isHomeless2;

	private DeviceType deviceType;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Enumerated(EnumType.STRING)
	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType type) {
		this.deviceType = type;
	}


}
