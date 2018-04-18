package javapack;

class E
{
	int x,y;
	E(int x)
	{
		System.out.println("1 para cons:"+x);
	}
	E(int x,int y)
	{
		this(10);
		this.x=x;
		this.y=y;
		this.sum();
	}
	void sum()
	{
		System.out.println("Sum is:"+(x+y));
	}
}

public class ThisDemo {

	public static void main(String[] args) {
		
		E b=new E(1,2);
		//b.sum();
		

	}

}
