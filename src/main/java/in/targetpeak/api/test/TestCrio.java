package in.targetpeak.api.test;

import java.util.Scanner;

public class TestCrio {

	static int n1 = 0, n2 = 1, n3 = 0;
	static int temp = 0;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.println("t:"+t);
			int n = sc.nextInt();

			// create fibonacci
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.println(n3);
			//int result = largestFibonacciNumber(n);
			//System.out.println("result:"+result);
//			if (result == 0) {
//
//			} else {
//				System.out.println(result);
//			}
		}
		sc.close();

		// int t=
		// createFibonacci(4);

	}

	static int largestFibonacciNumber(int n) {
		System.out.println(n3);
		if (n > n3) {
			return temp;
		} else {
			temp = n3;
			return 0;
		}
	}

	public static void createFibonacci(int t) {
		// int t=4;
		while (t-- > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.println(n3);
			createFibonacci(t - 1);
		}

	}

}
