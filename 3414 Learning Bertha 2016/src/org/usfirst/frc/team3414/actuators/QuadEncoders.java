package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Encoder;

public class QuadEncoders
{
	private Encoder encodeOne;

	public QuadEncoders(Encoder _encoder)
	{
		encodeOne = _encoder;
		reset();
	}

	/**
	 * Gets something
	 * 
	 * @return
	 */
	public int get()
	{
		return encodeOne.get();
	}

	public boolean getDirection()
	{
		return encodeOne.getDirection();
	}

	public double getDistance()
	{
		return encodeOne.getDistance();
	}

	public double getRate()
	{
		return encodeOne.getRate();
	}

	public int getRaw()
	{
		return encodeOne.getRaw();
	}

	public boolean getStopped()
	{
		return encodeOne.getStopped();
	}

	public void reset()
	{
		 encodeOne.reset();
	}

	public void setDistancePerPulse(double distancePerPulse)
	{
		encodeOne.setDistancePerPulse(distancePerPulse);	}
}
