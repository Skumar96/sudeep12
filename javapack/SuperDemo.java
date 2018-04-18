package javapack;

class M
{
	int x,y;
	M(int a)
	{
		System.out.println("Parent cons:"+a);
	}
	void sum()
	{
		System.out.println("Sum is:"+(x+y));
	}
}
class N extends M
{
	N()
	{
		super(10);
		System.out.println("child cons");
		super.x=1;
		super.y=2;
		super.sum();
	}
}

public class SuperDemo {

	public static void main(String[] args) {
		N b=new N();
		

	}

}
