package javapack;

interface I1
{
	void m1();
}
interface I2
{
	void m1();
}
interface I3 extends I1,I2
{
	void m3();
}

class Inter implements I3
{
	public void m1()
	{
		System.out.println("m1 in I1");
	}
	/*public void m2()
	{
		System.out.println("m2 in I2");
	}*/
	public void m3()
	{
		System.out.println("m3 in I3");
	}
}

public class MutiInher {

	public static void main(String[] args) {
		
		Inter b=new Inter();
		b.m1();
		//b.m2();
		b.m3();

	}

}
