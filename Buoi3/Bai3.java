package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhập vào số nguyên dương n: ");
			n = scanner.nextInt();

		} while (n < 10 || n > 99);
		int hangChuc = n / 10;
		int hangDonVi = n % 10;
		int tong = hangChuc + hangDonVi;
		System.out.println("Tổng = " + tong);
		scanner.close();
	}
}
