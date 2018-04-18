package javapack;

class D
{
	D()
	{
		System.out.println("Default cons");
	}
	D(int a)
	{
		System.out.println("1 param cons");
	}
	D(int a,int b)
	{
		System.out.println("2 param cons");
	}
}
public class ConsOver {

	public static void main(String[] args) {
		
		D b=new D(2,8);

	}

}
