package in.targetpeak.api.util;

import java.util.Arrays;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashPassword {

	public static void main(String[] args) {
		// String hashPass=BCrypt;
		// String hash = BCrypt.hashpw("password");
		// boolean s = BCrypt.checkpw("password", hash);

		// BCrypt.hashpw(password, BCrypt.gensalt(8));

		String a[] = { "a", "bd", "ac", "cd" };
		int n = 4;

		System.out.println("first example smallest string = " + smallesString(a));

		System.out.println("first example smallest string = " + smallestString(a, n));

		String b[] = { "c", "cc", "cca", "cccb" };
		int n1 = 4;
		System.out.println("second example smallest string = " + smallestString(b, n1));

		int arr[] = { 5, 3, 4, 2, 1 };
		System.out.println("Number of inversions are " + getInvCount(arr));
		System.out.println("Number of inversions are " + getInvArray(arr));
		
		
		
		
		int arr5[] = { 2, 3, 4, 1, 5 };
		
		//int arr5[] = { 5,1,4,2,0 };
		 
        // Function to find minimum swaps
        System.out.println("Mini are "+minimumSwaps(arr5));

	}

	static void sort(String a[], int n) {

		// sort the array
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((a[i] + a[j]).compareTo(a[j] + a[i]) > 0) {
					String s = a[i];
					a[i] = a[j];
					a[j] = s;
				}
			}
		}
	}

	static String smallestString(String a[], int n) {

		// Sort strings
		sort(a, n);

		// Concatenating sorted strings
		String answer = "";
		for (int i = 0; i < n; i++)
			answer += a[i];

		return answer;
	}

	public static String smallesString(List<String> substrings) {

		// We are sorting the list first
		int n = substrings.size();

		// populate list data into array
		String[] array = substrings.toArray(new String[0]);
		System.out.println(Arrays.toString(array));

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((array[i] + array[j]).compareTo(array[j] + array[i]) > 0) {
					String s = array[i];
					array[i] = array[j];
					array[j] = s;
				}
			}
		}

		// Concatenating sorted strings
		String answer = "";
		for (int i = 0; i < n; i++)
			answer += array[i];

		return answer;
	}

	/*
	 * region Inversions
	 * 
	 */

	static int getInvCount(int array[]) {
		int n = array.length;
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (array[i] > array[j])
					inv_count++;

		return inv_count;
	}

	static int getInvArray(int array[]) {
		int n = array.length;
		int inv_count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.println("Inversion Array:i" + array[i] + "Inversion Array:j" + array[j]);
				if (array[i] > array[j])
					inv_count++;
			}

		}

		return inv_count;
	}

	public static long maxInversions(List<Integer> arr) {

		// populate list data into array
		Integer[] array = arr.toArray(new Integer[0]);
		System.out.println(Arrays.toString(array));

		int n = array.length;
		long inv_count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				// System.out.println("Inversion Array:i" + array[i] + "Inversion Array:j" +
				// array[j]);
				if (array[i] > array[j])
					inv_count++;
			}

		}

		return inv_count;
	}

	public static String smallesString(String array[]) {

		int n = array.length;

		// populate list data into array
		// String[] array = substrings.toArray(new String[0]);
		// System.out.println(Arrays.toString(array));

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((array[i] + array[j]).compareTo(array[j] + array[i]) > 0) {
					String s = array[i];
					array[i] = array[j];
					array[j] = s;
				}
			}
		}

		// Concatenating sorted strings
		String answer = "";
		for (int i = 0; i < n; i++)
			answer += array[i];

		return answer;
	}

	static int minimumSwaps(int[] arr) {
		// Initialise count variable
		int count = 0;
		try {
			
			int i = 0;
			while (i < arr.length) {

				// If current element is
				// not at the right position
				if (arr[i] != i + 1) {

					while (arr[i] != i + 1) {
						int temp = 0;

						// Swap current element
						// with correct position
						// of that element
						temp = arr[arr[i] - 1];
						arr[arr[i] - 1] = arr[i];
						arr[i] = temp;
						count++;
					}
				}

				// Increment for next index
				// when current element is at
				// correct position
				i++;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return count;
	}
	
	
	public static long howManySwaps(List<Integer>arr) {
		Integer[] array = arr.toArray(new Integer[0]);
		System.out.println(Arrays.toString(array));

		int n = array.length;
		
		long count = 0;
		int i = 0;
		while (i < n) {

			// If current element is
			// not at the right position
			if (array[i] != i + 1) {

				while (array[i] != i + 1) {
					int temp = 0;

					// Swap current element
					// with correct position
					// of that element
					temp = array[array[i] - 1];
					array[array[i] - 1] = array[i];
					array[i] = temp;
					count++;
				}
			}

			// Increment for next index
			// when current element is at
			// correct position
			i++;
		}
		return count;
		
	}

	class Solution {

	}

}
