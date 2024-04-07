package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number;
		int sum = 0;
		System.out.print("Vui lòng nhập vào 1 số nguyên dương: ");
		number = in.nextInt();
		int[] arr = new int[number];
		for (int i = 0; i < arr.length; ++i) {
			System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		double average = (double) sum / number;
		System.out.printf("Giá trị trung bình của mảng = %.2f", average);
		in.close();

	}
}
