package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
Solenoid mySolenoid;

public Piston(int channel)	{
	mySolenoid = new Solenoid(1);
}
	public void shoot()	{
		mySolenoid.set(true);
	}
	public void retract()	{
		mySolenoid.set(false);
	}
}
