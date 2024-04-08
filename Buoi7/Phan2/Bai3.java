package hello;

import java.util.Scanner;

public class Main {

	public static void inputArray(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static void findFirstNegative(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] < 0) {
				System.out.println("Số âm đầu tiên trong mảng là: " + arr[i]);
				System.out.println("Vị trí của số âm đầu tiên trong mảng là: " + (i + 1));
				return;
			}
		}

		System.out.println("Mảng không có số âm");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		inputArray(in, arr);
		findFirstNegative(arr);
		in.close();

	}
}
