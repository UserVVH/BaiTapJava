package hello;

import java.util.Scanner;

public class DemoBuoi4 {

	private static int inputNumber(Scanner sc) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập số nguyên.");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int soLe = 0;
		int soChan = 0;

		for (int i = 0; i < 3; ++i) {
			System.out.print("Nhập số thứ " + (i + 1) + ": ");
			int so = inputNumber(sc);
			if (so % 2 == 0) {
				++soChan;
			} else {
				++soLe;
			}
		}

		System.out.printf("Có %d số lẻ %n", soLe);
		System.out.printf("Có %d số chẵn %n", soChan);
		sc.close();

	}

}
