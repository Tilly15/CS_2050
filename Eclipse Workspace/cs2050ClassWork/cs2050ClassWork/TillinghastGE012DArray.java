package cs2050ClassWork;

public class TillinghastGE012DArray {

	public static void main(String[] args) {
		
		final int ROWS = 2; // number of rows in cars 2d array
		final int COLUMNS = 3; //number of columns is cars 2d array
		CarA[][] cars = new CarA[ROWS][COLUMNS]; //2D array of Car objects
		cars[0][0] = new CarA("Ford");
		cars[0][1] = new CarA("Dodge");
		cars[0][2] = new CarA("Toyota");
		cars[1][0] = new CarA("Hyundai");
		cars[1][1] = new CarA("Chevrolet");
		cars[1][2] = new CarA("Subaru");

		
		//loop to print out array labeling column and row number
		for(int row = 0; row < cars.length; row++) {
			//create a top row as a heading for the columns
			if(row == 0) {
				System.out.print("      ");
				for(int col = 0; col < cars[0].length; col++) {
					int tempcol = col + 1; //index starts at 0, want to start at 1
					System.out.print("Col "+tempcol+" "); 
				}
			}
			System.out.println();
			int temprow = row + 1; //again want to start at row 1
			System.out.print("Row "+temprow+" ");
			
			for(int col = 0; col < cars[0].length; col++) {
				
				cars[row][col].printMake(); //print out each entry in the array
			}
			
		}
		
		
					
	}
}
	
	class CarA{
		private String make;

		public CarA() { 
	   this.make = "Unknown"; 
	}
		
	public CarA(String make) {
	 	   this.make = make;
	}

	public void printMake() {
	   System.out.print(this.make + " ");
	}
	
	} // Car
	

		
