package sortroutines;

import java.util.Arrays;

import runtime.Sorter;

/**
 * This is the slowest version of BubbleSort No optimization for already sorted
 * arrays. Doesn't take into account the fact that largest elements are pushed
 * to the right.
 *
 */
public class BubbleSort1 extends Sorter {

	int[] arr;
	boolean flag;

	public static void main(String[] args) {
		int[] test = { 21, 13, 1, -22, 51, 5, 18 };
		BubbleSort1 bs = new BubbleSort1();
		System.out.println(Arrays.toString(bs.sort(test)));

		int[] test2 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(bs.sort(test2)));
		int[] test3 = { 1, 2, 3, 4, 5, 9, 7 };
		System.out.println(Arrays.toString(bs.sort(test3)));

	}

	public int[] sort(int[] array) {
		this.arr = array;
		bubbleSort();
		return arr;

	}

	private void bubbleSort() {
		int len = arr.length;
		for (int i = 0; i < len - 1; ++i) {
			flag = false;
			for (int j = 0; j < len - 1; ++j) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
			// After each pass the algorithm evaluates if there was a swapping operation
			if (flag == false) {
				break;
			}

		}
	}

	int[] swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		flag = true;
		return arr;

	}
}
