package hello;

import java.util.Scanner;

public class Main {

	public static void nhapMang(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static void findMax(int[] arr) {
		int max = arr[0];
		System.out.print("Số lớn nhất trong mảng là: ");
		for (int i = 1; i < arr.length; ++i) {
			max = Math.max(max, arr[i]);
		}
		System.out.print(max);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		nhapMang(in, arr);
		findMax(arr);
		in.close();

	}
}
