package test;

public class Test01run {

	public static void main(String[] args) {

		Test01 test01=new Test01();
		
		int d = test01.calculator(2,3,4);
		System.out.println(d);
		
		
		/*
		 * int number = 10; System.out.println(number);
		 */
		
		System.out.println(test01.getNumber());
		
		test01.setNumber(8);
		
		System.out.println(test01.getNumber());
	}

}
