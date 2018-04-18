package javapack;

class P1
{
	void show()
	{
		System.out.println("Parent show method");
	}
}
class P2 extends P1
{
	void show()
	{
		System.out.println("Child show method");
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
		P2 b=new P2();
		b.show();

	}

}
