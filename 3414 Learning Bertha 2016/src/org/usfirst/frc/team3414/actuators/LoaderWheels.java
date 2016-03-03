package org.usfirst.frc.team3414.actuators;

public class LoaderWheels 
{
	private SingleMotor loaderMotor;
	
	private double SPEED = -0.5;
	private double ZERO = 0.0;

	public LoaderWheels(SingleMotor _loaderMotor)
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
