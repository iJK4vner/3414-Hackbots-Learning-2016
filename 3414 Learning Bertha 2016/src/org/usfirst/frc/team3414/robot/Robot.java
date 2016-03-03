
package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team3414.actuators.*;
import org.usfirst.frc.team3414.sensors.*;

import edu.wpi.first.wpilibj.Compressor;

public class Robot extends IterativeRobot
{
	// FIELDS
	private static final int FR_DRIVETRAIN_CHANNEL = 6;
	private static final int FL_DRIVETRAIN_CHANNEL = 9;
	private static final int BL_DRIVETRAIN_CHANNEL = 8;
	private static final int BR_DRIVETRAIN_CHANNEL = 7;
	private double driveScale = 1.0;

	private static final int BOT_LIM_SWITCH_CHANNEL = 1;
	private static final int TOP_LIM_SWITCH_CHANNEL = 2;
	private static final int LOADER_LIM_SWITCH_CHANNEL = 3;

	private static final int POT_CHANNEL = 0;

	private static final int L_JOY_CHANNEL = 0;
	private static final int R_JOY_CHANNEL = 1;
	private static final int GAMEPAD_JOY_CHANNEL = 2;

	private static final int LIFTER_DSOL_A_CHANNEL = 0;
	private static final int LIFTER_DSOL_B_CHANNEL = 1;

	private static final int SHOOTER_DSOL_A_CHANNEL = 2;
	private static final int SHOOTER_DSOL_B_CHANNEL = 3;
	
	private static final int LOADER_WHEELS_CHANNEL = 0;

	private static final int SCREW_MOTOR_CHANNEL = 3;

	private static final int SHOOTER_WHEELS_CHANNELA = 1;
	private static final int SHOOTER_WHEELS_CHANNELB = 2;

	private static final int BUTTON_ONE = 1;
	private static final int BUTTON_TWO = 2;
	private static final int BUTTON_THREE = 3;
	private static final int BUTTON_FOUR = 4;
	private static final int BUTTON_FIVE = 5;
	private static final int BUTTON_SIX = 6;

	private static final int MAX = 3000;
	private static final int MIN = 1000;
	
	private boolean isLoaderFull = false;
	private boolean isBayFull = false;

	// OBJECT INSTANTIATIONS
	private Talon frontRight = new Talon(FR_DRIVETRAIN_CHANNEL);
	private Talon frontLeft = new Talon(FL_DRIVETRAIN_CHANNEL);
	private Talon backRight = new Talon(BR_DRIVETRAIN_CHANNEL);
	private Talon backLeft = new Talon(BL_DRIVETRAIN_CHANNEL);
	private SingleMotor _frontRight = new SingleMotor(frontRight);
	private SingleMotor _frontLeft = new SingleMotor(frontLeft);
	private SingleMotor _backRight = new SingleMotor(backRight);
	private SingleMotor _backLeft = new SingleMotor(backLeft);
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

	private DoubleSolenoid _dLifter = new DoubleSolenoid(LIFTER_DSOL_A_CHANNEL, LIFTER_DSOL_B_CHANNEL);
	private DoublePiston dLifter = new DoublePiston(_dLifter);
	private PyramidLifter lifter = new PyramidLifter(dLifter);

	private DoubleSolenoid _dShooter = new DoubleSolenoid(SHOOTER_DSOL_A_CHANNEL, SHOOTER_DSOL_B_CHANNEL);
	private DoublePiston dShooter = new DoublePiston(_dShooter);
	private PyramidLifter shooter = new PyramidLifter(dShooter);
	
	private Talon tLoaderWheels = new Talon(LOADER_WHEELS_CHANNEL);
	private SingleMotor mLoaderWheels = new SingleMotor(tLoaderWheels);
	private LoaderWheels loaderWheels = new LoaderWheels(mLoaderWheels);

	private Relay tScrewMotor = new Relay(SCREW_MOTOR_CHANNEL);
	private ScrewMotor screwMotor = new ScrewMotor(tScrewMotor);

	private Talon tShooterWheelsA = new Talon(SHOOTER_WHEELS_CHANNELA);
	private Talon tShooterWheelsB = new Talon(SHOOTER_WHEELS_CHANNELB);
	private SingleMotor mShooterWheelsA = new SingleMotor(tShooterWheelsA);
	private SingleMotor mShooterWheelsB = new SingleMotor(tShooterWheelsB);
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

	double leftSpeed;
	double rightSpeed;
	
	public void teleopPeriodic()
	{
		SmartDashboard.putNumber("Pot", pot.getValue());

		// SCREW
		if (gamepad.isButtonPressed(BUTTON_ONE) && !gamepad.isButtonPressed(BUTTON_TWO))
		{
			System.out.println("Screw is Working");
			if (pot.getValue() < MAX && !topLimitSwitch.isHit())
			{
				SmartDashboard.putString("Screw State", "Going Up");
				screwMotor.up();
			} else
			{
				SmartDashboard.putString("Screw State", "Stopped");
				screwMotor.stop();
			}
		} else if (!gamepad.isButtonPressed(BUTTON_ONE) && gamepad.isButtonPressed(BUTTON_TWO))
		{
			if (pot.getValue() > MIN && !bottomLimitSwitch.isHit())
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
		if (gamepad.isButtonPressed(BUTTON_THREE) && loaderLimitSwitch.isHit() && !isBayFull && isLoaderFull)
		{
			loaderWheels.start();
		} else
		{
			loaderWheels.stop();
		}

		if (!loaderLimitSwitch.isHit() && !isBayFull && isLoaderFull)
		{
			isLoaderFull = false;
			isBayFull = true;
			loaderWheels.stop();
		}

		if (!isLoaderFull && loaderLimitSwitch.isHit())
		{
			loaderWheels.stop();
			isLoaderFull = true;
		}

		if (isBayFull && gamepad.isButtonPressed(BUTTON_FOUR))
		{
			shooterWheels.start();
		} else
		{
			shooterWheels.stop();
		}

		if (isBayFull && gamepad.isButtonPressed(BUTTON_FIVE))
		{
			shooter.engage();
			isBayFull = false;
			shooterWheels.stop();
		} else 
		{
			shooter.disengage();
		}
		
		if (gamepad.isButtonPressed(BUTTON_SIX))
		{
			lifter.engage();
		} else 
		{
			lifter.disengage();
		}

		// DRIVETRAIN
		
		 leftSpeed = leftJoystick.getY() * driveScale;
		rightSpeed = rightJoystick.getY() * driveScale;
		
		SmartDashboard.putNumber("Left", leftSpeed);
		SmartDashboard.putNumber("Right", rightSpeed);
		if (rightJoystick.isButtonPressed(BUTTON_ONE))
		{
			tankDrive.setSpeed(rightSpeed);
		} else
		{
			tankDrive.setSpeed(leftSpeed, rightSpeed);
		}

		if (leftJoystick.isButtonPressed(BUTTON_ONE))
		{
			driveScale = 0.5;
		} else
		{
			driveScale = 1.0;
		}

	}
}