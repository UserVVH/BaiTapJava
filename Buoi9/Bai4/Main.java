package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Chọn loại phương tiện:");
		System.out.println("1. Xe hơi");
		System.out.println("2. Xe máy");
		System.out.print("Nhập lựa chọn của bạn (1 hoặc 2): ");
		int choice = in.nextInt();
		in.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Nhập thông tin cho xe hơi:");
			System.out.print("Hãng sản xuất: ");
			String hangSanXuat = in.next();
			System.out.print("Màu sắc: ");
			String mauSac = in.next();
			System.out.print("Năm sản xuất: ");
			int namSanXuat = in.nextInt();
			in.nextLine();
			System.out.print("Loại xe: ");
			String loaiXe = in.nextLine();
			System.out.print("Số chỗ: ");
			int soCho = in.nextInt();
			in.nextLine();
			System.out.print("Giá xe: ");
			double giaXe = in.nextDouble();

			XeHoi xeHoi = new XeHoi(hangSanXuat, mauSac, namSanXuat, loaiXe, soCho, giaXe);
			System.out.println("\nThông tin của xe hơi");
			xeHoi.hienThiThongTin();
			break;
		case 2:
			System.out.println("Nhập thông tin cho xe máy:");
			System.out.print("Hãng sản xuất: ");
			hangSanXuat = in.nextLine();
			System.out.print("Màu sắc: ");
			mauSac = in.nextLine();
			System.out.print("Năm sản xuất: ");
			namSanXuat = in.nextInt();
			in.nextLine();
			System.out.print("Loại xe: ");
			loaiXe = in.nextLine();
			System.out.print("Giá xe: ");
			giaXe = in.nextDouble();

			XeMay xeMay = new XeMay(hangSanXuat, mauSac, namSanXuat, loaiXe, giaXe);
			System.out.println("\nThông tin của xe máy");
			xeMay.hienThiThongTin();
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ.");
			break;
		}
		in.close();
	}
}
