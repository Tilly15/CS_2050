package cs2050ClassWork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project01 {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		CarP car = new BasicCar("Ford","Escape",2016,10000,"1-1","Basic");
		CarP car2 = new PremiumCar("Honda", "CRV", 2023, 25000, "2-2", "Premium");
		CarP car3 = new BasicCar("Subaru", "Outback", 2010, 8000, "3-1", "Basic");
		CarP car4 = new PremiumCar("Toyota", "4Runner", 2024, 40000, "3-2", "Premium");
		vendingMachine.addCar(car, 4, 4);
		vendingMachine.addCar(car2,4,4);
		vendingMachine.addCar(car3, 4, 4);
		vendingMachine.addCar(car4, 4, 4);
		vendingMachine.addCarToWash(3, 2);
		vendingMachine.addCarToWash(3, 1);
		vendingMachine.addCarToWash(2, 2);
		vendingMachine.washCars();
		
	//main method
		/**
		 * Asks the user for the number of floors and spaces
		 * in the vending machine and creates the vending machine
		 * Then gives the user a menu of 10 choices that they
		 * can choose from to use the different functions
		 * of the Car Vending Machine.
		 * Then, based on the user's choice a different method is called
		 * to fulfill the request.
		 */
		Scanner keyboard = new Scanner(System.in);
		VendingMachine vendingMachine2 = new VendingMachine();
		System.out.print("Enter the number of floors for the car vending machine: "); //get floors
		final int FLOORS = keyboard.nextInt();
		System.out.print("Enter the number of spaces for the car vending machine: "); //get spaces
		final int SPACES = keyboard.nextInt();
		int task = 0;
		while (task != 10) {
			//menu of choices
			System.out.println("\n=== Car Vending Machine Menu ===\n"
						+ "1. Load Car Data From File\n"
						+ "2. Display Vending Machine\n"
						+ "3. Retrieve a Car by Location (Floor & Space)\n"
						+ "4. Print Sorted Inventory (Price)\n"
						+ "5. Print Sorted Inventory (Year)\n"
						+ "6. Search for Cars (Manufacturer & Type)\r\n"
						+ "7. Add Car to Wash Queue\r\n"
						+ "8. Process Car Wash Queue\r\n"
						+ "9. Sell a Car\r\n"
						+ "10. Exit\n");
			System.out.print("Enter your choice: ");
	        task = keyboard.nextInt();
	                //keyboard.nextLine(); // Consume newline
	            
	       switch (task) {
	            case 1:
	            	System.out.print("Enter file name: ");
					String file_name = keyboard.next();
					try {
						readFile(vendingMachine2,file_name, FLOORS, SPACES);
					}
					catch (FileNotFoundException e){
						System.out.println("Cannot load car data. File not found.");
					}
                    break;
                case 2:
                    vendingMachine2.displayInventory();
                    break;
                case 3:
                	System.out.print("Enter floor: ");
                	int floor = keyboard.nextInt();
                	System.out.print("Enter space: ");
                	int space = keyboard.nextInt();
                	vendingMachine2.retrieveCar(floor, space);
                	break;
                case 4:
                	vendingMachine2.sortByPrice();
                	break;
                case 5:
                	vendingMachine2.sortByYear();
                	break;
                case 6:
                	System.out.print("Enter manufacturer: ");
                	String model = keyboard.next();
                	System.out.print("Enter car type (Basic/Premium): ");
                	String type = keyboard.next();
                	vendingMachine2.findCars(model, type);
                	break;
                case 7:
                	System.out.print("Enter floor: ");
                	int floor2 = keyboard.nextInt();
                	System.out.print("Enter space: ");
                	int space2 = keyboard.nextInt();
                	vendingMachine2.addCarToWash(floor2, space2);
                	break;
                case 8:
                	vendingMachine2.washCars();
                	break;
                case 9:
                	System.out.print("Enter the floor of the car to sell: ");
                	int floor3 = keyboard.nextInt();
                	System.out.print("Enter the space of the car to sell: ");
                	int space3 = keyboard.nextInt();
                	vendingMachine2.sellCar(floor3, space3);
                	break;
                case 10:
                	System.out.println("Exiting Program. Goodbye!");
                	break;
	            }
		}
		keyboard.close(); //close keyboard
	}
	
	/**
	 * Method that reads the file information to create a
	 * car object for each line of the file
	 * by creating the necessary parameters:
	 * position, year, price, make, model, and model.
	 *  
	 */
	public static void readFile(VendingMachine vendingMachine, String file_name, int FLOORS, int SPACES) throws FileNotFoundException {
		Scanner fileScanner = null;//open the Scanner
		try {
			
			fileScanner = new Scanner(new File(file_name));
			while (fileScanner.hasNextLine()) {
				if (!fileScanner.hasNext()) {
					break;
				}
				String type = fileScanner.next().trim();
				int floor = Integer.parseInt(fileScanner.next().trim());
				int space = Integer.parseInt(fileScanner.next().trim());
				String position = floor+"-"+space;
				int year = Integer.parseInt(fileScanner.next().trim());
				double price = Double.parseDouble(fileScanner.next().trim());
				String make = fileScanner.next().trim();
				String model = fileScanner.next().trim();
				if (type.equalsIgnoreCase("B")) {
					type = "Basic";
					CarP car = new BasicCar(make, model, year, price, position, type);
					vendingMachine.addCar(car, FLOORS, SPACES);
				}
				else if (type.equalsIgnoreCase("P")) {
					type = "Premium";
					CarP car = new PremiumCar(make, model, year, price, position, type);
					vendingMachine.addCar(car, FLOORS, SPACES);
				}
				else {
					System.out.println("Not a valid type.");
				}
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

/**
 * An abstract class with one abstract method
 * toString. All the other methods are concrete 
 * methods (getters).
 */

abstract class CarP{ //car was already a class CarP is for "CarProject"
	private String make;
	private String model;
	private int year;
	private double price;
	private String position;
	private String type;
	//6 attributes
	
	public CarP() {
		//default constructor
	}
	
	public CarP(String make, String model, int year, double price, String position, String type) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.position = position;
		this.type = type;
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
	
	public String getPosition() {
		return position;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public abstract String toString();
	//added toString method to make printing each car more efficient
}

/**
 * BasicCar extends the abstract method CarP, overriding the
 * abstract method toString. The constructor of the super 
 * class is also called.
 */

class BasicCar extends CarP{
	BasicCar(String make, String model, int year, double price, String position, String type){
		super(make, model, year, price, position, type);
	}
	@Override
	public String toString() {
		String[] position = getPosition().split("-");
		int floor = Integer.parseInt(position[0]);
		int space = Integer.parseInt(position[1]);
		return String.format("Basic Car: %s %s %d - $%.1f (Floor: "+floor+", Space: "+space+")",
	            getMake(), getModel(), getYear(), getPrice());
	}
}

/**
 * Premium Car extends the abstract method CarP, overriding the
 * abstract method toString. The constructor of the super 
 * class is also called.
 */

class PremiumCar extends CarP{
	PremiumCar(String make, String model, int year, double price, String position, String type){
		super(make, model, year, price, position, type);
	}
	@Override
	public String toString() {
		String[] position = getPosition().split("-");
		int floor = Integer.parseInt(position[0]);
		int space = Integer.parseInt(position[1]);
		return String.format("Premium Car: %s %s %d - $%.1f (Floor: "+floor+", Space: "+space+")",
	            getMake(), getModel(), getYear(), getPrice());
	}
}

/**
 * The class VendingMachine contains the LinkedList,
 * the HashMap, and the CarWashQueue.
 */

class VendingMachine{
	private LinkedList<CarP> cars;
	private Map<String, CarP> carsMap;
	private Queue<CarP> carWashQueue;
	
	public VendingMachine() {
		this.cars = new LinkedList<CarP>();
		this.carsMap = new HashMap<>();
		this.carWashQueue = new LinkedList<CarP>();
		//overloaded constructor that adds a car to the vending machine
	}
	
	/**
	 * This method adds the car to the HashMap and the
	 * LinkedList as long as the vending machine is big
	 * enough and there isn't already a car in that position
	 */
	public void addCar(CarP car, int FLOORS, int SPACES) {
		String[] position = car.getPosition().split("-");
		int floor = Integer.parseInt(position[0]);
		int space = Integer.parseInt(position[1]);
		if (floor > FLOORS) {
			System.out.println("Error: Invalid Position at Floor "+floor+" Space "+space);
			System.out.println("Cannot place Car: "+car.toString());
		}
		else if (space > SPACES) {
			System.out.println("Error: Invalid Position at Floor "+floor+" Space "+space);
			System.out.println("Cannot place Car: "+car.toString());
		}
		else if (carsMap.containsKey(car.getPosition())) {
			//Can't add car position full
			
			System.out.println("Error: Slot at Floor: "+floor+ " Space: " +space+ " is already occupied.");
			System.out.println("Car "+car.toString()+ " cannot be placed.");
		}
		else {
			
			cars.add(car); //add to LinkedList
			carsMap.put(car.getPosition(), car); //key = position, value = Car
			//added to HashMap
		}

		//need to add if else condition to check if the spot is full
		//for each loop, iterate through each hash map to see if the spot is full
	}
	
	/**
	 * This method displays the inventory of all the cars in
	 * the vending machine.
	 */
	public void displayInventory() {
		if (cars.isEmpty()) {
			System.out.println("No cars in the Vending Machine.");
		}
		for (CarP car : cars) {
			System.out.println(car.toString());
		}
	}

	/**
	 * This method retrieves a car from a given position
	 * in the vending machine by searching the HashMap for
	 * the given position.
	 */
	public void retrieveCar(int floor, int space) {
		String position = floor + "-" + space;
		if (carsMap.containsKey(position)) {
			CarP car = carsMap.get(position);
			System.out.println("Car retrieved: "+car.toString());
		}
		else {
			System.out.println("Car not found at this location.");
		}
	}
	
	/**
	 * These methods sort all the cars in the vending machine
	 * by converting the LinkedList into an ArrayList to use
	 * collection sort to sort by year or price.
	 */
	public void sortByYear() {
		List<CarP> carsArray = new ArrayList<>(cars); //always convert your linked list to an array list for sorting!
		if (!carsArray.isEmpty()) {
			System.out.println("Sorted Inventory by Year:");
			carsArray.sort(Comparator.comparing(CarP::getYear));
			for (CarP currentcar : carsArray)
			{
				System.out.println(currentcar.toString());
			}
		}
		else {
			System.out.println("No cars in the Vending Machine.");
		}
	}
	
	public void sortByPrice() {
		List<CarP> carsArray = new ArrayList<>(cars); //always convert your linked list to an array list for sorting!
		if (!carsArray.isEmpty()) {
			System.out.println("Sorted Inventory by Price:");
			carsArray.sort(Comparator.comparing(CarP::getPrice));
			for (CarP currentcar : carsArray)
			{
				System.out.println(currentcar.toString());
			}
		}
		else {
			System.out.println("No cars in the Vending Machine.");
		}
	}
	
	/**
	 * This method searches for cars based on the manufacturer
	 * and the type of the car by converting the LinkedList into
	 * an ArrayList. It then sorts the results by the manufacturer.
	 */
	public void findCars(String make, String type) {
	    List<CarP> results = new ArrayList<>();
	    for (CarP currentCar : cars) {
	        if (currentCar.getMake().equalsIgnoreCase(make) && currentCar.getType().equalsIgnoreCase(type))  {
	            results.add(currentCar);
	        }
	    }
	    results.sort(Comparator.comparing(CarP::getMake));
	    for (CarP currentCar : results)
	    {
	    	System.out.println(currentCar.toString());
	    }
	    if (results.isEmpty()) {
	    	System.out.println("No "+type+" cars manufactured by "+make);
	    }
	}
	
	/**
	 * This method takes the position of a car and then searches to
	 * see if there is a car in that position in the Vending Machine.
	 * If there is the car is then "sold" (the car is removed from the
	 * Vending Machine).
	 */
	public void sellCar(int floor, int space) {
		String position = floor + "-" + space;
		if (carsMap.containsKey(position)) {
			CarP car = carsMap.get(position);
			cars.remove(car);
			carsMap.remove(position, car);
			System.out.println("Car Sold: "+car.toString());
		}
		else {
			System.out.println("No car found at Floor "+floor+", Space "+space);
		}
	}
	
	/**
	 * This method adds the car at the given position in the Vending
	 * Machine (if there is one) and adds it to the Car Wash Queue to
	 * be washed.
	 */
	public void addCarToWash(int floor, int space) {
		String position = floor + "-" + space;
		if (carsMap.containsKey(position)) {
			CarP car = carsMap.get(position);
			System.out.println("Car retrieved: "+car.toString());
			carWashQueue.add(car);
			System.out.println("Car added to wash queue.");
		}
		else {
			System.out.println("No car located at Floor "+floor+" Location "+space);
		}
	}
	
	/**
	 * This method takes the cars from the washing machine queue and
	 * then empties the queue by washing the cars in a first out
	 * first in order.
	 */
	public void washCars() {
		//need if else if there are no cars in queue
		if (carWashQueue.isEmpty()) {
			System.out.println("No cars in the wash queue.");
		}
		
		else {
			while (!carWashQueue.isEmpty()) {
	            CarP car = carWashQueue.poll();  // removes and returns the head first in first out
	            System.out.println("Washing: " + car.toString());
			}
		}
	}
}
