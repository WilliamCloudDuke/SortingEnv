package sortroutines;

public class OnlyOnce {

	static {
		System.out.println("Executing before main method");
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 9, 3, 2, 1, 4, 5 };
		int max = getMax(array);
		System.out.println("The First number that occurs only once is : " + getOnlyOnce(array, max));

		int[] array2 = { 12, 24, 12, 24, 5, 7, 9, 11, 24, 7, 3 };
		int max2 = getMax(array2);
		System.out.println("The First number that occurs only once is : " + getOnlyOnce(array2, max2));

	}

	public static int getOnlyOnce(int[] inputArray, int max) {
		int number = 0;
		// First, create bucket with the same size as the input array
		int[] bucket = new int[max + 1];
		// Traverse the inputArray and store the elements in bucket array
		for (int i = 0; i < inputArray.length; i++) { // O(n)
			if (bucket[inputArray[i]] != 0) {
				bucket[inputArray[i]] = bucket[inputArray[i]] + 1;
			} else {
				bucket[inputArray[i]] = 1;
			}
		}
		for (int i = 0; i < inputArray.length; i++) {// O(m) + O (n)
			if (bucket[inputArray[i]] == 1) {
				return inputArray[i];
			}
		}
		return number;
	}

	private static int getMax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

}
