package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static int inputIntNumber(Scanner in, String str) {
		int number;
		while (true) {
			System.out.print(str);
			try {
				number = Integer.parseInt(in.nextLine());
				if (number < 0) {
					System.out.println("Bạn không được nhập số < 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn chỉ được nhập số nguyên");
			}
		}
		return number;
	}

	public static double inputDoubleNumber(Scanner in, String str) {
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

	public static double thanhTien(double soKmDaDi, int GIA_KM_DAU_TIEN, int GIA_TU_1_DEN_19_KM, int GIA_TREN_19_KM) {

		double thanhTien = 0;
		if (soKmDaDi <= 0.8) {
			thanhTien += GIA_KM_DAU_TIEN;
		} else {
			thanhTien += GIA_KM_DAU_TIEN;
			if (soKmDaDi <= 19) {
				thanhTien += (soKmDaDi - 0.8) * GIA_TU_1_DEN_19_KM;
			} else {
				thanhTien += (19 - 0.8) * GIA_TU_1_DEN_19_KM;
				thanhTien += (soKmDaDi - 19) * GIA_TREN_19_KM;
			}
		}
		return thanhTien;
	}

	public static double tongThanhToan(double soKmDaDi, int thoiGianCho, int GIA_KM_DAU_TIEN, int GIA_TU_1_DEN_19_KM,
			int GIA_TREN_19_KM, int GIA_THOI_GIAN_CHO) {

		double tongTien = 0;
		if (soKmDaDi <= 0.8) {
			tongTien += GIA_KM_DAU_TIEN;
		} else {
			tongTien += GIA_KM_DAU_TIEN;
			if (soKmDaDi <= 19) {
				tongTien += (soKmDaDi - 0.8) * GIA_TU_1_DEN_19_KM;
			} else {
				tongTien += (19 - 0.8) * GIA_TU_1_DEN_19_KM;
				tongTien += (soKmDaDi - 19) * GIA_TREN_19_KM;
			}
		}
		int tongThoiGianCho = (thoiGianCho / 3) * GIA_THOI_GIAN_CHO;
		return tongTien + tongThoiGianCho;
	}

	public static void inHoaDon(double soKmDaDi, int dongia, double thanhTien, int thoiGianCho, int phiThoiGianCho,
			double tongThanhToan, DecimalFormat formatMoney) {
		int width = 30;
		String leftAlignFormat = "| %-15s | %-12s %n";
		String title = "CHI TIẾT HÓA ĐƠN";

		String titleFormat = "| %" + (width - title.length()) / 2 + "s%s%" + (width - title.length()) / 2 + "s |%n";
		System.out.format("+--------------------------------+%n");
		System.out.format(titleFormat, "", title, "");
		System.out.format("+-----------------+--------------+%n");
		System.out.format("| Thông tin       | Chi tiết      |%n");
		System.out.format("+-----------------+--------------+%n");
		System.out.format(leftAlignFormat, "Số km đã đi", String.format("%.2f km", soKmDaDi));
		System.out.format(leftAlignFormat, "Đơn giá", String.format("%dđ/km", dongia));
		System.out.format(leftAlignFormat, "Thành tiền", formatMoney.format(thanhTien) + " VND");
		System.out.format(leftAlignFormat, "Thời gian chờ", thoiGianCho + " phút" + "(" + phiThoiGianCho + "đ/3 phút)");
		System.out.format(leftAlignFormat, "Tổng thanh toán", formatMoney.format(tongThanhToan) + " VND");
		System.out.format("+-----------------+--------------+%n");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Tạo mẫu định dạng số tiền
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");

		System.out.println("ĐẶT XE GRAB");
		System.out.println("Chọn 1 để đặt xe Grab Car");
		System.out.println("Chọn 2 để đặt xe Grab Suv");
		System.out.println("Chọn 3 để đặt xe Grab black");
		int chon;
		do {
			chon = inputIntNumber(in, "Chọn xe: ");
			if (chon < 1 || chon > 3) {
				System.out.println("Vui lòng chọn 1 trong 3 loại 1,2,3");
			}

		} while (chon < 1 || chon > 3);
		switch (chon) {
		case 1: {
			double soKmDaDi = inputDoubleNumber(in, "Nhập số km đi được: ");
			int thoiGianCho = inputIntNumber(in, "Nhập thời gian chờ: ");
			double thanhTien = thanhTien(soKmDaDi, 8000, 7500, 7000);
			double tongThanhToan = tongThanhToan(soKmDaDi, thoiGianCho, 8000, 7500, 7000, 2000);
			int dongia;
			if (soKmDaDi <= 0.8) {
				dongia = 8000;
			} else {
				if (soKmDaDi <= 19) {
					dongia = 7500;
				} else {
					dongia = 7000;
				}
			}
			inHoaDon(soKmDaDi, dongia, thanhTien, thoiGianCho, 2000, tongThanhToan, formatMoney);
			break;
		}
		case 2: {
			double soKmDaDi = inputDoubleNumber(in, "Nhập số km đi được: ");
			int thoiGianCho = inputIntNumber(in, "Nhập thời gian chờ: ");
			double thanhTien = thanhTien(soKmDaDi, 9000, 8500, 8000);
			double tongThanhToan = tongThanhToan(soKmDaDi, thoiGianCho, 9000, 8500, 8000, 3000);
			int dongia;
			if (soKmDaDi <= 0.8) {
				dongia = 9000;
			} else {
				if (soKmDaDi <= 19) {
					dongia = 8500;
				} else {
					dongia = 8000;
				}
			}
			inHoaDon(soKmDaDi, dongia, thanhTien, thoiGianCho, 3000, tongThanhToan, formatMoney);
			break;
		}
		case 3: {
			double soKmDaDi = inputDoubleNumber(in, "Nhập số km đi được: ");
			int thoiGianCho = inputIntNumber(in, "Nhập thời gian chờ: ");
			double thanhTien = thanhTien(soKmDaDi, 10000, 9500, 9000);
			double tongThanhToan = tongThanhToan(soKmDaDi, thoiGianCho, 10000, 9500, 9000, 3500);
			int dongia;
			if (soKmDaDi <= 0.8) {
				dongia = 10000;
			} else {
				if (soKmDaDi <= 19) {
					dongia = 9500;
				} else {
					dongia = 9000;
				}
			}
			inHoaDon(soKmDaDi, dongia, thanhTien, thoiGianCho, 3500, tongThanhToan, formatMoney);
			break;
		}
		}
		in.close();

//		Kết quả
//		ĐẶT XE GRAB
//		Chọn 1 để đặt xe Grab Car
//		Chọn 2 để đặt xe Grab Suv
//		Chọn 3 để đặt xe Grab black
//		Chọn xe: 2
//		Nhập số km đi được: 20
//		Nhập thời gian chờ: 12
//		+--------------------------------+
//		|        CHI TIẾT HÓA ĐƠN        |
//		+-----------------+--------------+
//		| Thông tin       | Chi tiết      |
//		+-----------------+--------------+
//		| Số km đã đi     | 20.00 km     
//		| Đơn giá         | 8000đ/km     
//		| Thành tiền      | 171,700 VND  
//		| Thời gian chờ   | 12 phút(3000đ/3 phút) 
//		| Tổng thanh toán | 183,700 VND  
//		+-----------------+--------------+

	}

}
