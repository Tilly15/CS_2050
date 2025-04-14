package cs2050ClassWork;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project01 {

	public static void main(String[] args) {
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number of floors for the car vending machine: "); //get floors
		final int FLOORS = keyboard.nextInt();
		System.out.print("Enter the number of spaces for the car vending machine: "); //get spaces
		final int SPACES = keyboard.nextInt();
		//create a vending machine based on the users floor and space desires
		VendingMachine vendingMachine = new VendingMachine(FLOORS,SPACES);
		int task = 0;
		//Print menu for the user
		do {
			System.out.println("\n=== Car Vending Machine Menu ===\n"
					+ "1. Load Car Data\n"
					+ "2. Display Vending Machine\n"
					+ "3. Retrieve a Car\n"
					+ "4. Print Sorted Inventory (Price)\n"
					+ "5. Print Sorted Inventory (Year)\n"
					+ "6. Exit\n");
			System.out.print("Enter your choice: ");
			task = keyboard.nextInt();
			//now act on what the user chooses
			if (task==1) {
				System.out.print("Enter file name: ");
				String file_name = keyboard.next();
				try {
					readFile(vendingMachine,file_name);
					//using method readFile to read the file the user has entered
				}
				catch (FileNotFoundException e){
					System.out.println("Cannot load car data. File not found.");
				}
				
				
			}
			else if (task==2) {
				vendingMachine.displayInventory();
				//displayInventory method
			}
			else if (task==3) {
				System.out.print("Enter floor to retrieve car: ");
				int floor = keyboard.nextInt();
				System.out.print("Enter location to retrieve car: ");
				int space = keyboard.nextInt();
				//user gets to choose from what floor and location to retrieve car from
				vendingMachine.retrieveCar(floor,space);
			}
			else if (task==4) {
				//sort by price
				vendingMachine.insertionSortPrice();
			}
			else if (task==5) {
				//sort by year
				vendingMachine.insertionSortYear();
			}
			else {
				if(task==6) {
					//leaves and exits
				}
				else {
					System.out.println("Please enter a valid number from the list of options.");
				}
			}
		}
		while(task != 6);
		System.out.println("Exiting Program. Goodbye!");
		keyboard.close();
	}
	
	//method to read a file
	public static void readFile(VendingMachine vendingMachine, String file_name) throws FileNotFoundException {
		Scanner fileScanner = null;//open the Scanner
		try {
			
			fileScanner = new Scanner(new File(file_name));//with file name
			while (fileScanner.hasNextLine()) {
				if (!fileScanner.hasNextInt()) {
					break;
				}//just in case there are files with empty lines
				//get each data point one by one by parsing by each type
				int floor = Integer.parseInt(fileScanner.next().trim());
				int space = Integer.parseInt(fileScanner.next().trim());
				int year = Integer.parseInt(fileScanner.next().trim());
				double price = Double.parseDouble(fileScanner.next().trim());
				String make = fileScanner.next().trim();
				String model = fileScanner.next().trim();
				//create the current car object from that line of the file
				CarP car = new CarP(make, model, year, price);
				//add the newly created car to the vendingMachine
				vendingMachine.addCar(floor+1,space+1,car);
			}
		}
		
		finally {
			if (fileScanner != null)
			{
				fileScanner.close(); //close file scanner
			}
		}
		
	}
}

class CarP{ //car was already a class CarP is for "CarProject"
	private String make;
	private String model;
	private int year;
	private double price;
	//4 attributes
	
	public CarP() {
		//default constructor
	}
	
	public CarP(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		//overload constructor
	}
	
	//need getters but no setters
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
        return String.format("%s %s %d - $%.1f",
                getMake(), getModel(), getYear(), getPrice());
    }
	//added toString method to make printing each car more efficient
}

class VendingMachine{
	//note don't need floors or spaces attributes because those are inputted by the user
	private CarP [][]cars; //2D array of CarP objects
	
	
	public VendingMachine() {
		//default constructor
	}
	
	public VendingMachine(int floors, int spaces) {
		this.cars = new CarP[floors][spaces];
		//overloaded constructor that adds a car to the vending machine
	}
	
	//method to add car at a given floor and space and the object car
	public void addCar(int floor, int space, CarP car) {
		
		if (cars.length < floor) { //checks to see if there are enough floors
			System.out.println("Error: Invalid Position at Floor: "+floor+ " Space: "+ space);
			System.out.println("Cannot place Car " +car.toString());
		}
		else if (cars[0].length < space) { //checks to see if there are enough spaces
			System.out.println("Error: Invalid Position at Floor: "+floor+ " Space: "+ space);
			System.out.println("Cannot place Car " +car.toString());
		}
		//invalid position at 0
		else if (floor == 0 || space == 0) {
			System.out.println("Error: Invalid Position at Floor: "+floor+ " Space: "+ space);
			System.out.println("Cannot place Car " +car.toString());
		}
		//checks to see if the space is empty
		else if (cars[floor-1][space-1] == null) {
			//if so the car is added to the array at the given floor and space
			cars[floor-1][space-1] = car;
			//System.out.println("Car placed at: Floor: "+floor+" Space: "+space);
			//above line was just for testing
		}
		//if the space is full the car is not added
		else {
			System.out.println("Error: Slot at Floor: "+floor+ " Space: "+space+ " is already occupied.");
			System.out.println("Car "+car.toString()+ " cannot be placed.");
		}
	}
	
	public void displayInventory() {
		//displays inventory
		System.out.println("Inventory Location");
		//double for loop for 2D array
		for (int floor=0; floor<cars.length;floor++) {//loop through floors(rows)
			System.out.println("Floor "+(floor+1)+":");
			for (int space=0; space<cars[0].length;space++) {//loop thru spaces(columns)
				System.out.print("\tSpace "+(space+1));
				
				if(cars[floor][space] == null) { //checks to see if the space is empty
					System.out.print(" Empty\n");
				}
				else {
					System.out.print(": "+cars[floor][space].toString()+"\n"); //prints the car in the space
				}
			}
		}
	}
	

	
	//method added to flatten the 2D array for sorting purposes
	public CarP[] flattenArray(CarP[][]array) {
		int n = array.length*array[0].length; //1D array length
		CarP[] oneDarray = new CarP[n]; //create the 1D array
		int g = 0; //current index in 1D array
		for (int floor=0; floor<array.length;floor++) {
			for (int space=0; space<array[0].length;space++) {//loop through 2D array
				oneDarray[g] = array[floor][space];//add each to the 1D array
				g++;
			}
		}
		return oneDarray;
	}
	
	//method to remove null values from a 1D CarP array for sorting purposes
	public CarP[] removeNull(CarP[] array) {
		int null_count = 0;
		//counts the number of empty spaces (null values)
		for (int y = 0; y <array.length;y++) {
			if (array[y] == null) {
				null_count++;
			}
		}
		CarP[] nonull_array = new CarP[array.length-null_count]; //create an array of length of the full spaces
		int nonull_count = 0;
		for (int x = 0; x < array.length;x++) {
			if (array[x] != null) {
				nonull_array[nonull_count]= array[x];
				nonull_count++;
			}
		}
		return nonull_array;
		
	}
	
	//use insertion sort to sort by year
	public void insertionSortYear() {
		//uses both flatten array and remove null first
		CarP[] oneDarray = flattenArray(cars); 
	    CarP[] nonull_array = removeNull(oneDarray);
		if (nonull_array.length == 0) {
			System.out.println("Can't sort by Year. There are no cars in the vending machine.");
		}
		else {
			//now use insertion sort by year
			for (int i = 1; i < nonull_array.length; i++) {
	            CarP key = nonull_array[i];
	            int j = i - 1;
	            while (j >= 0 && nonull_array[j].getYear() > key.getYear()) {
	                nonull_array[j + 1] = nonull_array[j];
	                j--;
	            }
	            nonull_array[j + 1] = key;
	        }
			//print out the inventory based on the oldest cars first
			System.out.println("\nSorted Inventory by Year:");
			for (int z = 0;z<nonull_array.length;z++) {
				System.out.println(nonull_array[z].toString());
			}
		}
		
	}
	
	public void insertionSortPrice() {
		//uses both oneDarray and nonull_array before using insertion sort
		CarP[] oneDarray = flattenArray(cars); 
	    CarP[] nonull_array = removeNull(oneDarray);
		//now use insertion sort by year
	    if (nonull_array.length == 0) { //checks if there are any cars in the vending machine
	    	System.out.println("Can't sort by Price. There are no cars in the vending machine.");
	    }
	    else {
	    	//insertion sort
	    	for (int i = 1; i < nonull_array.length; i++) {
	            CarP key = nonull_array[i];
	            int j = i - 1;
	            while (j >= 0 && nonull_array[j].getPrice() > key.getPrice()) {
	                nonull_array[j + 1] = nonull_array[j];
	                j--;
	            }
	            nonull_array[j + 1] = key;
	        }
			//print out the inventory based on the cheapest cars first
			System.out.println("\nSorted Inventory by Price:");
			for (int z = 0;z<nonull_array.length;z++) {
				System.out.println(nonull_array[z].toString());
			}
	    }
	}

	//retrieve a car based on the user's input
	public void retrieveCar(int floor, int space) {
		if (floor == 0) {
			System.out.println("Error: There is no Floor "+floor);
		}
		else if (space == 0){
			System.out.println("Error: There is no Space "+space+" on floor "+floor);
		}
		else {
			if (floor>cars.length) { //checks to see if there are enough floors
				System.out.println("The vending machine only has "+cars.length+" floors.");
			}
			else if(space>cars[0].length) { //checks to see if there are enough spaces
				System.out.println("Floor "+floor+" only has "+cars[0].length+" spaces.");
			}
			else {
				if (cars[floor-1][space-1] != null) { //checks to see if that space is full then retrieves car
					System.out.println("Car retrieved from Floor "+floor+" Location "+space+": "+cars[floor-1][space-1].toString());
				}
				else { //if there is no car at the location
					System.out.println("No car located at Floor "+floor+" Location "+space);
				}
			}
		}

		
	}
}
