package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Joystick;

public class MyJoystick {
	private Joystick myJoystick;

	public MyJoystick(int channel) {

		myJoystick = new Joystick(channel);
	}

	public double getY() {
		return myJoystick.getRawAxis(1);
	}
		public double getx() {
			return myJoystick.getRawAxis(0);
	}
		public double getZ(){
		return myJoystick.getRawAxis(2);	
		}

	public boolean isButtonPressed(int button) {
	 return myJoystick.getRawButton(button);
	}
}

	


