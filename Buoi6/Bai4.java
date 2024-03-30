package hello;

import java.util.Scanner;

public class Main {

	public static int inputNumber(Scanner in, String str) {
		int number;
		while (true) {
			System.out.print(str);
			try {
				number = Integer.parseInt(in.nextLine());
				if (number == 0) {
					System.out.println("Bạn phải nhập vào số khác 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào số khác 0");
			}
		}
		return number;
	}

	public static void phepCong(Scanner in) {
		int a = inputNumber(in, "Nhập vào a: ");
		int b = inputNumber(in, "Nhập vào b: ");
		int tong = (a) + (b); // () -> Trường hợp người dùng nhập vào cả số âm
		System.out.printf("Tổng 2 số (%d) + (%d) = %d", a, b, tong);
	}

	public static void phepTru(Scanner in) {
		int a = inputNumber(in, "Nhập vào a: ");
		int b = inputNumber(in, "Nhập vào b: ");
		int hieu = (a) - (b); // () -> Trường hợp người dùng nhập vào cả số âm
		System.out.printf("Hiệu 2 số (%d) - (%d) = %d", a, b, hieu);
	}

	public static void phepNhan(Scanner in) {
		int a = inputNumber(in, "Nhập vào a: ");
		int b = inputNumber(in, "Nhập vào b: ");
		int tich = (a) * (b); // () -> Trường hợp người dùng nhập vào cả số âm
		System.out.printf("Tích 2 số (%d) * (%d) = %d", a, b, tich);
	}

	public static void phepChia(Scanner in) {
		int a = inputNumber(in, "Nhập vào a: ");
		int b = inputNumber(in, "Nhập vào b: ");
		double thuong = (double) (a) / (b); // () -> Trường hợp người dùng nhập vào cả số âm
		System.out.printf("Thương 2 số (%d) : (%d) = %.2f", a, b, thuong);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Chương trình tính toán");
		System.out.println("Chọn 1 để thực hiện phép tính cộng (+)");
		System.out.println("Chọn 2 để thực hiện phép tính trừ (-)");
		System.out.println("Chọn 3 để thực hiện phép tính nhân (*)");
		System.out.println("Chọn 4 để thực hiện phép tính chia (:)");

		int chon;
		while (true) {
			chon = inputNumber(in, "Nhập vào một số trong khoảng từ 1 đến 4: ");
			switch (chon) {
			case 1: {
				System.out.println("Thực hiện phép tính cộng");
				phepCong(in);
				return;
			}
			case 2: {
				System.out.println("Thực hiện phép tính trừ");
				phepTru(in);
				return;
			}
			case 3: {
				System.out.println("Thực hiện phép tính nhân");
				phepNhan(in);
				return;
			}
			case 4: {
				System.out.println("Thực hiện phép tính chia");
				phepChia(in);
				return;
			}
			default:
				System.out.println("Số bạn nhập không hợp lệ. Vui lòng nhập lại");
			}
		}

	}

}
