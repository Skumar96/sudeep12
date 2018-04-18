package javapack;

public class SwitchDemo {

	public static void main(String[] args) {
		
		char ch='G';
		switch(ch)
		{
		case 'R': System.out.println("Red");
		break;
		case 'G': System.out.println("Green");
		break;
		case 'B': System.out.println("Blue");
		break;
		case 'Y': System.out.println("Yellow");
		break;
		default : System.out.println("No matching color");
		}



	}

}
