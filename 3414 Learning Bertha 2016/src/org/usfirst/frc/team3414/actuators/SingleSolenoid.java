package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoid {
Solenoid mySolenoid;

public SingleSolenoid(int channel)	{
	mySolenoid = new Solenoid(1);
}
	public void shoot()	{
		mySolenoid.set(true);
	}
	public void retract()	{
		mySolenoid.set(false);
	}
}
