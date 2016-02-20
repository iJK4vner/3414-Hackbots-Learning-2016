package org.usfirst.frc.team3414.actuators;

public class TankDrive {

	DoubleMotor leftDoubleMotor;
	DoubleMotor rightDoubleMotor;
	private final static int STOP = 0;
	
	
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
		leftDoubleMotor.setSpeed(-Math.abs(speed));
		rightDoubleMotor.setSpeed(-Math.abs(speed));
	}
	public void turnLeft(double speed)
	{
		leftDoubleMotor.setSpeed(speed);
		rightDoubleMotor.setSpeed(-speed);
		}
	public void turnRight(double speed)
	{
		leftDoubleMotor.setSpeed(-speed);
		rightDoubleMotor.setSpeed(speed);
	}
	public void setSpeed(double speed)
	{
		leftDoubleMotor.setSpeed(speed);
		rightDoubleMotor.setSpeed(speed);
	}
	public void setSpeed(double leftSpeed, double rightSpeed)
	{
		leftDoubleMotor.setSpeed(leftSpeed);
		rightDoubleMotor.setSpeed(rightSpeed);
	}
	public void stop()
	{
		leftDoubleMotor.setSpeed(STOP);
		rightDoubleMotor.setSpeed(STOP);
	}
}
