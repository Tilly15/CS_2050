package cs2050ClassWork;

public class TillinghastGE01Polymorphism {

	public static void main(String[] args) {
		Animal animal = new Animal("Bill","a",4,5,"b");
		animal.eat();

	}

}

class Animal{
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
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


/**
 * 

class Bear extends Animal{
	
}

class Elephant extends Animal{
	
}

class Monkey extends Animal{
	
}

class Sloth extends Animal{
	
}
**/