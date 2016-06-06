import java.util.*;

/*
 * File: RadixSort.java
 * -----------------------------
 * This class implements Radix Sort.
 * Runtime: O(kn)
 */

public class RadixSort {

	public static void main(String[] args) {
		int[] array = arrayInit();
		radixSort(array);
		System.out.println(Arrays.toString(array) + "\n");
	}
	
	// Sorts an array of non-negative integers.
	public static void radixSort(int[] array) {
		int maxVal = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxVal) {
				maxVal = array[i];
			}
		}
		int nSeparations = String.valueOf(maxVal).length();
		for (int i = 0; i < nSeparations; i++) {
			separate(array, i+1);
		}
	}
	
	// Uses buckets to group numbers, and then re-groups them.
	public static void separate(int[] array, int iter) {
		int howManyNumbers = array.length;
		int[][] buckets = new int[10][howManyNumbers];
		int[] howManyInBucketRow = new int[10];
		for (int i = 0; i < 10; i++) { // Default to 0.
			howManyInBucketRow[i] = 0;
		}
		for (int i = 0; i < howManyNumbers; i++) {
			int digit = getDigit(array[i], iter); // Get a single digit.
			buckets[digit][howManyInBucketRow[digit]] = array[i]; // Assign value to 2D-Array cell.
			howManyInBucketRow[digit] += 1;
		}
		// Put buckets back together.
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < howManyInBucketRow[i]; j++) {
				array[count] = buckets[i][j];
				count++;
			}
		}
	}
	
	// Retrieves a digit from the specified column from the right.
	public static int getDigit(int number, int colNumber) { // colNumber must be >= 1.
		for (int i = 0; i < colNumber-1; i++) {
			number /= 10;
		}
		number %= 10;
		return number;
	}
	
	// Asks the user to enter a series of non-negative integers.
	public static int[] arrayInit() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nTest for Radix Sort (also called Bucket Sort):\n");
		System.out.println("How many non-negative integers would you like to enter?");
		int userInput = input.nextInt();
		int[] intArray = new int[userInput];
		if (userInput != 1) {
			System.out.println("\nGreat! Please type out " + userInput + " non-negative integers:");
		} else {
			System.out.println("\nGreat! Please type out 1 non-negative integer:");
		}
		for (int i = 0; i < userInput; i++) {
			intArray[i] = input.nextInt();
		}
		System.out.print("\nResult: ");
		return intArray;
	}
	
}