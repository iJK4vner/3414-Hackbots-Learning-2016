package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidClass {

	Solenoid JavehNoid;

	public SolenoidClass(int channel) {
		JavehNoid = new Solenoid(channel);

	}
	private boolean getJavehNoid() {
		return JavehNoid.get();
		
	}
    public void powermeup(){
    	JavehNoid.set(true);
     	JavehNoid.free();
    }    
    public void powermedown(){
    	JavehNoid.set(false);
    }
    public void control(boolean state){
    	JavehNoid.set(state);
     	JavehNoid.free();
    }
}