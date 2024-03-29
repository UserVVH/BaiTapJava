
package hello;

import java.util.Scanner;

public class Main {

	private static int inputNumber(Scanner in) {
		int number;
		while (true) {
			System.out.print("Nhập vào n: ");
			try {
				number = Integer.parseInt(in.nextLine());
				if (number <= 0) {
					System.out.println("Bạn phải nhập vào số nguyên dương > 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào số nguyên dương > 0");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = inputNumber(in);
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.printf("Tổng các số lẻ nguyên dương nhỏ hơn %d là: %d", n, sum);
		in.close();

	}

}
