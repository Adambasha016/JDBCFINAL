package org.js.lightApp;


public class TubeLightImpl implements ISwitch 
{

	@Override
	public void sOn()
	{
		System.out.println("tubelight swich is on");
		
	}

	@Override
	public void sOff()
	{
		System.out.println("TubeLight is off)");
		
	}
	

}
