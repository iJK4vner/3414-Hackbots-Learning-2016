package org.usfirst.frc.team3414.actuators;

public class TankDrive
{

	private DoubleMotor leftDoubleMotor;
	private DoubleMotor rightDoubleMotor;
	private final static double STOP = 0.0;

//	public TankDrive(DoubleMotor rightSide, DoubleMotor leftSide)
//	{
//		leftDoubleMotor = rightSide;
//		rightDoubleMotor = leftSide;
//	}
//
//	public void forward(double speed)
//	{
//		leftDoubleMotor.setSpeed(Math.abs(speed));
//		rightDoubleMotor.setSpeed(Math.abs(speed));
//	}
//
//	public void backward(double speed)
//	{
//		leftDoubleMotor.setSpeed(-Math.abs(speed));
//		rightDoubleMotor.setSpeed(-Math.abs(speed));
//	}
//
//	public void turnLeft(double speed)
//	{
//		leftDoubleMotor.setSpeed(speed);
//		rightDoubleMotor.setSpeed(-speed);
//	}
//
//	public void turnRight(double speed)
//	{
//		leftDoubleMotor.setSpeed(-speed);
//		rightDoubleMotor.setSpeed(speed);
//	}

	public void setSpeed(double speed)
	{
		leftDoubleMotor.setSpeed(speed);
		rightDoubleMotor.setSpeed(speed);
	}

	public void setSpeed(double leftSpeed, double rightSpeed)
	{
		leftDoubleMotor.setSpeed(leftSpeed);
		rightDoubleMotor.setSpeed(-rightSpeed);
	}

	public void stop()
	{
		leftDoubleMotor.setSpeed(STOP);
		rightDoubleMotor.setSpeed(STOP);
	}
}
