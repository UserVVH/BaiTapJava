package hello;

import java.util.Scanner;

public class Main {

	public static boolean primeCheck(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n; ++i)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào 1 số nguyên: ");
		int n = in.nextInt();
		if (primeCheck(n)) {
			System.out.println(n + " là số nguyên tố");
		} else {
			System.out.println(n + " không phải số nguyên tố");
		}
		in.close();

	}
}
