package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Relay;

public class LoaderWheels
{
	private Relay sMotor;
	
	public LoaderWheels(Relay _sMotor)
	{
		sMotor = _sMotor;
	}
	public void start()
	{
		sMotor.set(Relay.Value.kForward);
	}
	public void stop()
	{
		sMotor.set(Relay.Value.kOff);
	}
}
