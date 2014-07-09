/**
 * TestHugeNumber2.java
 * 
 * Demo Class for HugeNumber2
 * 
 * Project 4 due June 23, 2014
 * @author Stefano Prezioso
 * @version Jun 23, 2014
 */

public class TestHugeNumber2
{
	public static void main(String[] args)
	{
		HugeNumber2 testNum = new HugeNumber2();
		testNum.addMostSignificant(9);
		testNum.addMostSignificant(8);
		testNum.addMostSignificant(7);
		testNum.addMostSignificant(6);
		testNum.addMostSignificant(5);
		testNum.addMostSignificant(4);
		testNum.addMostSignificant(3);
		testNum.addMostSignificant(2);
		testNum.addMostSignificant(1);
		testNum.addMostSignificant(0);
		testNum.addMostSignificant(9);
		testNum.addMostSignificant(8);
		testNum.addMostSignificant(7);
		testNum.addMostSignificant(6);
		testNum.addMostSignificant(5);
		testNum.addMostSignificant(4);
		testNum.addMostSignificant(3);
		testNum.addMostSignificant(2);
		testNum.addMostSignificant(1);
		testNum.addMostSignificant(0);
		testNum.addMostSignificant(9);
		testNum.addMostSignificant(8);
		testNum.addMostSignificant(7);
		testNum.addMostSignificant(6);
		testNum.addMostSignificant(5);
		testNum.addMostSignificant(4);
		testNum.addMostSignificant(3);
		testNum.addMostSignificant(2);
		testNum.addMostSignificant(1);
		testNum.addMostSignificant(0);
		
		System.out.println("Created a long HugeNumber: " + testNum.toString());
		
		HugeNumber2 num1 = new HugeNumber2();
		HugeNumber2 num2 = new HugeNumber2();
		
		num1.addMostSignificant(3);
		num1.addMostSignificant(2);
		num1.addMostSignificant(1);
		num2.addMostSignificant(3);
		num2.addMostSignificant(2);
		num2.addMostSignificant(1);

		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num1 equals num2: " + num1.equals(num2));

		num1.reset();
		num2.reset();

		num1.addMostSignificant(9);
		num1.addMostSignificant(9);
		num1.addMostSignificant(9);
		num2.addMostSignificant(9);
		num2.addMostSignificant(9);
		num2.addMostSignificant(9);
		num1.addMostSignificant(9);
		
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num1 equals num2: " + num1.equals(num2));
		
		System.out.println("testNum is: " + testNum);
		System.out.println("testNum.clone() is: " + testNum.clone());

		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num1 + num2 is: " + HugeNumber2.add(num1, num2));
		
	}
}
/*
Created a long HugeNumber: 012345678901234567890123456789
num1: 123
num2: 123
num1 equals num2: true
num1: 9999
num2: 999
num1 equals num2: false
testNum is: 012345678901234567890123456789
testNum.clone() is: 012345678901234567890123456789
num1: 9999
num2: 999
num1 + num2 is: 10998
*/
