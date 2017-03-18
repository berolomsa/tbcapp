import beans.DeviceManagerBean;
import models.Device;
import models.DeviceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DeviceManager;
import utils.EJBUtils;

import java.nio.charset.StandardCharsets;

public class GatewayRequestProcessorFactory implements RequestProcessorFactory {

	private final static Logger log = LoggerFactory.getLogger(GatewayRequestProcessorFactory.class);

	private DeviceManager deviceManagerBean = EJBUtils.getBean(DeviceManagerBean.class);

	@Override
    public String process(PacketData packetData) throws Exception {
		String request = new String(packetData.getPacketData(), StandardCharsets.UTF_8);
		if (request.charAt(0) =='#' && request.charAt(request.length()-1) == '*') {
			request = request.substring(1,request.length()-1);
			String[] params = request.split(",");
			String imei = params[0];
			Integer voltage = Integer.parseInt(params[1]);
			Integer current = Integer.parseInt(params[2]);
			String isHomeless = params[3];
			String isHomeless2 = params[4];
			String deviceType = params[5];

			Device device = new Device();
			device.setCurrent(current);
			device.setVoltage(voltage);
			device.setHomeless(false);
			device.setHomeless2(false);
			if (isHomeless.equals("1")) {
				device.setHomeless(true);
			}
			if (isHomeless2.equals("1")) {
				device.setHomeless2(true);
			}
			device.setImei(imei);
			device.setDeviceType(DeviceType.values()[Integer.parseInt(deviceType)]);
			device.setClientIP(packetData.getClientIP());
			log.info("Client IP: " + packetData.getClientIP() + ", msg:" + device.toString());
			deviceManagerBean.updateDevice(device);
			return imei;
	 	} else {
			return null;
		}

    }

	@Override
	public void inactiveDevice(String imei) {
		deviceManagerBean.inactiveDevice(imei);
	}

}