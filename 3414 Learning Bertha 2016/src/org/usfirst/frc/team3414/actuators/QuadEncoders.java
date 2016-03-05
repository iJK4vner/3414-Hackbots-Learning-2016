package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Encoder;

public class QuadEncoders
{
	private Encoder encoder;

	public QuadEncoders(Encoder _encoder)
	{
		encoder = _encoder;
		reset();
	}

	public int get()
	{
		return encoder.get();
	}

	public boolean getDirection()
	{
		return encoder.getDirection();
	}

	public double getDistance()
	{
		return encoder.getDistance();
	}


	public double getRate()
	{
		return encoder.getRate();
	}

	public int getRaw()
	{
		return encoder.getRaw();
	}

	public boolean getStopped()
	{
		return encoder.getStopped();
	}

	public void reset()
	{
		encoder.reset();
	}

	public void setDistancePerPulse(double distancePerPulse)
	{
		encoder.setDistancePerPulse(distancePerPulse);
	}
}
