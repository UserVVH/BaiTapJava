package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number;
		String[] numberWords = { "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín", "Mười" };
		do {
			System.out.print("Nhập một số từ 1 đến 10: ");
			number = in.nextInt();
			if (number >= 1 && number <= 10) {
				System.out.println("Số " + number + " được viết dưới dạng chữ là: " + numberWords[number - 1]);
			} else {
				System.out.println("Số không hợp lệ. Vui lòng nhập số từ 1 đến 10.");
			}
		} while (number < 1 || number > 10);
		in.close();

	}
}
