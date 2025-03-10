package cs2050ClassWork;

public class BubbleSortTest {

	public static void main(String[] args) {
		int [] array = {3,2,1};
		insertionSort(array);

	}
	
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
        	System.out.println("Current array: "+array[0]+array[1]+array[2]+array[3]);
            for (int j = 0; j < n - 1 - i; j++) {
            	System.out.println("Comparing "+array[j]+" and "+array[j+1]);
                if (array[j] > array[j + 1]) {
                	System.out.println("Swapping");
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("Current array: "+array[0]+array[1]+array[2]+array[3]);
                }
            }
        }
        System.out.print("Final Array: ");
        for (int k = 0; k<n;k++) {
        	System.out.print(array[k]);
        }
    }

    
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
