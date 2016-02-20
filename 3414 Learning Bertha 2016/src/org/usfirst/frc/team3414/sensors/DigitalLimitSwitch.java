package org.usfirst.frc.team3414.sensors;

import edu.wpi.first.wpilibj.DigitalInput;

public class DigitalLimitSwitch implements ILimitSwitch
{
	private DigitalInput limitSwitchOne;

	public DigitalLimitSwitch(int channel)
	{
		limitSwitchOne = new DigitalInput(channel);
	}

	@Override
	public boolean getValue()
	{
		return limitSwitchOne.get();
	}

}
