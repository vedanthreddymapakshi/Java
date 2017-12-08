package lab8;
import java.util.*;

public class person {
	int one,two,three=0;
	
	public person(int a, int b, int c)
	{
		one=a;
		two=b;
		three=c;
	}
	
	void displayone()
	{
		System.out.println(one);
	}
	
	void displaytwo()
	{
		System.out.println(two);
	}
	
	void displaythree()
	{
		System.out.println(three);
	}
	
	void updateone(int a)
	{
		one=a;
	}
	
	void updatetwo(int b)
	{
		two=b;
	}
	
	void updatethree(int c)
	{
		three=c;
	}
	
	

}
