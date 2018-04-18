package javapack;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<String> al=new LinkedList<String>();
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
