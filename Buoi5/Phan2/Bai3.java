package hello;

import java.util.Scanner;

public class Main {

	public static void demSoWhile() {
		int i = 0;
		int count = 0;
		while (i <= 1000) {
			if (i % 3 == 0) {
				++count;
			}
			++i;
		}
		System.out.printf("Có %d số chia hết cho 3 từ 0 - 1000", count);

	}

	public static void demSoFor() {
		int count = 0;
		for (int i = 0; i <= 1000; ++i) {
			if (i % 3 == 0) {
				++count;
			}
		}
		System.out.printf("Có %d số chia hết cho 3 từ 0 - 1000", count);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Sử dụng vòng lặp while:");
		demSoWhile();
		System.out.println("\nSử dụng vòng lặp for:");
		demSoFor();
		in.close();

//			Kết quả
//			Sử dụng vòng lặp while:
//			Có 334 số chia hết cho 3 từ 0 - 1000
//			Sử dụng vòng lặp for:
//			Có 334 số chia hết cho 3 từ 0 - 1000

	}

}
