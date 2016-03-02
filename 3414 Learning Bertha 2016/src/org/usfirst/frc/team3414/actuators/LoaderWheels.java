package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class LoaderWheels 
{
	private CANMotor loaderMotor;
	private double SPEED = -0.5;
	private double ZERO = 0.0;

	public LoaderWheels(CANMotor _loaderMotor)
	{
		loaderMotor = _loaderMotor;
	}

	public void start()
	{
		loaderMotor.setSpeed(SPEED);
	}

	public void stop() 
	{
		loaderMotor.setSpeed(ZERO);
	}
}
