/**
 * TestHugeList.java
 * 
 * Demo class for HugeList
 * 
 * Project 4 due June 23, 2014
 * @author Stefano Prezioso
 * @version Jun 23, 2014
 */

public class TestHugeList
{
	public static void main(String[] args)
	{
		HugeList testList = new HugeList();
		testList.addToFront(new Rectangle(2, 4));
		testList.addToFront(new Rectangle(6, 9));
		testList.addToFront(new Rectangle(9, 8));
		testList.addToFront(new Rectangle(4, 1));
		testList.addToFront(new Rectangle(1, 3));
		System.out.println("Created a HugeList of Rectangles: \n" + testList.toString());
		
		HugeList copyOfTestList = (HugeList)testList.clone();
		System.out.println("Created a copy of testList: \n" + copyOfTestList.toString());
		
		System.out.println("Number of items in testList: " + testList.count());
		
		System.out.println("testList equals copyOfTestList: " + testList.equals(copyOfTestList));
		
		HugeList testList2 = new HugeList();
		testList2.addToFront(new Rectangle(1, 4));
		testList2.addToFront(new Rectangle(6, 9));
		testList2.addToFront(new Rectangle(9, 6));
		testList2.addToFront(new Rectangle(4, 1));
		testList2.addToFront(new Rectangle(9, 3));
		System.out.println("Created a different HugeList of Rectangles: \n" + testList2.toString());
		System.out.println("testList equals testList2: " + testList.equals(testList2));
	}
}
/*
Created a HugeList of Rectangles: 
Shape: Rectangle
Length: 1
Width: 3
Perimeter: 8.0
Area: 3.0

Shape: Rectangle
Length: 4
Width: 1
Perimeter: 10.0
Area: 4.0

Shape: Rectangle
Length: 9
Width: 8
Perimeter: 34.0
Area: 72.0

Shape: Rectangle
Length: 6
Width: 9
Perimeter: 30.0
Area: 54.0

Shape: Rectangle
Length: 2
Width: 4
Perimeter: 12.0
Area: 8.0


Created a copy of testList: 
Shape: Rectangle
Length: 1
Width: 3
Perimeter: 8.0
Area: 3.0

Shape: Rectangle
Length: 4
Width: 1
Perimeter: 10.0
Area: 4.0

Shape: Rectangle
Length: 9
Width: 8
Perimeter: 34.0
Area: 72.0

Shape: Rectangle
Length: 6
Width: 9
Perimeter: 30.0
Area: 54.0

Shape: Rectangle
Length: 2
Width: 4
Perimeter: 12.0
Area: 8.0


Number of items in testList: 5
testList equals copyOfTestList: true
Created a different HugeList of Rectangles: 
Shape: Rectangle
Length: 9
Width: 3
Perimeter: 24.0
Area: 27.0

Shape: Rectangle
Length: 4
Width: 1
Perimeter: 10.0
Area: 4.0

Shape: Rectangle
Length: 9
Width: 6
Perimeter: 30.0
Area: 54.0

Shape: Rectangle
Length: 6
Width: 9
Perimeter: 30.0
Area: 54.0

Shape: Rectangle
Length: 1
Width: 4
Perimeter: 10.0
Area: 4.0


testList equals testList2: false
*/