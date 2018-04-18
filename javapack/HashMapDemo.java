package javapack;

import java.util.*;  
	class HashMapDemo
	{  
	 public static void main(String args[]){  
	   
	  HashMap<Integer,String> hm=new HashMap<Integer,String>();  
	  
	  hm.put(100,"Amit");  
	  hm.put(101,"Vijay");  
	  hm.put(102,"Rahul"); 
	  hm.put(100,"A");
	  hm.put(null,"A");
	  hm.put(103,null);
	  hm.put(104,null);
	  hm.put(null,"B");
	  System.out.println("Size of collection is:"+hm.size());
	  System.out.println("Collection elements are:");
	  for(Map.Entry m:hm.entrySet())
	  {  
	   System.out.println(m.getKey()+" "+m.getValue());  
	  }  
	 }  
	}  


