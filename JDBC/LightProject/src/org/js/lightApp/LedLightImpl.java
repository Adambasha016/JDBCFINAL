package org.js.lightApp;

public class LedLightImpl  implements ISwitch {

	@Override
	public void sOn() 
	{
	System.out.println("ledlight is on");	
	}

	@Override
	public void sOff() 
	{
		System.out.println("led light is off");
		
	}

}
