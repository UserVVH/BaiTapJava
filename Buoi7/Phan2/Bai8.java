package hello;

import java.util.Scanner;

public class Main {

	public static void inputArray(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static boolean findNumber(int[] arr, int x) {
		for (int num : arr) {
			if (num == x) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		inputArray(in, arr);
		System.out.print("Nhập vào số cần tìm x: ");
		int x = in.nextInt();
		if (findNumber(arr, x)) {
			System.out.println("Số " + x + " có trong mảng");
		} else {
			System.out.println("Số " + x + " không có trong mảng");
		}
		in.close();

	}
}
