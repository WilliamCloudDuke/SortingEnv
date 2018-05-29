package sortroutines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IsPrime {

	static {
		System.out.println("Executing before main method");
	}

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter a number:");
		// int number = sc.nextInt();
		// // boolean isPrime = isPrime(number, number / 2);
		// boolean isPrime = isPrime(number);
		// if (isPrime)
		// System.out.println("The number " + number + " is prime");
		// else
		// System.out.println("The number " + number + " is NOT prime");

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		List<Integer> noDup = removeDups(list);
		for (int i : noDup) {
			System.out.printf("%d ", i);
		}

	}

	private static boolean isPrime(int number, int i) {
		if (i == 1) {
			return true;
		} else if (number % i == 0)
			return false;
		else
			return isPrime(number, i - 1);
	}

	public static boolean isPrime(int n) {
		int i, m = 0;
		boolean prime = true;
		m = n / 2;
		if (n == 0 || n == 1) {
			prime = false;
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					prime = false;
					break;
				}
			}
		}
		return prime;
	}

	private static List<Integer> removeDups(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (!map.containsKey(list.get(i))) {
				map.put(list.get(i), 0);
			}
		}
		return map.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

	}

}
