package org.usfirst.frc.team3414.sensors;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Timer;

public class Waiter

{
	private RobotBase rr;

	public Waiter(RobotBase _robot)
	{
		rr = _robot;
	}

	public void wait(int milliseconds)
	{
		Timer.delay(milliseconds);
	}
}
