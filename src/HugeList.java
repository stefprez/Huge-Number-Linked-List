/**
 * HugeList.java
 * 
 * Generic HugeList class that creates a doubly linked
 * list of objects
 * 
 * Project 4 due June 23, 2014
 * @author Stefano Prezioso
 * @version Jun 23, 2014
 */

public class HugeList
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
		@SuppressWarnings("unused")
		Node previous;
		Object value;

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
			value = null;
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
		public Node(Object obj, Node next, Node previous)
		{
			this.next = next;
			this.previous = previous;
			value = obj;
		}

		/**
		 * toString
		 * 
		 * -Returns value of node as a string.
		 * @return A string of the digit the node represents.
		 */
		public String toString()
		{
			return this.value.toString() + "\n";
		}
	}

	Node head;

	/**
	 * Empty Constructor
	 * 
	 * Sets head to null.
	 */
	public HugeList()
	{
		head = null;
	}

	/**
	 * Copy Constructor
	 * 
	 * -Creates deep copy of the passed HugeList-
	 */
	public HugeList(HugeList original)
	{
		HugeList clone = new HugeList();
		
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
	 * Returns number of items in HugeList
	 * 
	 * @return int of the number of items (nodes)
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
	 * Returns true if both HugeLists are equal.
	 * @param num2 HugeList
	 * @return Boolean. True if numbers are equal, false otherwise.
	 */
	public boolean equals(HugeList num2)
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
				if (!(tempLink1.value.equals(tempLink2.value)))
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
	 * - Prints entire value of HugeList as a String
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
	 * Resets list back to null.
	 */
	public void reset()
	{
		head = null;
	}

	/**
	 * Creates and returns a deep copy clone of the calling HugeList
	 */
	public Object clone()
	{
		return new HugeList(this);
	}
	
	/**
	 * Adds object to the front of the HugeList
	 * @param obj
	 */
	public void addToFront(Object obj)
	{
		//Creating a new object
		if (head == null)
		{
			head = new Node(obj, null, null);
		}
		else //Add an object to the left of the existing objects
		{
			Node newNode = new Node(obj, head, null);
			head.previous = newNode;
			head = newNode;
		}
	}
}
