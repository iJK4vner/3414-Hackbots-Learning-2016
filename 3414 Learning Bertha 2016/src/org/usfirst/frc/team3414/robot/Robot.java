
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

	private static final int FR_DRIVETRAIN_CHANNEL = 1;
	private static final int FL_DRIVETRAIN_CHANNEL = 2;
	private static final int BL_DRIVETRAIN_CHANNEL = 3;
	private static final int BR_DRIVETRAIN_CHANNEL = 4;

	private static final int BOT_LIM_SWITCH_CHANNEL = 1;
	private static final int TOP_LIM_SWITCH_CHANNEL = 2;
	private static final int LOADER_LIM_SWITCH_CHANNEL = 3;

	private static final int POT_CHANNEL = 1;

	private static final int JOY_CHANNEL = 1;

	private static final int DSOL_A_CHANNEL = 1;
	private static final int DSOL_B_CHANNEL = 2;

	private static final int SINGLE_SOLENOID_CHANNEL = 1;

	private static final int LOADER_WHEELS_CHANNEL = 1;

	private static final int SCREW_MOTOR_CHANNEL = 1;

	private static final int SHOOTER_WHEELS_CHANNEL = 1;

	private static final int BUTTON_ONE = 1;
	private static final int BUTTON_TWO = 2;
	private static final int BUTTON_THREE = 3;
	private static final int BUTTON_FOUR = 4;
	private static final int BUTTON_FIVE = 5;
	private static final int BUTTON_SIX = 6;

	private CANTalon frontRight = new CANTalon(FR_DRIVETRAIN_CHANNEL);
	private CANTalon frontLeft = new CANTalon(FL_DRIVETRAIN_CHANNEL);
	private CANTalon backRight = new CANTalon(BR_DRIVETRAIN_CHANNEL);
	private CANTalon backLeft = new CANTalon(BL_DRIVETRAIN_CHANNEL);
	private CANMotor _frontRight = new CANMotor(frontRight);
	private CANMotor _frontLeft = new CANMotor(frontLeft);
	private CANMotor _backRight = new CANMotor(backRight);
	private CANMotor _backLeft = new CANMotor(backLeft);
	private DoubleMotor right = new DoubleMotor(_frontRight, _backRight);
	private DoubleMotor left = new DoubleMotor(_frontLeft, _backLeft);
	private TankDrive tankDrive = new TankDrive(right, left);

	private DigitalInput _bottomLimitSwitch = new DigitalInput(BOT_LIM_SWITCH_CHANNEL);
	private DigitalInput _topLimitSwitch = new DigitalInput(TOP_LIM_SWITCH_CHANNEL);
	private DigitalInput _loaderLimitSwitch = new DigitalInput(LOADER_LIM_SWITCH_CHANNEL);
	private DigitalLimitSwitch bottomLimitSwitch = new DigitalLimitSwitch(_bottomLimitSwitch);
	private DigitalLimitSwitch topLimitSwitch = new DigitalLimitSwitch(_topLimitSwitch);
	private DigitalLimitSwitch loaderLimitSwitch = new DigitalLimitSwitch(_loaderLimitSwitch);

	private AnalogInput _pot = new AnalaogInput(POT_CHANNEL);
	private Potentiometer pot = new Potentiometer(_pot);
	private ScrewPot screwPot = new ScrewPot(pot);

	private Joystick _myJoystick = new Joystick(JOY_CHANNEL);
	private MyJoystick myJoystick = new MyJoystick(_myJoystick);

	private DoubleSolenoid _dSolA = new DoubleSolenoid(DSOL_A_CHANNEL);
	private DoubleSolenoid _dSolB = new DoubleSolenoid(DSOL_B_CHANNEL);
	private DoublePiston dSolA = new DoublePiston(_dSolA);
	private DoublePiston dSolB = new DoublePiston(_dSolB);

	private Solenoid _sol = new Solenoid(SINGLE_SOLENOID_CHANNEL);
	private SingleSolenoid sol = new SingleSolenoid(_sol);

	private CANTalon tLoaderWheels = new CANTalon(LOADER_WHEELS_CHANNEL);
	private CANMotor mLoaderWheels = new CANMotor(tLoaderWheels);
	private LoaderWheels loaderWheels = new LoaderWheels(mLoaderWheels);

	private CANTalon tScrewMotor = new CANTalon(SCREW_MOTOR_CHANNEL);
	private CANMotor mScrewMotor = new CANMotor(tScrewMotor);
	private ScrewMotor screwMotor = new ScrewMotor(mScrewMotor);

	private CANTalon tShooterWheelsA = new CANTalon(SHOOTER_WHEELS_CHANNEL);
	private CANTalon tShooterWheelsB = new CANTalon(SHOOTER_WHEELS_CHANNEL);
	private CANMotor mShooterWheelsA = new CANMotor(tShooterWheelsA);
	private CANMotor mShooterWheelsB = new CANMotor(tShooterWheelsB);
	private ShooterWheels shooterWheels = new ShooterWheels(mShooterWheelsA, mShooterWheelsB);

	private static final int MAX = 190;
	private static final int MIN = 490;
	private static final double SPEED = 0.2;
	private static final double TURN = 0.19;

	private boolean loaderWheelStart;
	private boolean isLoaderFull;
	private boolean isBayFull;

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
		// This is screw
		if (myJoystick.isButtonPressed(BUTTON_ONE) && !myJoystick.isButtonPressed(BUTTON_TWO))
		{
			System.out.println("working");
			System.out.println(pot.getValue());
			if (pot.getValue() < MAX && topLimitSwitch.isButtonPressed())
			{
				System.out.println("going up");
				screwMotor.up();
			} else
			{
				screwMotor.stop();
			}
		} else if (myJoystick.isButtonPressed(BUTTON_TWO) && !myJoystick.isButtonPressed(BUTTON_ONE))
		{
			if (pot.getValue() > MIN && bottomLimitSwitch.isButtonPressed())
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
		// This is shooter

		if (myJoystick.isButtonPressed(BUTTON_THREE) && loaderLimitSwitch.isButtonPressed() && !isBayFull
				&& isLoaderFull)
		{
			loaderWheels.start();
		} else
		{
			loaderWheels.stop();
		}

		if (!loaderLimitSwitch.isButtonPressed() && !isBayFull && isLoaderFull)
		{
			isLoaderFull = false;
			isBayFull = true;
			loaderWheels.stop();
		}

		if (!isLoaderFull && loaderLimitSwitch.isButtonPressed())
		{
			loaderWheels.stop();
			isLoaderFull = true;
		}

		if (isBayFull && myJoystick.isButtonPressed(BUTTON_FOUR))
		{
			shooterWheels.start();
		}

		if (isBayFull && myJoystick.isButtonPressed(BUTTON_FIVE))
		{
			sol.shoot();
			isBayFull = false;
			shooterWheels.stop();
		}
	}

	public void testPeriodic()
	{

	}

}
// TODO drive train and shooter
