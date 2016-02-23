package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class CANMotor 
{
	private CANTalon motor;

	public CANMotor(CANTalon _motor)
	{
		motor = _motor);
	}
	public void setSpeed (double speed)
	{
		motor.set(speed);
	}

}