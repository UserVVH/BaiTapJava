package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DemoBuoi4 {

	private static int nhapSoLuong(Scanner sc, int min) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(sc.nextLine());
				if (number > min) {
					break;
				} else {
					System.out.println("Vui lòng nhập số lượng > 0");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số lượng là số nguyên và phải > 0");
			}
		}
		return number;
	}

	private static double nhapDonGia(Scanner sc, int min) {
		double number;
		while (true) {
			try {
				number = Double.parseDouble(sc.nextLine());
				if (number > min) {
					break;
				} else {
					System.out.println("Vui lòng nhập đơn giá > 0");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập đơn giá là chữ số và phải > 0");
			}
		}
		return number;
	}

	private static double tinhTienPhaiTra(String tenSanPham, int soLuong, double donGia) {
		double giamGia = 0;
		if (soLuong >= 50 && soLuong <= 100) {
			giamGia = 0.08;
		} else if (soLuong > 100) {
			giamGia = 0.12;
		}

		double tongTien = soLuong * donGia;
		double tienGiam = tongTien * giamGia;
		double tienPhaiTra = tongTien - tienGiam;

		return tienPhaiTra;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Tạo mẫu định dạng số tiền
		DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

		System.out.println("Nhập thông tin mặt hàng:");
		System.out.print("Tên sản phẩm: ");
		String tenSanPham = sc.nextLine();

		System.out.print("Số lượng: ");
		int soLuong = nhapSoLuong(sc, 0);

		System.out.print("Đơn giá: ");
		double donGia = nhapDonGia(sc, 0);

		double tienPhaiTra = tinhTienPhaiTra(tenSanPham, soLuong, donGia);

		System.out.println("Tiền phải trả: " + decimalFormat.format(tienPhaiTra) + " VND");
		sc.close();

	}

}
