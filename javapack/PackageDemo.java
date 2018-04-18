package javapack;

import pack.B1;
import pack.B2;

public class PackageDemo {

	public static void main(String[] args) {
		B1 obj1=new B1(10,20);
		obj1.sum();
        B2 obj2=new B2(10,20);
        obj2.sub();
	}

}
