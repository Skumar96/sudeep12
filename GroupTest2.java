package abcpack;

import org.testng.annotations.Test;

public class GroupTest2 
{
	@Test(groups="G1")
	public void meth1()
	{
		System.out.println("Meth1 in GT2");
	}
	@Test(groups="G1")
	public void meth2()
	{
		System.out.println("Meth2 in GT2");
	}
	@Test(groups="G2")
	public void meth3()
	{
		System.out.println("Meth3 in GT2");
	}
	@Test(groups="G3")
	public void meth4()
	{
		System.out.println("Meth4 in GT2");
	}

}
