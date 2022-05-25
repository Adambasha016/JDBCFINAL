package org.js.lightApp;

public class LightFactory
{
	
	public static ISwitch getLight(String type)	
	{
		if(type.equalsIgnoreCase("LedLight"))
		{
			return new LedLightImpl();
		}
		else if (type.equalsIgnoreCase("TubeLight"))
		{
			return new TubeLightImpl();
		}
		else 
		{
			System.out.println("no such lightfound");
			return null;
		}
	}

}
