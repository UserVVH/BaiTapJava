package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	private static int inputIntNumber(Scanner in, String str) {
		int number;
		while (true) {
			System.out.print(str);
			try {
				number = Integer.parseInt(in.nextLine());
				if (number <= 0) {
					System.out.println("Bạn phải nhập vào số nguyên dương > 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào số nguyên dương > 0");
			}
		}
		return number;
	}

	private static double inputDoubleNumber(Scanner in, String str) {
		double number;
		while (true) {
			System.out.print(str);
			try {
				number = Double.parseDouble(in.nextLine());
				if (number <= 0) {
					System.out.println("Bạn phải nhập vào số > 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào số > 0");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Tạo mẫu định dạng số tiền
		DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

		double soTienGui = inputDoubleNumber(in, "Nhập số tiền anh X gửi vào ngân hàng: ");

		double laiSuat = 0;
		while (true) {
			System.out.print("Nhập lãi suất tiết kiệm hàng năm (dạng phần trăm, ví dụ: 5.38%): ");
			String input = in.nextLine();
			if (input.matches("^\\d+(\\.\\d+)?%$")) { // Kiểm tra xem chuỗi có đúng định dạng không
				laiSuat = Double.parseDouble(input.replace("%", "")) / 100;
				break;
			} else {
				System.out.println("Lỗi! Lãi suất không hợp lệ. Hãy nhập lại.");
			}
		}

		int namBatDau = inputIntNumber(in, "Nhập năm bắt đầu gửi tiền: ");
		double soTienMongMuon;
		do {
			soTienMongMuon = inputDoubleNumber(in, "Nhập số tiền anh X muốn có trong tương lai: ");
			if (soTienMongMuon <= soTienGui) {
				System.out.println("Vui lòng nhập số tiền mong muốn lớn hơn số tiền gửi");
			}
		} while (soTienMongMuon <= soTienGui);

		int soNam = 0;
		double soTienHienTai = soTienGui;
		while (soTienHienTai < soTienMongMuon) {
			soTienHienTai += soTienHienTai * laiSuat; // cộng thêm lãi suất hàng năm
//			System.out.printf("%.2f%n", soTienHienTai);
			++soNam;
		}

		System.out.printf("Anh X sẽ chờ %d năm, đến năm %d và nhận được số tiền %s VND", soNam, (namBatDau + soNam),
				decimalFormat.format(soTienHienTai));
		in.close();

	}

}
