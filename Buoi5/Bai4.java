package hello;

import java.util.Scanner;

public class DemoBuoi6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Nhập giá trị của x: ");
		double x = in.nextDouble();

		System.out.print("Nhập giá trị của n: ");
		int n = in.nextInt();

		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += Math.pow(x, i);
		}

		System.out.printf("Tổng của dãy số S(n) là: %.2f", sum);
		in.close();

	}

}
