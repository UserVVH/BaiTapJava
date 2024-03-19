package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = 8;
		System.out.print("Vui lòng nhập vào a = ");
		double a = scanner.nextDouble();
		System.out.print("Vui lòng nhập vào n = ");
		int n = scanner.nextInt();
		double p = a * Math.pow(x, n);
		System.out.printf("Giá trị đơn thức P(%d) = %.2f*%d^%d = %.2f", x, a, x, n, p);
		scanner.close();
	}
}
