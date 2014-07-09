/**
 * HugeNumber1.java
 * 
 * HugeNumber1 class that creates a singly linked list of
 * digits to represent a very long number.
 * 
 * Project 4 due June 23, 2014
 * @author Stefano Prezioso
 * @version Jun 21, 2014
 */

public class HugeNumber1
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
		public Node(int val, Node link)
		{
			next = link;
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
	public HugeNumber1()
	{
		head = null;
	}

	/**
	 * Copy Constructor
	 * 
	 * -Creates deep copy of the passed HugeNumber-
	 */
	public HugeNumber1(HugeNumber1 original)
	{
		HugeNumber1 clone = new HugeNumber1();
		if (original.head == null)
		{
			this.head = null;
		}
		else 
		{
			clone.head = new Node(original.head.value, original.head.next);
			Node temp = clone.head.next;
			Node previous = clone.head;

			while(temp != null)
			{
				Node newNode = new Node(temp.value, temp.next);
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
	public boolean equals(HugeNumber1 num2)
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
	 * Adds left most value to the HugeNumber
	 * @param val The digit to be added. Must be 0-9.
	 */
	public void addMostSignificant(int val)
	{
		if( val < 0 || val > 9)
		{
			System.err.println("Invalid Digit Entry: " + val +" Please re-enter:");
			System.exit(0); //Replace with Scanner
		}
		head = new Node(val, head);
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
		return new HugeNumber1(this);
	}
	
	/**
	 * Adds to HugeNumbers together. Does not handle carry overs.
	 * @param num1 First HugeNumber to be added
	 * @param num2 Second HugeNumber to be added.
	 * @return hugeSum is the sum of num1 and num2
	 */
	public static HugeNumber1 add(HugeNumber1 num1, HugeNumber1 num2)
	{
		if (num1.count() != num2.count())
		{
			return null;
		}
		else 
		{
			HugeNumber1 hugeSum = new HugeNumber1(num1);
			Node temp = hugeSum.head;
			Node temp2 = num2.head;
			
			while(temp != null)
			{
				temp.value += temp2.value;
				if (temp.value > 9)
				{
					temp.value = 9;
				}
				temp = temp.next;
				temp2 = temp2.next;
			}
			return hugeSum;
		}
	}

}