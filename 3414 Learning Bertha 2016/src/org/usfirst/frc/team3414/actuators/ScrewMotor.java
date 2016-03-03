package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Relay;

public class ScrewMotor
{
	private Relay screw;

	public ScrewMotor(Relay _screw)
	{
		screw = _screw;
	}

	public void up()
	{
		screw.set(Relay.Value.kForward);
	}

	public void down()
	{
		screw.set(Relay.Value.kReverse);
	}

	public void stop()
	{
		screw.set(Relay.Value.kOff);
	}
}
