/**
 * Shape.java
 * 
 * Lab 7 due 05/27/2014
 * 
 * @author Stefano Prezioso
 * @version 05/27/2014
 *
 */
@SuppressWarnings("rawtypes")
public interface Shape extends Cloneable, Comparable {
	
	public abstract double area();
	public abstract double perimeter();
	final public double PI = 3.14159;
	public abstract int compareTo(Object obj);
	
}
