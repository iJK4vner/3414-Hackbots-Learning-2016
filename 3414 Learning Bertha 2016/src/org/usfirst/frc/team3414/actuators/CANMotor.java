package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class CANMotor implements IMotor
{
	private CANTalon motor;

	public CANMotor(CANTalon _motor)
	{
		motor = _motor;
	}
	public void setSpeed (double speed)
	{
		motor.set(speed);
	}
	
	@Override
	public void stop()
	{
		motor.set(0.0);
	}

}