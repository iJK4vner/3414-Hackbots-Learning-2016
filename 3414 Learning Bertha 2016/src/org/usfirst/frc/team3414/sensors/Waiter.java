package org.usfirst.frc.team3414.sensors;
import edu.wpi.first.wpilibj.RobotBase;

public class Waiter

{
	private RobotBase rr ;
	public Waiter (RobotBase robot)
	{
		rr = robot;
	}
	
	public void wait(int waitTime)
	{
		long finishTime = System.currentTimeMillis() + waitTime;

		System.out.println("starting");

		while ((System.currentTimeMillis() < finishTime) && rr.isAutonomous())
		{
		}
		System.out.println("finish");
	}
}
