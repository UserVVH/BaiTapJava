package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NhanVien {

	private String hoTen;
	private String ngaySinh;
	private double luong;

	public NhanVien(String hoTen, String ngaySinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}

	public NhanVien() {

	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		this.hoTen = in.nextLine();
		System.out.print("Nhập ngày sinh định dạng dd/mm/yyyy: ");
		this.ngaySinh = in.nextLine();
	}

	public void xuat() {
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Ngày sinh: " + getNgaySinh());
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	public double tinhLuong() {
		return 0;
	}

}
