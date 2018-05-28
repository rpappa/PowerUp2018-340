package com.rpappa.led;

import edu.wpi.first.wpilibj.I2C;

public class LEDDriver {
	private I2C i2c;
	
	private static class Registers {
		// list of static registers
		public static final int STATUS = 		0x00;
		public static final int COUNT = 		0x01;
		public static final int MODE =			0x02;
		public static final int BRIGHTNESS = 	0x03;
		public static final int[] DATAS = new int[] {0x04, 0x05, 0x06, 0x07};
	}
	
	public LEDDriver(int deviceAddress) {
		i2c = new I2C(I2C.Port.kOnboard, deviceAddress);
	}
	
	public byte getStatus() {
		byte[] temp = new byte[1];
		i2c.read(Registers.STATUS, 1, temp);
		return temp[0];
	}
	
	public void setMode(int mode) {
		i2c.write(Registers.MODE, mode);
	}
	
	public void setCount(int count) {
		i2c.write(Registers.COUNT, count);
	}
	
	public void setBrightness(int brightness) {
		i2c.write(Registers.BRIGHTNESS, brightness);
	}
	
	public void setData(int data, int value) {
		i2c.write(Registers.DATAS[data], value);
	}
	
	public void setRGB(int[] rgb) {
		setData(0, rgb[0]);
		setData(1, rgb[1]);
		setData(2, rgb[2]);
	}
}
