package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Button;

public class MyJoystick
{
	private Joystick myJoystick;
	public Button myButton;

	public MyJoystick(Joystick _myJoystick)
	{
		myJoystick = _myJoystick;
	}

	public double getY()
	{
		return myJoystick.getRawAxis(1);
	}

	public double getX()
	{
		return myJoystick.getRawAxis(0);
	}

	public double getZ()
	{
		return myJoystick.getRawAxis(2);
	}
	public MyJoystick(Button _myButton)
	{
		
	}

	public boolean isButtonPressed(int button)
	{
		return myJoystick.getRawButton(button);
	}
	
}

	
