package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Button;
import edu.wpi.first.wpilibj.command.Command;

public class MyGamepad
{
	private java.awt.Button myButtonOne;
	private java.awt.Button myButtonTwo;			//what is java.awt.
	private java.awt.Button myButtonThree;
	private java.awt.Button myButtonFour;
	private java.awt.Button myButtonFive;
	private java.awt.Button myButtonSix;
	private Gamepad myGamepad;

	public MyGamepad(Button _myButtonOne, Button _myButtonTwo, Button _myButtonThree, Button _myButtonFour, Button _myButtonFive, Button _myButtonSix)
	{
		myButtonOne = _myButtonOne;
		myButtonTwo = _myButtonTwo;
		myButtonThree = _myButtonThree;
		myButtonFour = _myButtonFour;
		myButtonFive = _myButtonFive;
		myButtonSix = _myButtonSix;
	}
	public void whenPressed(Command command)
	{								//Change 'get' into something else
		return myButtonOne.getRawButtonValue(1);
		return myButtonTwo.getRawButtonValue(2);
		return myButtonThree.getRawButtonValue(3);
		return myButtonFour.getRawButtonValue(4);
		return myButtonFive.getRawButtonValue(5);
		return myButtonSix.getRawButtonValue(6);
		
	}

	public boolean isButtonPressed(int button)
	{
		return myGamepad.getRawButton(button);
	}
}
