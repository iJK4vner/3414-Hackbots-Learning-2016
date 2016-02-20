package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.CANTalon;

public class ShooterWheels {
		CANTalon shooterMotorA;
		CANTalon shooterMotorB;
		private final double SPEED = 0.8;
		private final double ZERO = 0.0;
		
		public ShooterWheels (int channelA, int channelB) {
			shooterMotorA = new CANTalon (1);
			shooterMotorB = new CANTalon (2);
		}
		public void start () {
			shooterMotorA.set(SPEED);	
			shooterMotorB.set(SPEED);
		}
		public void stop () {
			shooterMotorA.set(ZERO);
			shooterMotorB.set(ZERO);
		}
}
