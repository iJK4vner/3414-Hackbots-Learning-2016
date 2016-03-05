package org.usfirst.frc.team3414.sensors;

public class ScrewPot
{
	private Potentiometer potentiometerOne;
	private static final int MIN = 4;
	private static final int MAX = 3980;

	public ScrewPot(Potentiometer _potentiometerOne)
	{
		potentiometerOne = _potentiometerOne;
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

	public double getPercentageOfMax()
	{
		return ((getCount() - MIN) / (MAX - MIN));

	}
}
