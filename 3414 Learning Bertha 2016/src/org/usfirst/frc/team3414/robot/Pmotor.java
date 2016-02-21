package org.usfirst.frc.team3414.robot;
import edu.wpi.first.wpilibj.Servo;
public class Pmotor {
    
	private Servo myServo;
	
	 public Pmotor(int channel) {
	 myServo = new Servo(channel);
	 }
	 
	 //sets the angle of the Servo
	public void setTemServoAngle(double temdegrees){
		 myServo.setAngle(temdegrees);
	 }
	
	//gets the physical position of the servo
	 public double tempos(){
		 return myServo.get();
		 
		 
		 
	 }
	 //sets position of the Servo
	 
	
		public void setTemPos(double temservopos){
		myServo.set(temservopos);
		}
		
		
		
		public double temangle(){
			return myServo.getAngle();
		}
}