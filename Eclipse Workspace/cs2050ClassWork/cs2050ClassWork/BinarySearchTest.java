package cs2050ClassWork;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] array = {2,3,4,5,5,5};
		System.out.println(binarySearch(array,5));
	}
	public static int binarySearch(int[] list, int key){ //array must be pre sorted
		int low = 0; //low element
		int high = list.length-1; //high element
		while (high >= low) { //when there aren’t we’ve found the element or it isn’t in the array
			int mid = (low + high)/2; //will return a whole number (int division)
			if (key < list[mid]) //if the number is in the bottom half
				high = mid -1; //remake high to mid -1 for another iteration
			else if (key == list[mid]) //if the number is the middle number
				return mid; //return the index
			else 
				low = mid +1; //if number is in the top half, remake low to mid + 1 for another iteration
		}
		return -low -1; //not found
	}

	

}
