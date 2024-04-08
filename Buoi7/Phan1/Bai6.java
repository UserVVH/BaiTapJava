package hello;

import java.util.Scanner;

public class Main {

	public static double dienTich(double canh) {
		return canh * canh;
	}

	public static double chuVi(double canh) {
		return 4 * canh;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập vào chiều rộng của hình vuông: ");
		double canh = in.nextDouble();
		System.out.printf("Diện tích của hình vuông là: %.2f %n", dienTich(canh));
		System.out.printf("Chu vi của hình vuông là: %.2f", chuVi(canh));
		in.close();

	}
}
