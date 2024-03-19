package hello;

import java.util.Scanner;

public class Main {
	public final static double VND = 23500;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số tiền USD: ");
		double usdMoney = scanner.nextDouble();
		double vndMoney = usdMoney * VND;
		System.out.printf("%.2f USD = %.0f VND", usdMoney, vndMoney);
		scanner.close();
	}
}
