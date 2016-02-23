package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoid
{
	private Solenoid mySolenoid;

	public SingleSolenoid(Solenoid _mySolenoid)
	{
		mySolenoid = _mySolenoid;
	}

	public void shoot()
	{
		mySolenoid.set(true);
	}

	public void retract()
	{
		mySolenoid.set(false);
	}
}
