package homework4;

import java.io.*;
import java.util.*;

public class inventory 
{
	int nc=0;;
	car [] cars=new car[100];
	
	public void initcars() throws FileNotFoundException
	{
		for(int i=0;i<100;i++)
			cars[i]=new car();
		
		File textfile=new File("inventory.txt");
		Scanner in=new Scanner(textfile);
		
		while(in.hasNextLine())
		{
			String line=in.nextLine();
			StringTokenizer st=new StringTokenizer(line,"/");
			while(st.hasMoreTokens())
			{
				cars[nc].vin=st.nextToken();
				cars[nc].brand=st.nextToken();
				cars[nc].model=st.nextToken();
				cars[nc].year=Integer.parseInt(st.nextToken());
				cars[nc].mileage=Integer.parseInt(st.nextToken());
				cars[nc].price=Double.parseDouble(st.nextToken());
				cars[nc].colour=st.nextToken();
			}
			nc++;
		}
	}
	
	
	public void display()
	{
		System.out.println("VIN" + "  " +"BRAND"+"  "+ "MODEL"+"  "+"YEAR"+"  "+"MILEAGE"+ "  " +"PRICE"+"  "+"COLOUR");
		for(int i=0;i<nc;i++)
		{
			System.out.println(cars[i].vin+"  "+ cars[i].brand+ "  "+ cars[i].model+"  " + cars[i].year+"  "+cars[i].mileage+"  "+cars[i].price+"  "+cars[i].colour);
		}
		System.out.println(nc);
	}
	
	public void swap(int j)
	{
		String t1=cars[j+1].vin;
		cars[j+1].vin=cars[j].vin;
		cars[j].vin=t1;
		
		String t2=cars[j+1].brand;
		cars[j+1].brand=cars[j].brand;
		cars[j].brand=t2;
		
		String t3=cars[j+1].model;
		cars[j+1].brand=cars[j].model;
		cars[j].model=t3;
		
		int t4=cars[j+1].year;
		cars[j+1].year=cars[j].year;
		cars[j].year=t4;
		
		int t5=cars[j+1].mileage;
		cars[j+1].mileage=cars[j].mileage;
		cars[j].mileage=t5;
		
		double t6=cars[j+1].price;
		cars[j+1].price=cars[j].price;
		cars[j].price=t6;
		
		String t7=cars[j+1].colour;
		cars[j+1].colour=cars[j].colour;
		cars[j].colour=t7;
		 		
	}
	
	//sort
	public void sort()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("1. Sort by vin");
		System.out.println("2. Sort by brand");
		System.out.println("3. Sort by model");
		System.out.println("4. Sort by year");
		System.out.println("5. Sort by mileage");
		System.out.println("6. Sort by price");
		System.out.println("7. Sort by colour");
		int choice=in.nextInt();
		if(choice==1)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[i].vin.compareTo(cars[j+1].vin);
					if(ct>0)
					{
						swap(j);
						 		
					}//if
				}
			}
		}
		
		else if(choice==2)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].brand.compareTo(cars[j+1].brand);
					if(ct>0)
					{
						swap(j);
					}
				}
			}
		}
		else if(choice==3)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].model.compareTo(cars[j+1].model);
					if(ct>0)
					{
						swap(j);
					}
				}
			}
		}
		
		else if(choice==4)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].year>cars[j+1].year)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==5)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].mileage>cars[j+1].mileage)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==6)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					if(cars[j].price>cars[j+1].price)
					{
						swap(j); 		
					}
				}
			}
		}
		
		else if(choice==7)
		{
			for(int i=0;i<nc;i++)
			{
				for(int j=0;j<nc-1;j++)
				{
					int ct=cars[j].colour.compareTo(cars[j+1].colour);
					if(ct>0)
					{
						swap(j); 		
					}
				}
			}
		}
	}//sort
	
	public void save() throws FileNotFoundException
	{
		PrintWriter op=new PrintWriter("inventory.txt");
		
		for(int i=0;i<nc;i++)
		{
			op.println(cars[i].vin+"/"+ cars[i].brand+ "/"+ cars[i].model+"/" + cars[i].year+"/"+cars[i].mileage+"/"+cars[i].price+"/"+cars[i].colour);
		}
		
		op.close();
		
	}
	
	public void addcar()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		cars[nc].vin=in.next();
		System.out.println("Enter brand: ");
		cars[nc].brand=in.next();
		System.out.println("Enter model: ");
		cars[nc].model=in.next();
		System.out.println("Enter year: ");
		cars[nc].year=in.nextInt();
		System.out.println("Enter mileage: ");
		cars[nc].mileage=in.nextInt();
		System.out.println("Enter price: ");
		cars[nc].price=in.nextDouble();
		System.out.println("Enter colour: ");
		cars[nc].colour=in.next();
		
		System.out.println("VIN" + "  " +"BRAND"+"  "+ "MODEL"+"  "+"YEAR"+"  "+"MILEAGE"+ "  " +"PRICE"+"  "+"COLOUR");
		
		System.out.println(cars[nc].vin+" "+ cars[nc].brand+ " "+ cars[nc].model+" " + cars[nc].year+" "+cars[nc].mileage+" "+cars[nc].price+" "+cars[nc].colour);
		nc++;
		
		System.out.println("This car has been successfully added!");
	}
	
	public void saveacar()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the VIN of the car you want to save: ");
		String vintemp=in.next();
	}
	
	public void deletecar()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		String v=in.next();
		
		int pos=0;
		for(int i=0;i<nc;i++)
		{
			if(cars[i].vin.equals(v))
			{
				pos=i;
				break;
			}
		}
		
		for(int i=pos;i<nc;i++)
		{
			cars[i].vin=cars[i+1].vin;
			cars[i].brand=cars[i+1].brand;
			cars[i].model=cars[i+1].model;
			cars[i].year=cars[i+1].year;
			cars[i].mileage=cars[i+1].mileage;
			cars[i].price=cars[i+1].price;
			cars[i].colour=cars[i+1].colour;
		}
		nc--;
		System.out.println("Car successfully deleted");
	}
	
	public void updatecar()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter vin: ");
		String v=in.next();
		
		int i=0;
		for(i=0;i<nc;i++)
		{
			if(cars[i].vin.equals(v))
				break;
		}
		
		System.out.println("1. Update brand");
		System.out.println("2. Update model");
		System.out.println("3. Update year");
		System.out.println("4. Update mileage");
		System.out.println("5. Update price");
		System.out.println("6. Update colour");
		int c=in.nextInt();
		
		if(c==1)
		{
			System.out.println("Input brand: ");
			cars[i].brand=in.next();
		}
		
		if(c==2)
		{
			System.out.println("Input model: ");
			cars[i].model=in.next();
		}
		
		if(c==3)
		{
			System.out.println("Input year: ");
			cars[i].year=in.nextInt();
		}
		
		if(c==4)
		{
			System.out.println("Input mileage: ");
			cars[i].mileage=in.nextInt();
		}
		
		if(c==5)
		{
			System.out.println("Input price: ");
			cars[i].price=in.nextDouble();
		}
		
		if(c==6)
		{
			System.out.println("Input colour: ");
			cars[i].colour=in.next();
		}
		
		System.out.println("Its been updated");
		
	}
	
	
}

