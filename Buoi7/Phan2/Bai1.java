package hello;

import java.util.Scanner;

public class Main {

	public static void nhapMang(Scanner in, int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
		}
	}

	public static void xuatMang(int[] arr) {
		System.out.print("Các phần tử trong mảng là: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = in.nextInt();
		int[] arr = new int[n];
		nhapMang(in, arr);
		xuatMang(arr);
		in.close();

	}
}
