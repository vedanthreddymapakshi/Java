package lab10;

public class Main 
{
	public static void main(String args[])
	{
		sports_car sc=new sports_car();
		minvan mv=new minvan();
		
		sc.price=10000;
		sc.brand="Toyota";
		sc.name="camry";
		sc.year=2009;
		sc.spoiler=true;
		
		mv.price=10000;
		mv.brand="ford";
		mv.name="corolla";
		mv.year=2090;
		mv.autodoor=false;
		
		sc.print();
		sc.display();
		
		mv.print();
		mv.display();
		
	}
	
	
}
