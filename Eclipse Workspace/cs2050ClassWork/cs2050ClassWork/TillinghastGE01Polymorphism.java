package cs2050ClassWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TillinghastGE01Polymorphism {

	public static void main(String[] args) throws FileNotFoundException {
		//open test file animals.txt
		final String animal_file = "Animals.txt"; //file to read in
		Scanner fileScanner = null; //open the Scanner
		try
		{
			fileScanner = new Scanner(new File(animal_file)); //initiate the scanner to scan the file
			int totalAnimals = Integer.parseInt(fileScanner.next().trim());// find the total number of elements in array
			Animal[] animals = new Animal[totalAnimals]; //create the polymorphic array
				//for loop for each instance
				for (int i = 0; i < totalAnimals; i++) {
					String type = fileScanner.next().trim();
					String name = fileScanner.next().trim();
					String food = fileScanner.next().trim();
					int weight = Integer.parseInt(fileScanner.next().trim());
					int sleep = Integer.parseInt(fileScanner.next().trim());
					//This is not the best way to do this and would cause an error with a location that doesn't have 2 words
					//But I couldn't find a better way without using code I am not familiar with
					String location = fileScanner.next().trim();
					String location2 = fileScanner.next().trim();
					location = location + " " + location2;
					
				
				//initiate each instance
				if (type.equals("Bear")) {
					animals[i] = new Bear(name, food, weight, sleep, location);
				}
				
				if (type.equals("Elephant")) {
					animals[i] = new Elephant(name, food, weight, sleep, location);
				}
				if (type.equals("Monkey")) {
					animals[i] = new Monkey(name, food, weight, sleep, location);
				}
				if (type.equals("Sloth")) {
					animals[i] = new Sloth(name, food, weight, sleep, location);
				}
				
				}
			
			//now we have a 7 member polymorphic array
				for (int i=0; i<totalAnimals;i++) {
					if (i>0) {
						System.out.println();
					}
					System.out.print("Animal [" + i + "] is a ");
					if (animals[i]instanceof Bear) {
						System.out.print("Bear\nBear: ");
					}
					else if (animals[i]instanceof Elephant) {
						System.out.print("Elephant\nElephant: ");
					}
					else if (animals[i]instanceof Monkey) {
						System.out.print("Monkey\nMonkey ");
					}
					else if (animals[i]instanceof Sloth) {
						System.out.print("Sloth\nSloth: ");
					}
					
					//I'm not sure
					System.out.println(animals[i].toString());//call on overriden toString() method
					animals[i].eat();
					animals[i].sleep();
					animals[i].swim();

					
				}
		}
		catch (FileNotFoundException e)//catch the error if the file doesn't exist
		{
			System.out.println("Error: Can't upload animal information\n" + e.getMessage());
		}
		finally {
			if (fileScanner != null)
			{
				//close the scanner
				fileScanner.close();
			}
		}

	}
	//end of main
	 
}

class Animal{
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
	//constructor with no params
	public Animal() {
		
	}
	
	//constructor for super class Animal
	public Animal(String name, String food, int weight,
			int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	
	//getters
	public String getName() {
		return name;
	}
	public String getFood() {
		return food;
	}
	public double getWeight() {
		return weight;
	}
	public double getSleep() {
		return sleep;
	}
	public String getLocation() {
		return location;
	}
	
	//3 more public methods

	public void eat() {
		System.out.println("Animal is eating");
	}
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}
	public void swim() {
		System.out.println("Animal is swimming");
	}
	
}

class Bear extends Animal{
	
	public Bear() {
		
	}
	
	public Bear(String name, String food, int weight,
			int sleep, String location) {
		super (name, food, weight, sleep, location);//explicit call to superclass
	}
	
	//override eat, sleep, and swim for Bear
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	@Override
	public void sleep() {
	    System.out.println(String.format("Bear is sleeping %.0f hours", getSleep()));
	    //format to 0 decimal places
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
	
	@Override
	public String toString() {
        return String.format("Name: %s - Weighs: %d lbs - Sleeps: %s hours - Location:  %s",
                getName(), (int) getWeight(), String.format("%.0f", getSleep()), getLocation());
    }
	
	

}

class Elephant extends Animal{
	
	public Elephant() {
		
	}
	
	public Elephant(String name, String food, int weight,
			int sleep, String location) {
		super (name, food, weight, sleep, location);//explicit
	}

	//override sleep for Elephant
		@Override
		public void sleep() {
		    System.out.println(String.format("Elephant is sleeping %.0f hours", getSleep()));
		    //format to 0 decimal places
		}
		
		@Override
		public String toString() {
	        return String.format("Name: %s - Weighs: %d lbs - Sleeps: %s hours - Location:  %s",
	                getName(), (int) getWeight(), String.format("%.0f", getSleep()), getLocation());
	    }
}

class Monkey extends Animal{
	
	public Monkey() {
		
	}
	
	public Monkey(String name, String food, int weight,
			int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	//override eat and swim for Monkey
	@Override
	public void eat() {
		System.out.println("Monkey is eating " + getFood());
	}
	
	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}
	
	@Override
	public String toString() {
        return String.format("Name: %s - Weighs: %d lbs - Sleeps: %s hours - Location:  %s",
                getName(), (int) getWeight(), String.format("%.0f", getSleep()), getLocation());
    }

}


class Sloth extends Animal{
	
	public Sloth() {
		
	}
	
	public Sloth(String name, String food, int weight,
			int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	
	@Override
	public String toString() {
        return String.format("Name: %s - Weighs: %d lbs - Sleeps: %s hours - Location:  %s",
                getName(), (int) getWeight(), String.format("%.0f", getSleep()), getLocation());
    }
	
}

