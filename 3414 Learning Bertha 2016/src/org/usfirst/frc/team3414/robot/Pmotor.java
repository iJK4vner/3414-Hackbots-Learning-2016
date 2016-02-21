package org.usfirst.frc.team3414.robot;
import edu.wpi.first.wpilibj.Servo;
public class Pmotor {
    
	private Servo TemServo;
	
	 public Pmotor(int channel) {
	 TemServo = new Servo(channel);
	 }
	 
	 //sets the angle of the Servo
	public void setTemServoAngle(double temdegrees){
		 TemServo.setAngle(temdegrees);
	 }
	//gets the physical position of the servo
	 public double tempos(){
		 return TemServo.get();
		 
		 
		 
		 
	 }
	 //sets position of the Servo
	 
	
		public void setTemPos(double temservopos){
		TemServo.set(temservopos);
		}
		
		
		
		public double temangle(){
			return TemServo.getAngle();
		}
}