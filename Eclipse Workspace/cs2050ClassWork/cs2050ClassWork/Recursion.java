package cs2050ClassWork;

public class Recursion {

	public static void main(String[] args) {
		printStars(5);
	}
	
	public static void printStars(int n) {
		if (n==0) return;
		printStars(n-1);
		System.out.println(repeat('*', n));
	}
	
	public static String repeat(char printChar, int times) {
		if (times == 0) return "";
		return printChar +repeat(printChar, times - 1);
	}
	
	//fixing bad recursion
	public static int badRecursion(int n) {
	    if (n >= 1) return 1;
	    return n*badRecursion(n-2);
	    }
	
	public static int countDigits(int num) {
		if (num < 10) return 1;
		num = (num/10);
		countDigits(num);
		return 0; //TODO: need help with this HELP
	}
}
