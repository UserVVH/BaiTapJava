package hello;

import java.util.Scanner;

public class Main {

	public static int inputNumber(Scanner in) {
		int number;
		while (true) {
			System.out.print("Nhập n: ");
			try {
				number = Integer.parseInt(in.nextLine());
				if (number <= 1) {
					System.out.println("Bạn phải nhập vào số > 1");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào số > 1");
			}
		}
		return number;
	}

	public static void tongSoChanWhile(int n) {
		int i = 1;
		int sum = 0;
		while (i <= n) {
			if (i % 2 == 0) {
				sum += i;
			}
			++i;
		}
		System.out.printf("Tổng các số chẵn từ 1 đến %d = %d", n, sum);

	}

	public static void tongSoChanFor(int n) {
		int sum = 0;
		for (int i = 1; i <= n; ++i) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.printf("Tổng các số chẵn từ 1 đến %d = %d", n, sum);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = inputNumber(in);
		System.out.println("Sử dụng vòng lặp while:");
		tongSoChanWhile(n);
		System.out.println("\nSử dụng vòng lặp for:");
		tongSoChanFor(n);
		in.close();
//		Kết quả
//		Nhập n: sdfs 3
//		Bạn phải nhập vào số > 1
//		Nhập n: -34
//		Bạn phải nhập vào số > 1
//		Nhập n: 70
//		Sử dụng vòng lặp while:
//		Tổng các số chẵn từ 1 đến 70 = 1260
//		Sử dụng vòng lặp for:
//		Tổng các số chẵn từ 1 đến 70 = 1260
	}

}
