package hello;

import java.util.Scanner;

public class DemoBuoi6 {

	public static void inSoLeChanWhile() {
		int i = 0;
		System.out.println("Các số nguyên dương lẻ nhỏ hơn 100:");
		while (i < 100) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
			++i;
		}

		i = 0;
		System.out.println("\nCác số nguyên dương chẵn nhỏ hơn 100:");
		while (i < 100) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			++i;
		}
	}

	public static void inSoLeChanFor() {
		System.out.println("Các số nguyên dương lẻ nhỏ hơn 100:");
		for (int i = 0; i < 100; ++i) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println("\nCác số nguyên dương chẵn nhỏ hơn 100:");
		for (int i = 0; i < 100; ++i) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Sử dụng vòng lặp while:");
		inSoLeChanWhile();
		System.out.println("\nSử dụng vòng lặp for:");
		inSoLeChanFor();
		in.close();

	}

}
