

/**
 * Add comments
 */

public class TestShapesInheritance
{

	public static void main(String[] args) {
		CircleFromSimpleGeometricShape circle = 
				new CircleFromSimpleGeometricShape(1);
		System.out.println("circle toString: " + circle.toString());
		System.out.println("The color is " + circle.getColor());
		System.out.printf("The radius is  %.2f \n", circle.getRadius());
		System.out.printf("The area is  %.2f \n", circle.getArea());
		System.out.printf("The diameter is  %.2f \n", circle.getDiameter());
		RectangleFromSimpleGeometricShape rectangle1 = new RectangleFromSimpleGeometricShape();
		System.out.println(rectangle1.toString());
		RectangleFromSimpleGeometricShape rectangle2 = new RectangleFromSimpleGeometricShape(2,3);
		System.out.printf("The height is %.2f \n", + rectangle2.getHeight());
		RectangleFromSimpleGeometricShape rectangle3 = new RectangleFromSimpleGeometricShape(4,5,"red",true);
		System.out.printf("The area of rectangle3 is %.2f \n",rectangle3.getArea());
		
	}//end main

}//end TestShapeInheritance Class



/**
 * Simple Geometric Shape Superclass
 */
class SimpleGeometricShape {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;


	/**
	 * Construct a default geometric object
	*/	public SimpleGeometricShape() {
		dateCreated = new java.util.Date();
	}


	/**
	 * Construct a geometric object with the specified color and filled 
	 * @param String color
	 * @param boolean filled
	 */
	public SimpleGeometricShape(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/**
	 * get current color
	 * @return String color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set new color
	 * @param String color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Since filled is boolean, 
	 *    its get method is named isFilled
	 * get current filled value 
	 * @return boolean filled 
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * Set a new filled
	 * @param boolean filled
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * Get dateCreated
	 * @return dateCreated
	 */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		System.out.println("In SimpleGeometricShape toString method ");
		return "created on" +dateCreated + "\ncolor:" + color + "and filled:" +filled;
	}

}//end SimpleGeometricShape class


/**
 * Add comments
 */
class CircleFromSimpleGeometricShape 
extends SimpleGeometricShape {
	private double radius;

	/**
	 * Construct a default circle object
	 */
	public CircleFromSimpleGeometricShape() {
		
	}

	/**
	 * 
	 * @param radius
	 */
	public CircleFromSimpleGeometricShape(double radius) {
		this.radius = radius;
	}

	public CircleFromSimpleGeometricShape(double radius, 
			String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}


	/**
	 * Get radius
	 * @return double radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 *  Set a new radius
	 * @param double radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Get Area 
	 * @return double 
	 */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/**
	 * Get Diameter 
	 * @return double 
	 */
	public double getDiameter() {
		return 2 * radius;
	}

	/**
	 * Get Perimeter 
	 * @return double 
	 */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

}//end CircleFromSimpleGeometricShape class

class RectangleFromSimpleGeometricShape extends SimpleGeometricShape{
	private double width;
	private double height;
	
	public RectangleFromSimpleGeometricShape() {
		//default  no params
	}
	
	public RectangleFromSimpleGeometricShape(double width, double height) {
		this.width = width;
		this.height = height;
		//method overloading height and width as params
	}
	
	public RectangleFromSimpleGeometricShape(double width, double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
		//method overloading height, width, color, filled as params
	}
	
	/**
	 * Get width
	 * @return 
	 * @return double width
	 */
	public double getWidth(){
		return width;
	}
	
	/**
	 *  Set a new width
	 * @param double width
	 * @return 
	 */
	public void setWidth(double width){
		this.width = width;
	}
	
	/**
	 * Get height
	 * @return 
	 * @return double height
	 */
	public double getHeight(){
		return height;
	}
	
	/**
	 *  Set a new width
	 * @param double width
	 * @return 
	 */
	public void setHeight(double height){
		this.height = height;
	}
	
	/**
	 * Get Area 
	 * @return double 
	 */
	public double getArea() {
		return height * width;
	}
	
	/**
	 * Get Perimeter
	 * @return double
	 */
	public double getPerimeter() {
		return 2*height+2*width;
	}

	//create variable to count number of rectangles created
	public static int NumberOfRectangles;
	
	//method to count number of rectangles created
	
	


	
	
	
}




