package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập vào độ C: ");
		double doC = scanner.nextDouble();
		double doF = (doC * 1.8) + 32;
		System.out.println("Nhiệt độ tương ứng (độ F): " + doF);
		scanner.close();
	}
}
