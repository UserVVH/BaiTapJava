package hello;

import java.util.Scanner;

public class DemoBuoi4 {

	private static double inputNumber(Scanner sc) {
		double number;
		while (true) {
			try {
				number = Double.parseDouble(sc.nextLine());
				if (number <= 0) {
					System.out.println("Bạn phải nhập tọa độ > 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào chữ số và tọa độ > 0");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tọa độ của trường đại học:");
		System.out.print("X = ");
		double truongDaiHocX = inputNumber(sc);
		System.out.print("Y = ");
		double truongDaiHocY = inputNumber(sc);

		String tenSinhVienXaNhat = "";
		double khoangCachMax = 0;

		for (int i = 0; i < 3; ++i) {
			System.out.println("Nhập thông tin của sinh viên " + (i + 1) + ":");
			System.out.print("Tên: ");
			String ten = sc.nextLine();
			System.out.println("Tọa độ nhà (X Y)");
			System.out.print("Nhập tọa độ X: ");
			double nhaX = inputNumber(sc);
			System.out.print("Nhập tọa độ Y: ");
			double nhaY = inputNumber(sc);

			// Tính khoảng cách từ nhà sinh viên đến trường đại học
			double khoangCach = Math.sqrt(Math.pow(truongDaiHocX - nhaX, 2) + Math.pow(truongDaiHocY - nhaY, 2));
			System.out.println("Khoảng cách là: " + khoangCach);

			// So sánh và cập nhật thông tin sinh viên xa trường đại học nhất
			if (khoangCach > khoangCachMax) {
				tenSinhVienXaNhat = ten;
				khoangCachMax = khoangCach;
			}
		}

		System.out.println("Sinh viên ở xa trường đại học nhất là: " + tenSinhVienXaNhat);
		sc.close();

	}

}
