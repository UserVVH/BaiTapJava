package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào 1 số: ");
		int n = in.nextInt();
		if (n >= 0) {
			System.out.println(n + " là số nguyên dương");
		} else {
			System.out.println(n + " là số nguyên âm");
		}
		in.close();

	}
}
