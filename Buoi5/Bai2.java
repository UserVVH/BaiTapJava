package hello;

import java.util.Scanner;

public class DemoBuoi6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		int n = 0;

		while (sum <= 10000) {
			sum += n;
			++n;
		}
		System.out.println("Số nguyên dương n nhỏ nhất sao cho 1 + 2 + ... + n > 10000 là: " + (n - 1));
		in.close();

	}

}
