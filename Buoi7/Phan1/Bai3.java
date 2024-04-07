package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number;
		int sum = 0;
		System.out.print("Vui lòng nhập vào 1 số nguyên dương: ");
		number = in.nextInt();
		for (int i = 0; i <= number; ++i) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("Tổng các số chẵn trong khoảng từ 0 đến " + number + " là: " + sum);
		in.close();

	}
}
