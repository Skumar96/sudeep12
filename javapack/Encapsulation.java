package javapack;

class EC
{
	private String name;
	private int age;
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge()
	{
		return age;
	}
}

public class Encapsulation {

	public static void main(String[] args) {
		EC b=new EC();
		b.setName("Appium");
		System.out.println("Name is:"+b.getName());

	}

}
