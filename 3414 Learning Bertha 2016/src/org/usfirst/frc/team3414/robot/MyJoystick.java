package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Joystick;

public class MyJoystick
{ public static final int HORIZONTAL_AXIS = 0;
  public static final int VERTICAL_AXIS = 1;
  public static final int TWIST_AXIS = 2;
public static final double DEADZONE = 0.15;


	private Joystick myJoystick;

	public MyJoystick(Joystick _myJoystick)
	{
		myJoystick = _myJoystick;
	}

	public double getY()
	{
		if (Math.abs(joy.getRawAxis(VERTICAL_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			return joy.getRawAxis(VERTICAL_AXIS);
		}
	}

	public double getX()
	{
		if (Math.abs(joy.getRawAxis(HORIZONTAL_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			if (Math.abs(joy.getRawAxis(HORIZONTAL_AXIS)) < DEADZONE)
			{
				return 0.0;
			} else
			{
				return joy.getRawAxis(HORIZONTAL_AXIS);
			}
		}
	}

	public double getZ()
	{
		if (Math.abs(joy.getRawAxis(TWIST_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			return joy.getRawAxis(TWIST_AXIS);
		}
	}

	public boolean isButtonPressed(int button)
	{
		return myJoystick.getRawButton(button);
	}
	
}

	
