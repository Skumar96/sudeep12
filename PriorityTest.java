package abcpack;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority=3)
	public void m1()
	{
		System.out.println("M1");
	}
	@Test(priority=4)
	public void m2()
	{
		System.out.println("M2");
	}
	@Test(priority=2)
	public void m3()
	{
		System.out.println("M3");
	}
	@Test(priority=1)
	public void m4()
	{
		System.out.println("M4");
	}

}
