package cs2050ClassWork;

import java.util.ArrayList;

public class Lecture15ClassLab {

	public static void main(String[] args) {
		Birds bird1 = new Penguin("penguin","Bobo",15);
		Birds bird2 = new Duck("duck","Dewey",4);
		Birds bird3 = new Sootytern("sootytern","Cruiser",0);
		Birds bird4 = new Ostrich("ostrich","Oscar",0);
		Birds bird5 = new Penguin("penguin","Oreo",17);
		Birds bird6 = new Ostrich("ostrich","Max",0);
		ArrayList<Birds> birds = new ArrayList<>();
		birds.add(bird1);
		birds.add(bird2);
		birds.add(bird3);
		birds.add(bird4);
		birds.add(bird5);
		birds.add(bird6);
		displayAllBirds(birds);
		findSwimmers(birds);
		
	}
	
	public static void displayAllBirds(ArrayList<Birds> birds) {
		System.out.println("Birds and Thier Abilites");
		System.out.println("------------------------");
		for (Birds bird : birds) { //for each loop
			System.out.println(bird.getName()+ " is a "+ bird.getType());
			bird.printInterestingFact();
		}
	}
	
	public static void findSwimmers(ArrayList<Birds> birds) {
		System.out.println();
		System.out.println("BIRDS THAT CAN SWIM");
		System.out.println("----------------------------");
		System.out.println("Bird    Type    Swim Speed");
		System.out.println("----------------------------");
		for (Birds bird : birds) { //for each loop
			if (bird.getSwimSpeed()>0 ) {
				System.out.println(bird.getName()+ "   "+bird.getType()+"   "+bird.getSwimSpeed());
			}
		}
	}
	
	
}

abstract class Birds {
	private String name;
	private int swimSpeed;
	private String type;
	
	abstract void printInterestingFact();
	
	public String getName(){
		return this.name;
	}
	
	public int getSwimSpeed(){
		return this.swimSpeed;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Birds(String type, String name, int swimSpeed) {
		this.type = type;
		this.name = name;
		this.swimSpeed = swimSpeed;
	}
}

interface Swimmers{
	int Swim();
}

class Penguin extends Birds implements Swimmers{

	public Penguin(String type, String name, int swimSpeed) {
		super(type, name, swimSpeed);
		
	}

	@Override
	void printInterestingFact() {
		
		System.out.println("I can't fly, but I'm the fastest swimmer and deepest diver.");
	}

	@Override
	public int Swim() {
		
		return getSwimSpeed();
	}
	
}

class Duck extends Birds implements Swimmers{

	public Duck(String type, String name, int swimSpeed) {
		super(type, name, swimSpeed);
		// TODO Auto-generated constructor stub
	}

	@Override
	void printInterestingFact() {
		System.out.println("My highest documented flight was at 21,000 feet!");
	}

	@Override
	public int Swim() {
		return getSwimSpeed();
	}
	
}

class Ostrich extends Birds{

	public Ostrich(String type, String name, int swimSpeed) {
		super(type, name, swimSpeed);
		// TODO Auto-generated constructor stub
	}

	@Override
	void printInterestingFact() {
		System.out.println("Who needs flying when you're the biggest bird on earth!");

	}
	
}

class Sootytern extends Birds{

	public Sootytern(String type, String name, int swimSpeed) {
		super(type, name, swimSpeed);
		// TODO Auto-generated constructor stub
	}

	@Override
	void printInterestingFact() {
		System.out.println("I spend most of my life at sea but can't swim!");

	}
	
}

