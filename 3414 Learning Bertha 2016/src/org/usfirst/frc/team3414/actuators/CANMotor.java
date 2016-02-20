package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class CANMotor {
	private CANTalon motor;

	public CANMotor(int channel)
	{
		motor = new CANTalon(channel);
	}
	public void setSpeed (double speed)
	{
		motor.set(speed);
	}

}