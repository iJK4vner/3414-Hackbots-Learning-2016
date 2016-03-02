package org.usfirst.frc.team3414.actuators;


public class ShooterWheels
{
		private CANMotor shooterMotorA;
		private CANMotor shooterMotorB;
	
		private final double SPEED = 0.8;
		private final double ZERO = 0.0;
		
		public ShooterWheels (CANMotor _shooterMotorA, CANMotor _shooterMotorB) 
		{
			shooterMotorA = _shooterMotorA;
			shooterMotorB = _shooterMotorB;
		}
		
		public void start () 
		{
			shooterMotorA.setSpeed(SPEED);	
			shooterMotorB.setSpeed(SPEED);
		}
		public void stop () 
		{
			shooterMotorA.setSpeed(ZERO);
			shooterMotorB.setSpeed(ZERO);
		}
}
