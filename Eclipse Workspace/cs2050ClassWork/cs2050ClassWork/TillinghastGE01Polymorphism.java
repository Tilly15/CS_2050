package cs2050ClassWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TillinghastGE01Polymorphism {

	public static void main(String[] args) throws FileNotFoundException {
		//open test file animals.txt
		final String animal_file = "Animals.txt";
		animalSetUp(animal_file);
		
		
	}

	/**
	 * this function reads the file and initializes the polymorphic array of animals
	 * 
	 * 
	 */
	 
	public static void animalSetUp(String filename) throws FileNotFoundException{
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(new File(filename));
			int totalAnimals = Integer.parseInt(fileScanner.next().trim());
			Animal[] animals = new Animal[totalAnimals];
			while (fileScanner.hasNextLine())
			{
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
					location = location +" "+ location2;
					animals[i] = new Bear(name, food, weight, sleep, location);
				
				//below code doesn't work
				if (type.equals("Bear")) {
					animals[i] = new Bear(name, food, weight, sleep, location);
				}
				
				if (type == "Elephant") {
					animals[i] = new Elephant(name, food, weight, sleep, location);
				}
				if (type == "Monkey") {
					animals[i] = new Monkey(name, food, weight, sleep, location);
				}
				if (type == "Sloth") {
					animals[i] = new Bear(name, food, weight, sleep, location);
				}
				
				}
				
			}//end of while
			//now we have a 7 member polymorphic array
			for (int i=0; i<totalAnimals;i++) {
				if (animals[0]instanceof Bear) {
					System.out.println("Animal["+i+"] is a Bear");
				}
				else if (animals[0]instanceof Elephant) {
					System.out.println("Animal[\"+i+\"] is an Elephant");
				}
				else if (animals[0]instanceof Monkey) {
					System.out.println("Animal[\"+i+\"] is a Monkey");
				}
				else if (animals[0]instanceof Sloth) {
					System.out.println("Animal[\"+i+\"] is a Sloth");
				}
				System.out.println(animals[i].name().toString());
			}
		}
		finally {
			if (fileScanner != null)
			{
				fileScanner.close();
			}

			
		}

	}




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
		System.out.println("Animal is sleeping");
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
		
	}
	
	//override eat, sleep, and swim for Bear
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping " + getSleep() +" hours");
		
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
}

class Elephant extends Animal{
	
	public Elephant() {
		
	}
	
	public Elephant(String name, String food, int weight,
			int sleep, String location) {
		
	}

	//override sleep for Elephant
		@Override
		public void sleep() {
			System.out.println("Elephant is sleeping " + getSleep() +" hours");
		}
}

class Monkey extends Animal{
	
	public Monkey() {
		
	}
	
	public Monkey(String name, String food, int weight,
			int sleep, String location) {
		
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

}


class Sloth extends Animal{
	
	public Sloth() {
		
	}
	
	public Sloth(String name, String food, int weight,
			int sleep, String location) {
	}
	
}

