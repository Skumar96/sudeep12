package javapack;

abstract class Shapes
{
	abstract void area();
	void show()
	{
		System.out.println("show method in abstract class");
	}
}
class Rect extends Shapes
{
	int l,b;
	Rect(int l,int b)
	{
		this.l=l;
		this.b=b;
	}
	public void area()
	{
		System.out.println("Area of Rect is:"+(l*b));
	}
}
class Tri extends Shapes
{
	int l,b;
	Tri(int l,int b)
	{
		this.l=l;
		this.b=b;
	}
	public void area()
	{
		System.out.println("Area of Tri is:"+(0.5*l*b));
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
		
		Rect r=new Rect(10,20);
		r.area();
		r.show();
		Tri t=new Tri(10,20);
		t.area();

	}

}
