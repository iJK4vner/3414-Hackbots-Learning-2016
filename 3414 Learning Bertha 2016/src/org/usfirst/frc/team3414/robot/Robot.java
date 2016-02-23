
package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team3414.actuators.*;
import org.usfirst.frc.team3414.sensors.*;

import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team3414.sensors.ILimitSwitch;

public class Robot extends IterativeRobot

{
	private static final int TOP_LIM_SWITCH_CHANNEL = 2;
	private static final int BOT_LIM_SWITCH_CHANNEL = 1;
	private static final int POT_CHANNEL = 2;
	private static final int JOY_CHANNEL = 2;
	private static final int FR_DRIVETRAIN_CHANNEL = 1;
	private static final int FL_DRIVETRAIN_CHANNEL = 2;
	private static final int BL_DRIVETRAIN_CHANNEL = 3;
	private static final int BR_DRIVETRAIN_CHANNEL = 4;

	private TankDrive tankDrive = new TankDrive(FR_DRIVETRAIN_CHANNEL, FL_DRIVETRAIN_CHANNEL, BL_DRIVETRAIN_CHANNEL,
			BR_DRIVETRAIN_CHANNEL);
	private MyJoystick myJoystick = new MyJoystick(JOY_CHANNEL);
	
	private AnalogInput _pot = new AnalaogInput(POT_CHANNEL);
	private Potentiometer pot = new Potentiometer(_pot);
	private DigitalLimitSwitch limitSwitchOne = new DigitalLimitSwitch(BOT_LIM_SWITCH_CHANNEL);
	DigitalLimitSwitch limitSwitchTwo = new DigitalLimitSwitch(TOP_LIM_SWITCH_CHANNEL);
	private ScrewMotor screwMotor = new ScrewMotor(5);
	private static final int MAX = 190;
	private static final int MIN = 490;
	private static final double SPEED = 0.2;
	private static final double TURN = 0.19;
	private static final int BUTTON_ONE = 1;
	private static final int BUTTON_TWO = 2;

	public void robotInit()
	{

	}

	public void autonomousInit()
	{
	}

	public void autonomousPeriodic()
	{

	}

	public void teleopInit()
	{
		
	}

	public void teleopPeriodic()
	{

		if (myJoystick.isButtonPressed(BUTTON_ONE) && !myJoystick.isButtonPressed(BUTTON_TWO))
		{
			System.out.println("working");
			System.out.println(pot.getValue());
			if (pot.getValue() < MAX && limitSwitchOne.isButtonPressed())
			{
				System.out.println("going up");
				screwMotor.up();
			} else
			{
				screwMotor.stop();
			}
		} else if (myJoystick.isButtonPressed(BUTTON_TWO) && !myJoystick.isButtonPressed(BUTTON_ONE))
		{
			if (pot.getValue() > MIN && limitSwitchTwo.isButtonPressed())
			{
				System.out.println("going down");
				screwMotor.down();
			} else
			{
				screwMotor.stop();
			}
		} else
		{
			screwMotor.stop();
		}
	}

	public void testPeriodic()
	{

	}

}
