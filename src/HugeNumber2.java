/**
 * HugeNumber2.java
 * 
 * HugeNumber2 class that creates a doubly linked
 * list of digits to represent a very long number
 * 
 * Project 4 due June 23, 2014
 * @author Stefano Prezioso
 * @version Jun 23, 2014
 */

public class HugeNumber2
{
	/**
	 * Node Inner Class
	 * 
	 * -Creates a node with an int value and a Node link called next.
	 * 
	 * @author Stefano Prezioso
	 *
	 */
	private class Node
	{
		Node next;
		Node previous;
		int value;

		/**
		 * Empty Constructor
		 * 
		 * -Sets next to null and value to -1.
		 */
		@SuppressWarnings("unused")
		public Node()
		{
			next = null;
			previous = null;
			value = -1;
		}

		//		/**
		//		 * Sets value to the given parameter and
		//		 * next to null.
		//		 * 
		//		 * @param val Parameter to set value.
		//		 */
		//		public Node(int val)
		//		{
		//			next = null;
		//			value = val;
		//		}

		/**
		 * Complete constructor.
		 * 
		 * @param val Sets value.
		 * @param link Sets link.
		 */
		public Node(int val, Node next, Node previous)
		{
			this.next = next;
			this.previous = previous;
			value = val;
		}

		/**
		 * toString
		 * 
		 * -Returns value of node as a string.
		 * @return A string of the digit the node represents.
		 */
		public String toString()
		{
			return "" + this.value;
		}
	}

	Node head;

	/**
	 * Empty Constructor
	 * 
	 * Sets head to null.
	 */
	public HugeNumber2()
	{
		head = null;
	}

	/**
	 * Copy Constructor
	 * 
	 * -Creates deep copy of the passed HugeNumber-
	 */
	public HugeNumber2(HugeNumber2 original)
	{
		HugeNumber2 clone = new HugeNumber2();
		
		//If original is empty
		if (original.head == null)
		{
			this.head = null;
		}
		else
		{
			//Create head clone, and set up temp and previous
			clone.head = new Node(original.head.value, original.head.next, null);
			Node temp = clone.head.next;
			Node previous = clone.head;
			
			//Traverse through the rest of original
			while(temp != null)
			{
				Node newNode = new Node(temp.value, temp.next, previous);
				previous.next = newNode;
				previous = newNode;
				temp = temp.next;
			}
			
			this.head = clone.head;
		}
	}

	/**
	 * Returns number of digits in HugeNumber
	 * 
	 * @return int of the number of digits (nodes)
	 */
	public int count()
	{
		if (head == null)
		{
			return 0;
		}
		else if (head.next == null)
		{
			return 1;
		}
		else
		{
			Node temp = head;
			int counter = 0;
			while (temp != null)
			{
				counter++;
				temp = temp.next;
			}
			return counter;
		}
	}

	/**
	 * Returns true if both HugeNumbers are equal.
	 * @param num2 HugeNumber2
	 * @return Boolean. True if numbers are equal, false otherwise.
	 */
	public boolean equals(HugeNumber2 num2)
	{
		if (this.count() != num2.count())
		{
			return false;
		}
		else if (this.head == null && num2.head == null)
		{
			return true;
		}
		else
		{
			Node tempLink1 = this.head;
			Node tempLink2 = num2.head;
			while (tempLink1 != null)
			{
				if (tempLink1.value != tempLink2.value)
				{
					return false;
				}
				tempLink1 = tempLink1.next;
				tempLink2 = tempLink2.next;
			}
			return true;
		}
	}

	/**
	 * toString
	 * 
	 * - Prints entire value of HugeNumber as a String
	 */
	public String toString()
	{
		Node temp = head;
		String s = "";
		while (temp != null)
		{
			s += temp.toString();
			temp = temp.next;
		}
		return s;
	}

	/**
	 * Adds left most digit to the HugeNumber
	 * @param val The digit to be added. Must be 0-9.
	 */
	public void addMostSignificant(int val)
	{
		//Catch invalid entry
		if( val < 0 || val > 9)
		{
			System.err.println("Invalid Digit Entry: " + val);
			System.exit(0);
		}
		
		//Creating a new number
		if (head == null)
		{
			head = new Node(val, null, null);
		}
		else //Add a digit to the left of the existing number
		{
			Node newNode = new Node(val, head, null);
			head.previous = newNode;
			head = newNode;
		}
	}

	/**
	 * Resets number back to null.
	 */
	public void reset()
	{
		head = null;
	}

	/**
	 * Creates and returns a deep copy clone of the calling HugeNumber
	 */
	public Object clone()
	{
		return new HugeNumber2(this);
	}
	
	/**
	 * Adds two HugeNumbers together. Handles carryovers.
	 * @param num1 First HugeNumber to be added
	 * @param num2 Second HugeNumber to be added.
	 * @return hugeSum is the sum of num1 and num2
	 */
	public static HugeNumber2 add(HugeNumber2 num1, HugeNumber2 num2)
	{
		HugeNumber2 hugeSum = new HugeNumber2(num1);
		Node temp = hugeSum.head;
		Node temp2 = num2.head;
		
		//Traverse to last digit in num1
		while (temp.next != null)
		{
			temp = temp.next;
		}
		
		//Traverse to last digit in num2
		while (temp2.next != null)
		{
			temp2 = temp2.next;
		}
		
		while (temp != null && temp2 != null)
		{
			//Add values together
			temp.value += temp2.value;
			//Handle carryovers
			if (temp.value > 9)
			{
				temp.value = temp.value - 10;
				
				//Handle new digit creation
				if (temp.previous == null)
				{
					hugeSum.addMostSignificant(0);
				}
				
				temp.previous.value++;
			}
			
			//Move temp and temp2 to the digit to the left
			temp = temp.previous;
			temp2 = temp2.previous;
		}
		
		return hugeSum;
	}
}
