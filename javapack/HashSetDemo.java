package javapack;

import java.util.HashSet;
import java.util.LinkedList;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet<String> al=new HashSet<String>();
		al.add("A");
		al.add("B");
		al.add("A");
		System.out.println("No of elements:"+al.size());
		System.out.println("********** Elements are *********");
		for(String s:al)
		{
			System.out.println(s);
		}


	}

}
