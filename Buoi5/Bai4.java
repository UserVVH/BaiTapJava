package hello;

import java.util.Scanner;

public class DemoBuoi6 {

	private static int tinhTong(int x, int n) {
		int tong = 0;
		for (int i = 1; i <= n; i++) {
			tong += Math.pow(x, i);
		}
		return tong;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập vào số nguyên n: ");
		int n = in.nextInt();
		System.out.print("Nhập vào số nguyên x: ");
		int x = in.nextInt();

		int tong = tinhTong(x, n);
		System.out.println("Tổng S(n) = " + tong);
		in.close();

	}

}
