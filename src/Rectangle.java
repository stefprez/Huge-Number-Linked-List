/**
 * Rectangle.java
 * 
 * Lab 7 due 05/27/2014
 * 
 * @author Stefano Prezioso
 * @version 05/27/2014
 *
 */
public class Rectangle implements Shape {
	private int length;
	private int width;
	
	public Rectangle()
	{
		this.length = 0;
		this.width = 0;
	}
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	//Copy Constructor
	public Rectangle(Rectangle r)
	{
		this.length = r.length;
		this.width = r.width;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		
		return (this.length * this.width);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return ((2 * this.length) + (2 * this.width));
	}
	
	public String toString()
	{
		return "Shape: Rectangle" + 
				"\nLength: " + this.length + 
				"\nWidth: " + this.width + 
				"\nPerimeter: " + this.perimeter() +
				"\nArea: " + this.area() + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rectangle other = (Rectangle) obj;
		if (length != other.length) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}
	
	public int compareTo(Object obj) {
		Rectangle rec = (Rectangle)obj;
		if (this.area() > rec.area())
			return 1;
		if (this.area() == rec.area())
			return 0;
		if (this.area() < rec.area())
			return -1;
		return -10;
	}
	
	public Object clone()
	{
		return new Rectangle(this);
	}
	
}
