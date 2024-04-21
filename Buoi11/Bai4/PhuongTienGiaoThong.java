package hello;

import java.util.Scanner;

public class PhuongTienGiaoThong {

	private String hangSanXuat;
	private String tenPhuongTien;
	private int namSanXuat;
	private int vanTocToiDa;

	public PhuongTienGiaoThong() {

	}

	public PhuongTienGiaoThong(String hangSanXuat, String tenPhuongTien, int namSanXuat, int vanTocToiDa) {
		this.hangSanXuat = hangSanXuat;
		this.tenPhuongTien = tenPhuongTien;
		this.namSanXuat = namSanXuat;
		this.vanTocToiDa = vanTocToiDa;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getTenPhuongTien() {
		return tenPhuongTien;
	}

	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public int getVanTocToiDa() {
		return vanTocToiDa;
	}

	public void setVanTocToiDa(int vanTocToiDa) {
		this.vanTocToiDa = vanTocToiDa;
	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập hãng sản xuất: ");
		this.hangSanXuat = in.nextLine();
		System.out.print("Nhập tên phương tiện: ");
		this.tenPhuongTien = in.nextLine();
		System.out.print("Nhập năm sản xuất: ");
		this.namSanXuat = in.nextInt();
		System.out.print("Nhập vận tốc tối đa: ");
		this.vanTocToiDa = in.nextInt();
	}

	public void xuat() {
		System.out.println("Hãng sản xuất: " + getHangSanXuat());
		System.out.println("Tên phương tiện: " + getTenPhuongTien());
		System.out.println("Năm sản xuất: " + getNamSanXuat());
		System.out.println("Vận tốc tối đa: " + getVanTocToiDa() + " km/h");
	}

	// So sánh 2 ô tô cùng vận tốc
	public boolean sameSpeed(PhuongTienGiaoThong phuongTienGiaoThong) {
		return this.vanTocToiDa == phuongTienGiaoThong.getVanTocToiDa();
	}

}
