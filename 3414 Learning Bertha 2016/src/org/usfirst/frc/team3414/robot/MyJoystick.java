package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Joystick;

public class MyJoystick
{
	private Joystick myJoystick;
	public static final int HORIZONTAL_AXIS = 0;
	public static final int VERTICAL_AXIS = 1;
	public static final int TWIST_AXIS = 2;
	public static final double DEADZONE = 0.15;

	public MyJoystick(Joystick _myJoystick)
	{
		myJoystick = _myJoystick;
	}

	public double getX()
	{
		if (Math.abs(myJoystick.getRawAxis(HORIZONTAL_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			return myJoystick.getRawAxis(HORIZONTAL_AXIS);
		}
	}

	public double getY()
	{
		if (Math.abs(myJoystick.getRawAxis(VERTICAL_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			return myJoystick.getRawAxis(VERTICAL_AXIS);
		}
	}

	public double getZ()
	{
		if (Math.abs(myJoystick.getRawAxis(TWIST_AXIS)) < DEADZONE)
		{
			return 0.0;
		} else
		{
			return myJoystick.getRawAxis(TWIST_AXIS);
		}
	}

	public boolean isButtonPressed(EJoystickButtons button)
	{
		switch (button)
		{
		case ONE:
			return myJoystick.getRawButton(1);
		case TWO:
			return myJoystick.getRawButton(2);
		case THREE:
			return myJoystick.getRawButton(3);
		case FOUR:
			return myJoystick.getRawButton(4);
		case FIVE:
			return myJoystick.getRawButton(5);
		case SIX:
			return myJoystick.getRawButton(6);
		case SEVEN:
			return myJoystick.getRawButton(7);
		case EIGHT:
			return myJoystick.getRawButton(8);
		case NINE:
			return myJoystick.getRawButton(9);
		case TEN:
			return myJoystick.getRawButton(10);
		case ELEVEN:
			return myJoystick.getRawButton(11);
		case TWELVE:
			return myJoystick.getRawButton(12);
		default:
			return false;
		}

	}

}
