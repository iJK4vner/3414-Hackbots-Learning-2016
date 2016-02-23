package org.usfirst.frc.team3414.actuators;

import org.usfirst.frc.team3414.actuators.CANMotor;

public class ScrewMotor
{
	private CANMotor screw;
	private static final double SPEED = 0.5;
	private static final double STOP = 0;

	public ScrewMotor(CANMotor _screw)
	{
		screw = _screw;
	}

	public void up()
	{
		screw.setSpeed(SPEED);
	}

	public void down()
	{
		screw.setSpeed(-SPEED);
	}

	public void stop()
	{
		screw.setSpeed(STOP);
	}
}
