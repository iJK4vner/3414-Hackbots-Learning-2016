package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Talon;

public class SingleMotor
{
	private Talon motor;

	public SingleMotor(Talon _motor)
	{
		motor = _motor;
	}
	public void setSpeed (double speed)
	{
		motor.set(speed);
	}

}