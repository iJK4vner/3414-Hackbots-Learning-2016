package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class ShooterWheels {
		CANTalon shooterMotor;
		private final double SPEED = 0.8;
		private final double ZERO = 0.0;
		
		public ShooterWheels (int channel) {
			shooterMotor = new CANTalon (channel);
		}
		public void start () {
			shooterMotor.set(SPEED);	
		}
		public void stop () {
			shooterMotor.set(ZERO);
		}
}
