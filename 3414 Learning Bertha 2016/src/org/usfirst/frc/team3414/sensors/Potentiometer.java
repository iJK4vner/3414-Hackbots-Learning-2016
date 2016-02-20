package org.usfirst.frc.team3414.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class Potentiometer
{

	 private AnalogInput pot;

	public Potentiometer(int channelA)
	{
		pot = new AnalogInput(channelA);

	}

	public double getValue()
	{
		return pot.getValue();
	}

	public double getVoltage()
	{
		return pot.getVoltage();
	}

}
