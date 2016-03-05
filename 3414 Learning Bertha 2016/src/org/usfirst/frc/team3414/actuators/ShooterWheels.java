package org.usfirst.frc.team3414.actuators;

public class ShooterWheels
{
	private SingleMotor shooterMotorA;
	private SingleMotor shooterMotorB;

	private final double SPEED = 0.8;
	private final double ZERO = 0.0;

	public ShooterWheels(SingleMotor _shooterMotorA, SingleMotor _shooterMotorB)
	{
		shooterMotorA = _shooterMotorA;
		shooterMotorB = _shooterMotorB;
	}

	public void start()
	{
		shooterMotorA.setSpeed(SPEED);
		shooterMotorB.setSpeed(SPEED);
	}

	public void stop()
	{
		shooterMotorA.setSpeed(ZERO);
		shooterMotorB.setSpeed(ZERO);
	}
}
