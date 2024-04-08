package hello;

import java.util.Scanner;

public class Main {

	public static void inputArray(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static void findMaxNegativeNumber(int[] arr) {
		Integer maxNegative = null;
		int index = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 && (maxNegative == null || arr[i] > maxNegative)) {
				maxNegative = arr[i];
				index = i;
			}
		}

		if (maxNegative != null) {
			System.out.println("Số âm lớn nhất trong mảng là: " + maxNegative);
			System.out.println("Vị trí của số âm lớn nhất là: " + (index + 1));
		} else {
			System.out.println("Không có số âm nào trong mảng");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		inputArray(in, arr);
		findMaxNegativeNumber(arr);
		in.close();

	}
}
