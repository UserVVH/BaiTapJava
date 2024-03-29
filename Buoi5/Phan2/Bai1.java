package hello;

import java.util.Scanner;

public class Main {

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

//			Kết Quả
//			Sử dụng vòng lặp while:
//			Các số nguyên dương lẻ nhỏ hơn 100:
//			1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99 
//			Các số nguyên dương chẵn nhỏ hơn 100:
//			0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 

//			Sử dụng vòng lặp for:
//			Các số nguyên dương lẻ nhỏ hơn 100:
//			1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99 
//			Các số nguyên dương chẵn nhỏ hơn 100:
//			0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 

	}

}
