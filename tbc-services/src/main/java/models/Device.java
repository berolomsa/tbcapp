package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Device")
public class Device {

	private long id;

	private String imei;

	private int voltage = 0;

	private int current = 0;

	private boolean isHomeless = false;

	private boolean isHomeless2 = false;

	private String address;

	private DeviceType deviceType;

	private String mobile;

	private boolean problematic = false;

	private String clientIP;

	@Column(nullable = true)
	private Date lastHomelessDate = null;

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

	public boolean isProblematic() {
		return problematic;
	}

	public void setProblematic(boolean problem) {
		this.problematic = problem;
	}

	public Date getLastHomelessDate() {
		return lastHomelessDate;
	}

	public void setLastHomelessDate(Date lastHomelessDate) {
		this.lastHomelessDate = lastHomelessDate;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	@Override
	public String toString() {
		return "Device{" +
				", deviceType=" + deviceType +
				", isHomeless2=" + isHomeless2 +
				", isHomeless=" + isHomeless +
				", current=" + current +
				", voltage=" + voltage +
				", imei='" + imei + '\'' +
				", id=" + id +
				'}';
	}
}

