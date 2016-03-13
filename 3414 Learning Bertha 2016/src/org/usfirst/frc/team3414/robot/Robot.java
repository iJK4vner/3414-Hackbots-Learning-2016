
package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team3414.actuators.*;
import org.usfirst.frc.team3414.sensors.*;

public class Robot extends IterativeRobot
{
	// FIELDS
	private static final int FR_DRIVETRAIN_CHANNEL = 6;
	private static final int FL_DRIVETRAIN_CHANNEL = 9;
	private static final int BL_DRIVETRAIN_CHANNEL = 8;
	private static final int BR_DRIVETRAIN_CHANNEL = 7;

	private static final int BOT_LIM_SWITCH_CHANNEL = 1;
	private static final int TOP_LIM_SWITCH_CHANNEL = 0;
	private static final int LOADER_LIM_SWITCH_CHANNEL = 3;

	private static final int POT_CHANNEL = 0;

	private static final int L_JOY_CHANNEL = 0;
	private static final int R_JOY_CHANNEL = 1;
	private static final int GAMEPAD_JOY_CHANNEL = 3;

	//lifter
	private static final int LIFTER_DSOL_A_CHANNEL = 0;
	private static final int LIFTER_DSOL_B_CHANNEL = 1;
	
	private static final int SHOOTER_DSOL_A_CHANNEL = 2;
	private static final int SHOOTER_DSOL_B_CHANNEL = 3;
	
	private static final int SCREW_MOTOR_CHANNEL = 2 ;

	private static final int LOADER_SPIKE_CHANNEL = 3;

	private static final int SHOOTER_WHEELS_CHANNELA = 1;
	private static final int SHOOTER_WHEELS_CHANNELB = 0;

	private static final int MAX = 3010;
	private static final int MIN = 960;
	// private static final double SPEED = 0.2;
	// private static final double TURN = 0.19;

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
	private DoubleMotor rightDoubleMotor = new DoubleMotor(_frontRight, _backRight);
	private DoubleMotor leftDoubleMotor = new DoubleMotor(_frontLeft, _backLeft);
	private TankDrive tankDrive = new TankDrive(leftDoubleMotor, rightDoubleMotor);

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

	private DSolenoid _lifter = new DSolenoid(new DoubleSolenoid(LIFTER_DSOL_A_CHANNEL, LIFTER_DSOL_B_CHANNEL));
	private DoublePiston lifter = new DoublePiston(_lifter);
	
	private DSolenoid _shooter = new DSolenoid(new DoubleSolenoid(SHOOTER_DSOL_A_CHANNEL, SHOOTER_DSOL_B_CHANNEL));
	private DoublePiston shooter = new DoublePiston(_shooter);
	
	private LoaderWheels loaderWheels = new LoaderWheels(new Relay (LOADER_SPIKE_CHANNEL));

	private ScrewMotor screwMotor = new ScrewMotor(new Talon(SCREW_MOTOR_CHANNEL));

	private SingleMotor mShooterWheelsA = new SingleMotor (new Talon (SHOOTER_WHEELS_CHANNELA));
	private SingleMotor mShooterWheelsB = new SingleMotor (new Talon (SHOOTER_WHEELS_CHANNELB));
	private ShooterWheels shooterWheels = new ShooterWheels(mShooterWheelsA, mShooterWheelsB);
	
	private double driveScale = 1.0;
	
	// METHODS
	public void robotInit()
	{
		System.out.println("Robot Init");
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

	boolean lockA = false;
	boolean lockB = false;
	public void teleopPeriodic()
	{
		SmartDashboard.putNumber("Pot", pot.getValue());
		SmartDashboard.putBoolean("Top Lim Switch (0)", topLimitSwitch.isHit());
		SmartDashboard.putBoolean("Loader Lim Switch (3)", loaderLimitSwitch.isHit());
		SmartDashboard.putBoolean("Bottom Lim Switch (1)", bottomLimitSwitch.isHit());
		
		// SCREW
		if (gamepad.isButtonPressed(EJoystickButtons.FOUR) && !gamepad.isButtonPressed(EJoystickButtons.TWO))
		{
			System.out.println("Screw is Working");
//			if (pot.getValue() < MAX)
			if (pot.getValue() < MAX && !topLimitSwitch.isHit())
			{
				SmartDashboard.putString("Screw State", "Going Up");
				screwMotor.up();
			} else
			{
				SmartDashboard.putString("Screw State", "Stopped");
				screwMotor.stop();
			}
		} else if (gamepad.isButtonPressed(EJoystickButtons.TWO) && !gamepad.isButtonPressed(EJoystickButtons.FOUR))
		{
			System.out.println("Screw is Working");
//			if (pot.getValue() > MIN)
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
		SmartDashboard.putBoolean("Is Bay Full", isBayFull);
		SmartDashboard.putBoolean("Is Loader Full", isLoaderFull);
		
		// SHOOTER
		if (gamepad.isButtonPressed(EJoystickButtons.THREE))
		{
			loaderWheels.start();
		}
		else
		{
			loaderWheels.stop();
		}
		if (gamepad.isButtonPressed(EJoystickButtons.FIVE))
		{
			shooterWheels.start();
		}
		else
		{
			shooterWheels.stop();
		}
		if (gamepad.isButtonPressed(EJoystickButtons.SIX))
		{
			shooter.engage();
		}
		else
		{
			shooter.disengage();
		}
		
		if (!lockA && !lockB && gamepad.isButtonPressed(EJoystickButtons.ONE))
		{
			lifter.engage();
			lockA = true;
		}
		if (lockA && !lockB && !gamepad.isButtonPressed(EJoystickButtons.ONE))
		{
			//do 2
			lockA = false;
			lockB = true;
		}
		if (!lockA && lockB && gamepad.isButtonPressed(EJoystickButtons.ONE))
		{
			lifter.disengage();
			lockA = true;
		}
		if (lockA && lockB && !gamepad.isButtonPressed(EJoystickButtons.ONE))
		{
			//do 4
			lockA = false;
			lockB = false;
		}
		
//		if (gamepad.isButtonPressed(EJoystickButtons.THREE) && loaderLimitSwitch.isHit() && !isBayFull && isLoaderFull)
//		{
//			System.out.println("Option 1");
//			loaderWheels.start();
//		} else
//		{
//			System.out.println("Option 2");
//
//			loaderWheels.stop();
//		}
//
//		if (!loaderLimitSwitch.isHit() && !isBayFull && isLoaderFull)
//		{
//			System.out.println("Option 3");
//
//			isLoaderFull = false;
//			isBayFull = true;
//			loaderWheels.stop();
//		}
//
//		if (!isLoaderFull && loaderLimitSwitch.isHit())
//		{
//			System.out.println("Option 4");
//
//			loaderWheels.stop();
//			isLoaderFull = true;
//		}
//
//		if (isBayFull && gamepad.isButtonPressed(EJoystickButtons.FIVE))
//		{
//			System.out.println("Option 5");
//
//			shooterWheels.start();
//		}
//
//		if (isBayFull && gamepad.isButtonPressed(EJoystickButtons.SIX))
//		{
//			System.out.println("Option 6");
//
//			shooter.engage();
//			isBayFull = false;
//			shooterWheels.stop();
//			Timer.delay(0.1);
//		} else 
//		{
//			System.out.println("Option 7");
//
//			shooter.disengage();
//		}

		// DRIVETRAIN
//		if (leftJoystick.isButtonPressed(EJoystickButtons.ONE))
//		{
//			tankDrive.setSpeed(rightJoystick.getY()*driveScale);
//		} else
//		{
			tankDrive.setSpeed((leftJoystick.getY()*driveScale), (rightJoystick.getY()*driveScale));
//		}
//		if (rightJoystick.isButtonPressed(EJoystickButtons.ONE))
//		{
//			driveScale = 0.5;
//		} else
//		{
//			driveScale = 1.0;
//		}
		Timer.delay(0.05);
	}

	public void testPeriodic()
	{

	}
	
	public void disabledInit()
	{
	}

}
// TODO drive train and shooter
