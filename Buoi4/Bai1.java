package hello;

import java.util.Scanner;

public class DemoBuoi4 {

	private static String nhapTen(Scanner sc) {
		System.out.print("Nhập tên: ");
		String ten = sc.nextLine();
		return ten;

	}

	private static int nhapTuoi(Scanner sc) {
		int namSinh;
		while (true) {
			try {
				System.out.print("Nhập năm sinh:");
				namSinh = Integer.parseInt(sc.nextLine());
				int check = 2024 - namSinh;
				if (check < 18 || namSinh < 0) {
					System.out.println("Vui lòng nhập năm sinh hợp lệ, sinh viên phải từ 18 tuổi");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập năm sinh hợp lệ, bạn phải nhập số nguyên.");
			}
		}
		return namSinh;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập thông tin sinh viên thứ nhất");
		String sv1Ten = nhapTen(sc);
		int sv1NamSinh = nhapTuoi(sc);

		System.out.println("Nhập thông tin sinh viên thứ hai");
		String sv2Ten = nhapTen(sc);
		int sv2NamSinh = nhapTuoi(sc);

		System.out.println("Nhập thông tin sinh viên thứ ba");
		String sv3Ten = nhapTen(sc);
		int sv3NamSinh = nhapTuoi(sc);

		String sinhVienTreNhat = sv1Ten;
		int namSinhTreNhat = sv1NamSinh;

		if (sv2NamSinh > namSinhTreNhat) {
			sinhVienTreNhat = sv2Ten;
			namSinhTreNhat = sv2NamSinh;
		}

		if (sv3NamSinh > namSinhTreNhat) {
			sinhVienTreNhat = sv3Ten;
			namSinhTreNhat = sv3NamSinh;
		}

		System.out.println("Sinh viên trẻ nhất là: " + sinhVienTreNhat);
		System.out.println("Năm sinh của sinh viên trẻ nhất là: " + namSinhTreNhat);
		sc.close();

	}

}
