package javapack;

class A
{
	//int x=10,y=20;
	int x,y;
	void sum1()
	{
		System.out.println("Sum1:"+(x+y));
	}
	void sum2(int a,int b)
	{
		System.out.println("sum2:"+(a+b));
	}
	int sum3()
	{
		return x+y;
	}
}

public class MethodDemo {

	public static void main(String[] args) {
		
		A b1=new A();
		b1.x=10;
		b1.y=20;
		b1.sum1();
		
		A b2=new A();
		b2.x=1;
		b2.y=2;
		b2.sum1();
		
		/*b.sum1();
		b.sum2(1, 2);
		int result=b.sum3();
		System.out.println("sum3:"+result);*/

	}

}
