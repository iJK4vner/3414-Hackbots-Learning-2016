
package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team3414.actuators.*;
import org.usfirst.frc.team3414.sensors.*;

import edu.wpi.first.wpilibj.Compressor;

public class Robot extends IterativeRobot
{
	// FIELDS
	private static final int FR_DRIVETRAIN_CHANNEL = 1;
	private static final int FL_DRIVETRAIN_CHANNEL = 2;
	private static final int BL_DRIVETRAIN_CHANNEL = 3;
	private static final int BR_DRIVETRAIN_CHANNEL = 4;

	private static final int BOT_LIM_SWITCH_CHANNEL = 1;
	private static final int TOP_LIM_SWITCH_CHANNEL = 2;
	private static final int LOADER_LIM_SWITCH_CHANNEL = 3;

	private static final int POT_CHANNEL = 0;

	private static final int L_JOY_CHANNEL = 0;
	private static final int R_JOY_CHANNEL = 1;
	private static final int GAMEPAD_JOY_CHANNEL = 1;

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

	private static final int MAX = 190;
	private static final int MIN = 490;
	// private static final double SPEED = 0.2;
	// private static final double TURN = 0.19;

	private boolean isLoaderFull = false;
	private boolean isBayFull = false;

	// OBJECT INSTANTIATIONS
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

	private AnalogInput _pot = new AnalogInput(POT_CHANNEL);
	private Potentiometer pot = new Potentiometer(_pot);

	private MyJoystick gamepad;
	private MyJoystick leftJoystick;
	private MyJoystick rightJoystick;

	private DoubleSolenoid _dSol = new DoubleSolenoid(DSOL_A_CHANNEL, DSOL_B_CHANNEL);
	private DoublePiston dSol = new DoublePiston(_dSol);

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

	// METHODS
	public void robotInit()
	{
		gamepad = new MyJoystick(new Joystick(GAMEPAD_JOY_CHANNEL));
		leftJoystick = new MyJoystick(new Joystick(L_JOY_CHANNEL));
		rightJoystick = new MyJoystick(new Joystick(R_JOY_CHANNEL));
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
		SmartDashboard.putNumber("Pot", pot.getValue());

		// SCREW
		if (gamepad.isButtonPressed(BUTTON_ONE) && !gamepad.isButtonPressed(BUTTON_TWO))
		{
			System.out.println("Screw is Working");
			if (pot.getValue() < MAX && topLimitSwitch.isButtonPressed())
			{
				SmartDashboard.putString("Screw State", "Going Up");
				screwMotor.up();
			} else
			{
				SmartDashboard.putString("Screw State", "Stopped");
				screwMotor.stop();
			}
		} else if (gamepad.isButtonPressed(BUTTON_TWO) && !gamepad.isButtonPressed(BUTTON_ONE))
		{
			if (pot.getValue() > MIN && bottomLimitSwitch.isButtonPressed())
			{
				SmartDashboard.putString("Screw State", "Going Down");
				screwMotor.down();
			} else
			{
				SmartDashboard.putString("Screw State", "Stopped");
				screwMotor.stop();
			}
		} else
		{
			SmartDashboard.putString("Screw State", "Stopped");
			screwMotor.stop();
		}

		// SHOOTER
		if (gamepad.isButtonPressed(BUTTON_THREE) && loaderLimitSwitch.isButtonPressed() && !isBayFull && isLoaderFull)
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

		if (isBayFull && gamepad.isButtonPressed(BUTTON_FOUR))
		{
			shooterWheels.start();
		}

		if (isBayFull && gamepad.isButtonPressed(BUTTON_FIVE))
		{
			sol.shoot();
			isBayFull = false;
			shooterWheels.stop();
		}

		// DRIVETRAIN
		if (rightJoystick.isButtonPressed(BUTTON_ONE))
		{
			tankDrive.setSpeed(rightJoystick.getY());
		} else
		{
			tankDrive.setSpeed(leftJoystick.getY(), rightJoystick.getY());
		}
	
	{

	}

}
// TODO drive train and shooter
