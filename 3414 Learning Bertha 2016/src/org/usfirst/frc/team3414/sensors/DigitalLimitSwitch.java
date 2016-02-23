package org.usfirst.frc.team3414.sensors;

import edu.wpi.first.wpilibj.DigitalInput;

public class DigitalLimitSwitch implements ILimitSwitch
{
	private DigitalInput limitSwitchOne;

	public DigitalLimitSwitch(DigitalInput _limitSwitchOne)
	{
		limitSwitchOne = _limitSwitchOne;
	}


	@Override
	public boolean isButtonPressed()
	{
		return limitSwitchOne.get();
	}

}
