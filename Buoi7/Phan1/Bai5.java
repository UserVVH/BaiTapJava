package hello;

import java.util.Scanner;

public class Main {
	// Hàm tìm số lớn nhất trong mảng
	public static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// Hàm tìm số nhỏ nhất trong mảng
	public static int findMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number;
		System.out.print("Vui lòng nhập vào số lượng phần tử của mảng: ");
		number = in.nextInt();
		int[] arr = new int[number];
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
		System.out.println("Số lớn nhất trong mảng là: " + findMax(arr));
		System.out.println("Số nhỏ nhất trong mảng là: " + findMin(arr));
		in.close();

	}
}
