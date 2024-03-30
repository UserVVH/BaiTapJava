package hello;

import java.util.Scanner;

public class Main {

	public static void tinhTong(Scanner in) {
		System.out.print("Nhập vào a: ");
		int a = in.nextInt();
		System.out.print("Nhập vào b: ");
		int b = in.nextInt();
		System.out.print("Nhập vào c: ");
		int c = in.nextInt();
		int tong = a + b + c;
		System.out.printf("Tổng của 3 số %d, %d, %d là: %d", a, b, c, tong);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Chương trình tính tổng 3 số");
		tinhTong(in);
		in.close();

	}

}
