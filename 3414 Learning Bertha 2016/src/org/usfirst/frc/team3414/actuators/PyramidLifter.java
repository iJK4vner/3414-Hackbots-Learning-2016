package org.usfirst.frc.team3414.actuators;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PyramidLifter 
{
	private DoublePiston dPiston;
	private boolean myValue;

	public PyramidLifter(DoublePiston_dPiston) 
	{
		dPiston = _dPiston;
	}

	public void engage()
	{
		dPiston.setValue(true);
	}
	public void disengage()
	{
		dPiston.setValue(false);
	}

}
