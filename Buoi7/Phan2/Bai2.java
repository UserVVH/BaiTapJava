package hello;

import java.util.Scanner;

public class Main {

	public static void inputArray(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static void findMaxNumber(int[] arr) {

		int max = arr[0];
		int maxIndex = 0;

		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}

		System.out.println("Số lớn nhất trong mảng là: " + max);
		System.out.println("Vị trí của số lớn nhất trong mảng là: " + (maxIndex + 1));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		inputArray(in, arr);
		findMaxNumber(arr);
		in.close();

	}
}
