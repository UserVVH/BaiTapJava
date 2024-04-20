package hello;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {
	private int soNgayLamViec;

	public NhanVienVanPhong() {

	}

	public NhanVienVanPhong(String hoTen, String ngaySinh, int soNgayLamViec) {
		super(hoTen, ngaySinh);
		this.soNgayLamViec = soNgayLamViec;
	}

	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhập số ngày làm việc: ");
		this.soNgayLamViec = in.nextInt();
	}

	@Override
	public void xuat() {
		System.out.println("Thông tin nhân viên văn phòng:");
		super.xuat();
		System.out.println("Số ngày làm việc: " + this.soNgayLamViec);
		System.out.println("Lương: " + super.dinhDangTien(super.getLuong()) + " VNĐ");
	}

	@Override
	public double tinhLuong() {
		return this.soNgayLamViec * 100000;
	}

}
