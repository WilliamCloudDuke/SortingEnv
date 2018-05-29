package sortroutines;

public class BucketSort {

	private int[] bucket;

	static {
		System.out.println("Executing before main method");
	}

	public static void main(String[] args) {
		BucketSort bs = new BucketSort();
		int[] inputArray = { 1, 2, 17, -4, -6, 8 };
		int[] range = bs.range(inputArray);
		int[] output = bs.bucketSort(inputArray, range[0], range[1]);
		System.out.println("Sorted with negative numbers: ");
		for (int i : output) {
			System.out.printf("%d ", i);
		}
		System.out.println(" ");
		int[] inputArray2 = { 1, 2, 17, 4, 6, 8 };
		int[] range2 = bs.range(inputArray2);
		int[] output2 = bs.bucketSort(inputArray2, range2[0], range2[1]);
		System.out.println("Sorted with positive numbers: ");
		for (int i : output2) {
			System.out.printf("%d ", i);
		}

	}

	public int[] bucketSort(int[] inputArray, int min, int max) {
		int[] output = new int[inputArray.length];// Create an output array of size n - STEP 1 requires O (m + n)
		int positiveMin = Math.abs(min);
		int newValue = 0;
		int j = 0;
		if (min < 0) {
			bucket = new int[max + positiveMin + 1]; // Create an array bucket of size m - STEP 1 requires O (m + n)
			for (int i = 0; i < inputArray.length; i++) {// Scan input array to store elements in bucket - STEP 2 -
															// Requires O(n)
				newValue = inputArray[i] + positiveMin;
				bucket[newValue] = inputArray[i];// Copy element into bucket array
			}
		} else {
			// when min is greater or equal to 0
			bucket = new int[max + 1]; // Create an array bucket of size m - STEP 1 requires O (m + n)
			for (int i = 0; i < inputArray.length; i++) {// Scan input array to store elements in bucket - STEP 2 -
															// Requires O(n)
				bucket[inputArray[i]] = inputArray[i];// Copy element into bucket array
			}
		}
		for (int i = 0; i < bucket.length; i++) {// Scan bucket array to put elements into output array O(m) + O (n)
			if (bucket[i] != 0) { // Therefore, BucketSort runs in O(m+n).
				output[j++] = bucket[i];
			}
		}
		return output;
	}

	private int[] range(int[] array) {
		int[] range = new int[2];
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			} else if (array[i] < min) {
				min = array[i];
			}
		}
		range[0] = min;
		range[1] = max;
		return range;
	}

}