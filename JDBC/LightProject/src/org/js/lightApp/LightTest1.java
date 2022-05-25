package org.js.lightApp;

import java.util.Scanner;

public class LightTest1 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter tje tyep of light");
		String type =sc.nextLine();
		ISwitch light=LightFactory.getLight(type);
		if(light !=null)
		{
			light.sOn();
			light.sOff();
			
		}
	}

}
