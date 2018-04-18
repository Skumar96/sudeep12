package javapack;

class A1
{
	A1()
	{
		System.out.println("Parent cons");
	}
}
class A2 extends A1
{
	A2()
	{
		System.out.println("Child cons");
	}
}


public class ConsInher {

	public static void main(String[] args) {
		A2 b=new A2();

	}

}
