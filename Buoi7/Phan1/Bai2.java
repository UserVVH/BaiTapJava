package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào 1 số nguyên: ");
		int n = in.nextInt();
		if (n % 2 == 0) {
			System.out.println(n + " là số chẵn");
		} else {
			System.out.println(n + " là số lẻ");
		}
		in.close();

	}
}
