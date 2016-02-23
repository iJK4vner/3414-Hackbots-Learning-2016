package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

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
			shooterMotorA.set(SPEED);	
			shooterMotorB.set(SPEED);
		}
		public void stop () 
		{
			shooterMotorA.set(ZERO);
			shooterMotorB.set(ZERO);
		}
}
