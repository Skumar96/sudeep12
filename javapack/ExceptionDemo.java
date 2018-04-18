package javapack;

public class ExceptionDemo {

	public static void main(String[] args) 
	{
		try
		{
			int x=10,y=2;
			int z=x/y;
			System.out.println("Z Value is:"+z);
			int a[]= {1,2,3,4};
			a[9]=10;
			System.out.println("********** End of try **************");
		}
		catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
			System.out.println("********** End of catch **************");
		}
		/*catch(ArithmeticException e)
		{
			System.out.println(e);
			//e.printStackTrace();
			System.out.println("********** End of catch1 **************");
		}
		catch(ArrayIndexOutOfBoundsException ie)
		{
			System.out.println(ie);
			//e.printStackTrace();
			System.out.println("********** End of catch2 **************");
		}*/
		
		System.out.println("********** End of Program **************");
		
	}

}
