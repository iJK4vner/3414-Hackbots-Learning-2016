package org.usfirst.frc.team3414.actuators;

public interface IEncoder {
	//public Encoders(int channel)
	//{
	//	EncodeOne = new Encoders(channel);
	//}
	public void free();

	public int get();
	
	public boolean getDirection();

	public double getDistance();
	
	public int getEncodingScale();
	
	public int getFPGAIndex();

	public double getPeriod();

	/*public PIDSourceType getPIDSourceType();

	public double getRate();
	
	//public int getRaw()
	{
		//return EncodeOne.getRaw();
	}
	//public int getSamplesToAverage()
	{
		//return EncodeOne.getSamplesToAverage();
	}
	//public String getSmartDashboardType()
	{
		//return EncodeOne.getSmartDashboardType();
	}
	//public boolean getStopped()
	{
		//return EncodeOne.getStopped();
	}
	public ITable getITable()
	{
		return EncodeOne.getITable();
	}
	public void initTable(ITable subtable)
	{
		return EncodeOne.initTable();
	}
	public double pidGet()
	{
		return EncodeOne.pidGet();
	}
	public void reset()
	{
		return EncodeOne.reset();
	}
	public void setDistancePerPulse(double distancePerPulse)
	{
		return EncodeOne.setDistancePerPulse();
	}
	public void 
	}
*/
}
