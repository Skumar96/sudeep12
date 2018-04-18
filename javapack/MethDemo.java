package javapack;

class M1
{
	//int x=10,y=20;
	int x,y;
	void sum1()
	{
		System.out.println("Sum1:"+(x+y));
	}
	void sum2(int a,int b)
	{
		System.out.println("Sum2:"+(a+b));
	}
	
}

public class MethDemo 
{
	public static void main(String[] args) 
	{
		M1 b=new M1();
		b.x=10;
		b.y=20;
		b.sum1();
		b.sum2(1, 2);

	}

}
