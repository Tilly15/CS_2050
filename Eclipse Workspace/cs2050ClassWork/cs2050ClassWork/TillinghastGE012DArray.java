package cs2050ClassWork;

public class TillinghastGE012DArray {

	public TillinghastGE012DArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int ROWS = 2; // number of rows in cars 2d array
		final int COLUMNS = 3; //number of columns is cars 2d array
		String[][] cars = new String[ROWS][COLUMNS];
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
				
				System.out.print(cars[row][col]+" "); //print out each entry in the array
			}
			
		}
		
		
					
	}
	
	class Car{
		private String make;

		public Car() { 
	   this.make = "Unknown"; 
	}
		
	public Car(String make) {
	 	   this.make = make;
	}

	public void printMake() {
	   System.out.print(this.make + " ");
	}
	
	} // Car
	

		
	}
