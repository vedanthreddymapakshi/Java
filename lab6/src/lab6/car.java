package lab6;
import java.util.*;
public class car {
	
	String brand="";
	String model="";
	int year=0;
	
	public car(String b,String m,int y)
	{
		brand=b;
		model=m;
		year=y;
	}

	String getbrand()
	{
		return brand;
	}
	
	String getmodel()
	{
		return model;
	}
	int getyear()
	{
		return year;
	}
	
}
