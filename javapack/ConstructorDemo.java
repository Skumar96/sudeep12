package javapack;

class M2
{
	int x,y;
	M2(int a,int b)
	{
		x=a;
		y=b;
	}
	void sum()
	{
		System.out.println("Sum is:"+(x+y));
	}
}

public class ConstructorDemo {

	public static void main(String[] args) {
		M2 b1=new M2(10,20);
		b1.sum();
		M2 b2=new M2(1,2);
		b2.sum();

	}

}
