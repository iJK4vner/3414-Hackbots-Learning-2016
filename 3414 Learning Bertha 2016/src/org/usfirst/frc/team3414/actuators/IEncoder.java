package org.usfirst.frc.team3414.actuators;

public interface IEncoder {

	public int get();

	public boolean getDirection();

	public double getDistance();

	public double getRate();

	public int getRaw();

	public void reset();

	public void setDistancePerPulse(double distancePerPulse);

}
