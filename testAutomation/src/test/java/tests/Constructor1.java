package tests;

public class Constructor1 {
	static {
		System.out.println("Static Information Block");
	}
	
	{
		System.out.println("IIB");
	}
	
	Constructor1(){
		System.out.println("Default constructor");
	}

	public static void main(String[] args) {
		System.out.println("main starts");
		Constructor1 c = new Constructor1();
		System.out.println("main ends");
	}

}
