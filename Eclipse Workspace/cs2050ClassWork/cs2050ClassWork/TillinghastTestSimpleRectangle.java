package cs2050ClassWork;

public class TillinghastTestSimpleRectangle {

	public static void main(String[] args) {
		// main method
		//rectangle1 with default constructor
		SimpleRectangle rectangle1 = new SimpleRectangle();
		//rectangle2 with length and width 1
		SimpleRectangle rectangle2 = new SimpleRectangle(1,1);
		//rectangle3 with length 1 and width 0
		SimpleRectangle rectangle3 = new SimpleRectangle(1,0);
		
		//area and perimeter of rectangle1
		System.out.printf("The area of rectangle1 is  %.2f \n", rectangle1.getArea());
		System.out.printf("The perimeter of rectangle1 is  %.2f \n", rectangle1.getPerimeter());
		//area and perimeter of rectangle2
		System.out.printf("The area of rectangle2 is  %.2f \n", rectangle2.getArea());
		System.out.printf("The perimeter of rectangle2 is  %.2f \n", rectangle2.getPerimeter());
		//area and perimeter of rectangle3
		System.out.printf("The area of rectangle3 is  %.2f \n", rectangle3.getArea());
		System.out.printf("The perimeter of rectangle3 is  %.2f \n", rectangle3.getPerimeter());

		
	}
}
	
	//class Simple Rectangle
	class SimpleRectangle{
		private double length;
		private double width;
		
		//constructor with no params
		public SimpleRectangle() {
			
		}
		
		//constructor with newLength and newWidth params
		public SimpleRectangle(double NewLength, double NewWidth) {
			this.length = NewLength;
			this.width = NewWidth;
		}
		
		//method to get rectangle area
		public double getArea() {
			return length * width;
		}
		
		//method to get rectangle perimeter
		public double getPerimeter() {
			return length * 2 + width * 2;
			
		}
		
		//method to set rectangle length
		public void setLength(double NewLength) {
			this.length = NewLength;
		}
		
		//method to set rectangle width
		public void setWidth(double NewWidth) {
			this.width = NewWidth;
		}
		
	}
