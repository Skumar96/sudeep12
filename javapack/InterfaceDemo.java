package javapack;

interface I
{
	void meth1();
}
class AB implements I
{
	public void meth1()
	{
		System.out.println("meth1 in AB");
	}
}
class AC implements I
{
	public void meth1()
	{
		System.out.println("meth1 in AC");
	}
}
public class InterfaceDemo {

	public static void main(String[] args) {
		AB b=new AB();
		b.meth1();

	}

}
