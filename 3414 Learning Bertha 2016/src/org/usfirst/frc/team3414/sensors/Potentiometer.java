package org.usfirst.frc.team3414.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class Potentiometer
{

	 private AnalogInput pot;

	public Potentiometer(AnalogInput _pot)
	{
		pot = _pot;

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
