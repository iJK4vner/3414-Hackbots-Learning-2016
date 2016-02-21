package org.usfirst.frc.team3414.robot;

public class TankDrive {

	DoubleMotor leftDoubleMotor;
	DoubleMotor rightDoubleMotor;

	public TankDrive(int FR, int FL, int BL, int BR) {
		leftDoubleMotor = new DoubleMotor(FR, BR);
		rightDoubleMotor = new DoubleMotor(FL, BL);

	}
	public void forward(double speed)
	{
		leftDoubleMotor.setSpeed(Math.abs(speed));
		rightDoubleMotor.setSpeed(Math.abs(speed));
	}
	public void backward(double speed)
	{
		leftDoubleMotor.setSpeed(Math.abs(-speed));
		rightDoubleMotor.setSpeed(Math.abs(-speed));
	}
	public void turnLeft(double speed)
	{
		leftDoubleMotor.setSpeed(speed);	}
	public void turnRight(double speed)
	{
		rightDoubleMotor.setSpeed(speed);
	}
}
