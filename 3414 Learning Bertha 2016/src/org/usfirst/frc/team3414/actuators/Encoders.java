package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.Encoder;

public class Encoders
{
	// How do I use string, PIDSourceType, ITable

	private Encoders EncodeOne;

	/**
	 * Creates Encoders
	 * 
	 * @param channel
	 */
	public Encoders(Encoders _encoder)
	{
		EncodeOne = _encoder;
	}

	/**
	 * Frees Encoder
	 */
	public void free()
	{
		EncodeOne.free();
	}

	/**
	 * Gets something
	 * 
	 * @return
	 */
	public int get()
	{
		return EncodeOne.get();
	}

	public boolean getDirection()
	{
		return EncodeOne.getDirection();
	}

	public double getDistance()
	{
		return EncodeOne.getDistance();
	}

	public int getEncodingScale()
	{
		return EncodeOne.getEncodingScale();
	}

	public int getFPGAIndex()
	{
		return EncodeOne.getFPGAIndex();
	}

	public double getPeriod()
	{
		return EncodeOne.getPeriod();
	}

	// public PIDSourceType getPIDSourceType()
	{
		// return EncodeOne.getPIDSourceType();
	}

	public double getRate()
	{
		return EncodeOne.getRate();
	}

	public int getRaw()
	{
		return EncodeOne.getRaw();
	}

	public int getSamplesToAverage()
	{
		return EncodeOne.getSamplesToAverage();
	}

	public String getSmartDashboardType()
	{
		return EncodeOne.getSmartDashboardType();
	}

	public boolean getStopped()
	{
		return EncodeOne.getStopped();
	}

	// public ITable getITable()
	{
		// return EncodeOne.getITable();
	}

	// public void initTable(ITable subtable)
	{
		// return EncodeOne.initTable();
	}

	public double pidGet()
	{
		return EncodeOne.pidGet();
	}

	public void reset()
	{
		// return EncodeOne.reset();
	}

	/**
	 * sets adsjklfajsdklf
	 * 
	 * @param distancePerPulse
	 */
	public void setDistancePerPulse(double distancePerPulse)
	{
		// return EncodeOne.setDistancePerPulse();
	}
	// public void
}
