package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class DoubleMotor
{

	private CANTalon MotorOne;
	private CANTalon MotorTwo;

	public DoubleMotor(int one, int two)
	{
		MotorOne = new CANTalon(one);
		MotorTwo = new CANTalon(two);

	}

	public void setSpeed(double speed)
	{
		MotorTwo.set(speed);
		MotorOne.set(speed);
	}

}
