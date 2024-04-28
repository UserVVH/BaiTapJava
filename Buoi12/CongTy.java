package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CongTy {
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;

	public CongTy() {

	}

	public CongTy(String tenCongTy, String maSoThue, double doanhThuThang) {
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập tên công ty: ");
		this.tenCongTy = in.nextLine().trim();
		System.out.print("Nhập mã số thuế: ");
		this.maSoThue = in.nextLine().trim();
		System.out.print("Nhập doanh thu tháng: ");
		this.doanhThuThang = in.nextDouble();
	}

	public void xuat() {
		System.out.println("Thông tin công ty: ");
		System.out.println("Tên công ty: " + getTenCongTy());
		System.out.println("Mã số thuế: " + getMaSoThue());
		System.out.println("Doanh thu tháng: " + dinhDangTien(getDoanhThuThang()) + " VNĐ");
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	public double loiNhuanCongTy(double tongLuongCongTy) {
		return this.doanhThuThang - tongLuongCongTy;
	}

	// Getter and Setter
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}
	// Getter and Setter..end

}
