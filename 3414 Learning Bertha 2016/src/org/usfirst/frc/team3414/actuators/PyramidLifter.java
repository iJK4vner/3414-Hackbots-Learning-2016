package org.usfirst.frc.team3414.actuators;

public class PyramidLifter 
{
	private DoublePiston dPiston;

	public PyramidLifter(DoublePiston _dPiston) 
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
