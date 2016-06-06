import java.util.*;

/*
 * File: Quicksort.java
 * -----------------------------------------------
 * This class implements Quicksort.
 * -----------------------------------------------
 * References/Citations:
 * 1) CS106BX-Reader (Autumn Quarter 2012)
 * 2) https://www.youtube.com/watch?v=MZaf_9IZCrc
 * 3) https://www.youtube.com/watch?v=aQiWF4E8flQ
 */

public class Quicksort {

	public static void main(String[] args) {
		int[] array = arrayInit();
		quicksort(array);
		print(array);
	}
	
	// Sorts an array of integers.
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length-1);
	}
	
	// Sorts an array of integers.
	public static void quicksort(int[] array, int start, int finish) {
		if (start >= finish) return;
		int boundary = partition(array, start, finish);
		quicksort(array, start, boundary-1);
		quicksort(array, boundary+1, finish);
	}
	
	// Partitions an array.
	public static int partition(int[] array, int start, int finish) {
		int i = start-1;
		int j = start;
		for (int m = 0; m < finish-start; m++) {
			if (array[j] < array[finish]) {
				i++;
				swap(array, i, j);
			}
			j++;
		}
		swap(array, i+1, finish);
		return i+1;
	}
	
	// Swaps two elements in an array.
	public static void swap(int[] array, int a, int b) {
		if (a >= 0 & b >= 0 && a <= array.length && b <= array.length && a != b) {
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	}
	
	// Prints the result to the screen.
	public static void print(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length-1) System.out.print(", ");
		}
		System.out.print("]");
	}
	
	// Asks the user to enter a series of integers.
	public static int[] arrayInit() {
		Scanner input = new Scanner(System.in);
		System.out.println("Test for Quick Sort:\n");
		System.out.println("How many integers would you like to enter?");
		int userInput = input.nextInt();
		int[] intArray = new int[userInput];
		if (userInput != 1) {
			System.out.println("\nGreat! Please type out " + userInput + " integers:");
		} else {
			System.out.println("\nGreat! Please type out 1 integer:");
		}
		for (int i = 0; i < userInput; i++) {
			intArray[i] = input.nextInt();
		}
		System.out.print("\nResult: ");
		return intArray;
	}
	
}