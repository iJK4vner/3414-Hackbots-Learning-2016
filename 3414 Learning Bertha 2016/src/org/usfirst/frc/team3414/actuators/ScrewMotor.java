package org.usfirst.frc.team3414.actuators; 

 
 import org.usfirst.frc.team3414.actuators.CANMotor;

import edu.wpi.first.wpilibj.Relay; 

 
 public class ScrewMotor 
 { 
 	private Relay screw; 
 	private static final double SPEED = 0.5; 
 	private static final double STOP = 0; 

	public ScrewMotor(Relay _screw) 
 	{ 
		screw = _screw; 
	} 
 	
//	public ScrewMotor(CANMotor _screw) 
// 	{ 
//		screw = _screw; 
//	} 
 
 	public void up() 
	{ 
		screw.set(Relay.Value.kForward); 
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
