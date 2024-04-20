package hello;

import java.util.Scanner;

public class NhanVienSanXuat extends NhanVien {

	private double luongCanBan;
	private int soSanPham;

	public NhanVienSanXuat() {

	}

	public NhanVienSanXuat(String hoTen, String ngaySinh, double luongCanBan, int soSanPham) {
		super(hoTen, ngaySinh);
		this.luongCanBan = luongCanBan;
		this.soSanPham = soSanPham;
	}

	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhập lương căn bản: ");
		this.luongCanBan = in.nextDouble();
		System.out.print("Nhập số sản phẩm: ");
		this.soSanPham = in.nextInt();
	}

	@Override
	public void xuat() {
		System.out.println("Thông tin nhân viên sản xuất:");
		super.xuat();
		System.out.println("Lương căn bản: " + super.dinhDangTien(this.luongCanBan) + " VNĐ");
		System.out.println("Số sản phẩm làm được: " + this.soSanPham);
		System.out.println("Tổng lương: " + super.dinhDangTien(super.getLuong()) + " VNĐ");
	}

	@Override
	public double tinhLuong() {
		return luongCanBan + (soSanPham * 5000);
	}

}
