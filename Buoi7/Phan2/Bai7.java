package hello;

import java.util.Scanner;

public class Main {

	public static void inputArray(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static int sumOfNegativeNumbers(int[] arr) {
		int sum = 0;

		for (int num : arr) {
			if (num < 0) {
				sum += num;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		inputArray(in, arr);
		int sum = sumOfNegativeNumbers(arr);
		if (sum == 0) {
			System.out.println("Mảng không có số âm");
		} else {
			System.out.println("Tổng các số âm trong mảng = " + sum);
		}
		in.close();

	}
}
