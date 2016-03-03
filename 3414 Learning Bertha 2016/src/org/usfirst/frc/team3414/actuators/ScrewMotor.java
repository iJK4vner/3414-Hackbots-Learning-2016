package org.usfirst.frc.team3414.actuators;  

 
 public class ScrewMotor 
 { 
 	private Relay screw; 

 
	public ScrewMotor(Relay _screw) 
 	{ 
		screw = _screw; 
	} 
 
 	public void up() 
	{ 
		screw.set(Relay.Value.kForword); 
 	} 
 
 
 	public void down() 
	{ 
		screw.set(Relay.Value.kReverse); 
 	} 

 
 	public void stop() 
 	{ 
 		screw.set(Relay.Value.kOff); 
	} 
} 
