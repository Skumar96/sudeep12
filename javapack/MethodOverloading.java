package javapack;

class C
{
	void sum()
	{
		System.out.println("default method");
	}
	void sum(int x)
	{
		System.out.println("1 Param method");
	}
	void sum(int x,int y)
	{
		System.out.println("2 Param method");
	}
}

public class MethodOverloading {
	
	public static void main(String[] args) {
		C b=new C();
		b.sum(2);
		b.sum(1, 2);

	}

}
