package org.usfirst.frc.team3414.sensors;

public class ScrewPot
{
	private Potentiometer potentiometerOne;
	private static final int MIN = 4;
	private static final int MAX = 3980;

	public ScrewPot(int channel)
	{
		potentiometerOne = new Potentiometer(channel);
	}

	public double getCount()
	{
		if (potentiometerOne.getValue() > 0)
		{
			return potentiometerOne.getValue();
		} else
		{
			return 0;
		}
	}

	public void resetCount()
	{
		// .resetCount();

	}

	public double getTransformedCount()
	{
		return ((getCount() - MIN) / (MAX - MIN));

	}
}
