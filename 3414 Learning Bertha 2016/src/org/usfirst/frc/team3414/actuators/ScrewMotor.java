package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Talon;

public class ScrewMotor
{
	private final static double MOVE_SPEED = 1.0;
	private final static double STOP = 0;
	
	private Talon screw;

	public ScrewMotor(Talon _screw)
	{
		screw = _screw;
	}

	public void up()
	{
		// screw.set(Talon.Value.kForward);
		screw.set(MOVE_SPEED);
	}

	public void down()
	{
		// screw.set(Talon.Value.kReverse);
		screw.set(-MOVE_SPEED);
	}

	public void stop()
	{
		screw.set(STOP);
	}
}
