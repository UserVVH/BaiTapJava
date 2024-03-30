package hello;

import java.util.Scanner;

public class Main {
	public static int timMax(int a, int b, int c) {
		int max = a;
		if (max < b) {
			max = b;
		}
		if (max < c) {
			max = c;
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập a: ");
		int a = in.nextInt();
		System.out.print("Nhập b: ");
		int b = in.nextInt();
		System.out.print("Nhập c: ");
		int c = in.nextInt();
		System.out.printf("Số lớn nhất trong 3 số %d %d %d là: %d", a, b, c, timMax(a, b, c));
		in.close();

	}

}
