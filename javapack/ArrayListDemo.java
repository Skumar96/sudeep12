package javapack;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		ArrayList<String> al1=new ArrayList<String>();
		al1.add("X");
		al1.add("Y");
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("A");
		al.addAll(al1);
		System.out.println("No of elements:"+al.size());
		//al.remove("C");
		System.out.println("****** Elements are *********");
		for(String s:al)
		{
			System.out.println(s);
		}
		/*Iterator<String> itr=al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/

	}

}
