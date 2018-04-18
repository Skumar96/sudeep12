package javapack;

class P
{
	void meth1()
	{
		System.out.println("Parent method");
	}
}
class Q extends P
{
	void meth2()
	{
		System.out.println("Child method");
	}
}
public class InherDemo {

	public static void main(String[] args) {
		Q b=new Q();
		b.meth1();
		b.meth2();

	}

}
