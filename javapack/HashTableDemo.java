package javapack;

import java.util.*;  
	class HashTableDemo
	{  
	 public static void main(String args[]){  
	   
	  Hashtable<Integer,String> hm=new Hashtable<Integer,String>();  
	  
	  hm.put(100,"Amit");  
	  hm.put(101,"Vijay");  
	  hm.put(102,"Rahul"); 
	  hm.put(100,"A");
	  hm.put(100,"B");
	 /* hm.put(105,null);
	  hm.put(103,null);
	  hm.put(104,null);
	  hm.put(null,"B");*/
	  
	  System.out.println("Size of collection is:"+hm.size());
	  System.out.println("******** elements are *****************");
	  for(Map.Entry m:hm.entrySet())
	  {  
	   System.out.println(m.getKey()+" "+m.getValue());  
	  }  
	 }  
	}  
