package javapack;

class B
{
	int x,y;
	B(int a,int b)
	{
		x=a;
		y=b;
	}
	void sum()
	{
		System.out.println("Sum:"+(x+y));
	}
}

public class ConsDemo {

	public static void main(String[] args) {
		
		B b1=new B(1,2);
		B b2=new B(10,20);
		b2.sum();

	}

}
