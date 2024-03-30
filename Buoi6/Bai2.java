package hello;

import java.util.Scanner;

public class Main {

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Nhập số cần kiểm tra: ");
		int number = in.nextInt();
		if (isEven(number)) {
			System.out.println(number + " là số chẵn");
		} else {
			System.out.println(number + " là số lẻ");
		}

		in.close();

	}

}
