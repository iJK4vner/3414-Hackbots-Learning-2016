package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class DoubleMotor
{

	private CANMotor motorOne;
	private CANMotor motorTwo;

	public DoubleMotor(CANMotor _motorOne, CANMotor _motorTwo)
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
