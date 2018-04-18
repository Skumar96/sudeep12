package javapack;

public class StringDemo {

	public static void main(String[] args) {
		
		String s1="Abc xyz";
		String s2=new String("abc");
		char ch[]= {'x','y','z'};
		String s3=new String(ch);
		
		System.out.println("Length of s1:"+s1.length());
		if(s1.equals(s2))
		{
			System.out.println("String are equal");
		}
		else
		{
			System.out.println("String are not equal");
		}
		if(s1.contains(s3))
		{
			System.out.println("s3 available in s1");
		}
		else
		{
			System.out.println("s3 not available in s1");
		}

	}

}
