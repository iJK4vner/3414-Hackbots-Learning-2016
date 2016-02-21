package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class LoaderWheels {
	CANTalon loaderMotor;
	private double SPEED = -0.5;
	private double ZERO = 0.0;

	public LoaderWheels(int channel) {
		loaderMotor = new CANTalon(channel);
	}

	public void Start() {
		loaderMotor.set(SPEED);
	}

	public void Stop() {
		loaderMotor.set(ZERO);
	}
}
