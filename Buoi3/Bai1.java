package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập cạnh a: ");
		double a = scanner.nextDouble();

		System.out.print("Nhập cạnh b: ");
		double b = scanner.nextDouble();

		double c = Math.sqrt(a * a + b * b);
		System.out.println("Chiều dài cạnh huyền là: " + c);
		scanner.close();
	}
}
