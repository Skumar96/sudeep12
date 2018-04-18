package abcpack;

import org.testng.annotations.Test;

public class DependencyTest {
	@Test
	public void m1()
	{
		System.out.println("M1");
		int n=10/0;
	}
	@Test(dependsOnMethods="m1")
	public void m2()
	{
		System.out.println("M2");
	}

}
