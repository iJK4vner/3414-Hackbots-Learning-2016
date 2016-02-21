package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Joystick;

public class MyJoystick {
	public Joystick myJoystick;

	public MyJoystick() {

		myJoystick = new Joystick(1);
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

	


