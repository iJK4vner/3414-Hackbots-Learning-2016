package org.usfirst.frc.team3414.actuators;

public class DoubleMotor
{
	
	private SingleMotor motorOne;
	private SingleMotor motorTwo;
	
	public DoubleMotor(SingleMotor _motorOne, SingleMotor _motorTwo)
	{
		motorOne = _motorOne;
		motorTwo = _motorTwo;

	}
	
	public void setSpeed(double speed)
	{
		motorTwo.setSpeed(speed);
		motorOne.setSpeed(speed);
	}

}
