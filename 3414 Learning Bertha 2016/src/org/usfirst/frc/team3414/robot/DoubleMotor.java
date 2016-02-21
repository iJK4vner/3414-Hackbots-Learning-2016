package org.usfirst.frc.team3414.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class DoubleMotor {

private CANTalon MotorOne;
private CANTalon MotorTwo;


/**
 * Creates the Double Motor
 * @param one
 * @param two
 */
   public DoubleMotor(int one, int two){
	  MotorOne = new CANTalon(one);
	  MotorTwo = new CANTalon(two);

  }
   
   /**
    * Sets speed of both motors	 of double motor
    * @param speed
    */
   public void setSpeed(double speed){
	   MotorTwo.set(speed);
	   MotorOne.set(speed);
   }
   
   
   
 }
