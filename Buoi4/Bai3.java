package hello;

import java.util.Scanner;

public class DemoBuoi4 {

	private static int inputNumber(Scanner sc) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine());
				int check = 2024 - number;
				if (check >= 18 && check <= 50) {
					break;
				} else {
					System.out.println("Năm sinh không hợp lệ, Vui lòng nhập lại năm sinh từ (1974-2006)");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập số nguyên");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String tenCanBoTreNhat = "";
		int namSinhCanBoTreNhat = Integer.MIN_VALUE;
		boolean isCanBoNam = false;

		for (int i = 0; i < 3; ++i) {
			System.out.println("Nhập thông tin của cán bộ " + (i + 1) + ": ");
			System.out.print("Tên: ");
			String ten = sc.nextLine();
			System.out.print("Năm sinh: ");
			int namSinh = inputNumber(sc);
			System.out.print("Giới tính (Nam/Nu): ");
			String gioiTinh = sc.nextLine();

			if (gioiTinh.equalsIgnoreCase("Nam") && namSinh > namSinhCanBoTreNhat) {
				tenCanBoTreNhat = ten;
				namSinhCanBoTreNhat = namSinh;
				isCanBoNam = true;
			}
		}

		if (isCanBoNam) {
			System.out.println("Cán bộ Nam trẻ nhất là: " + tenCanBoTreNhat);
		} else {
			System.out.println("Không có cán bộ Nam trong danh sách.");
		}
		sc.close();

	}

}
