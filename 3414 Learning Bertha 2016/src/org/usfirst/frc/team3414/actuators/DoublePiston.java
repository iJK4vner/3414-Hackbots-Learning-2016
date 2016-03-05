package org.usfirst.frc.team3414.actuators;

public class DoublePiston 
{
	private DSolenoid dSol;

	public DoublePiston(DSolenoid _dSol) 
	{
		dSol = _dSol;
	}

	public void engage()
	{
		dSol.setValue(true);
	}

	public void disengage()
	{
		dSol.setValue(false);
	}

}
