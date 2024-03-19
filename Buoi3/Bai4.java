package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; ++i) {
			System.out.printf("Nhập vào số thứ %d: ", i + 1);
			int number = scanner.nextInt();
			sum += number;
		}
		double average = (double) sum / 5;
		System.out.println("Giá trị trung bình của 5 số là: " + average);
		scanner.close();
	}
}
