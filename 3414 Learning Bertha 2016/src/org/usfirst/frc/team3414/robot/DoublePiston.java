package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class DoublePiston {
	private DoubleSolenoid dSol;
	private boolean myValue;

	public DoublePiston(int channelA, int channelB) {
		dSol = new DoubleSolenoid(channelA, channelB);
	}

	public void setValue(boolean value) {
		if (value == true) {
			dSol.set(DoubleSolenoid.Value.kForward);
		} else {
			dSol.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public boolean getValue() {
		if (dSol.get() == (DoubleSolenoid.Value.kForward)) {
			return true;
		} else {
			
			return false;
		}

	}

}
