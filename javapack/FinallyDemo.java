package javapack;

public class FinallyDemo {

	public static void main(String[] args) {
		try
		{
			int x=10,y=2;
			int z=x/y;
			System.out.println("Z Value is:"+z);
			int a[]= {1,2,3,4};
			a[9]=10;
			System.out.println("********** End of try **************");
		}
		/*catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
			System.out.println("********** End of catch **************");
		}*/
		finally
		{
			System.out.println("Finally block");
		}
		System.out.println("********** End of Program **************");

	}

}
