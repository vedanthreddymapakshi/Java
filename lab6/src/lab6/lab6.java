package lab6;

public class lab6 {
	
	public static void main(String args[])
	{
		car mycar=new car("Ford", "Mustang", 2017);
		System.out.println("Brand: "+ mycar.getbrand());
		System.out.println("Model: "+ mycar.getmodel());
		System.out.println("year: "+ mycar.getyear());
	}
}
