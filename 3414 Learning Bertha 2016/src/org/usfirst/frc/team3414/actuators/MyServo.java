package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Servo;

public class MyServo
{

	private Servo myServo;

	public MyServo(int channel)
	{
		myServo = new Servo(channel);
	}

	public void setAngle(double temdegrees)
	{
		myServo.setAngle(temdegrees);
	}

	public double get()
	{
		return myServo.get();
	}

	public void set(double temservopos)
	{
		myServo.set(temservopos);
	}

	public double getAngle()
	{
		return myServo.getAngle();
	}
}