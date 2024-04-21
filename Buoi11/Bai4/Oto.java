package hello;

import java.util.Scanner;

public class Oto extends PhuongTienGiaoThong {
	private int soChoNgoi;
	private String kieuDongCo;

	public Oto() {

	}

	public Oto(String hangSanXuat, String tenPhuongTien, int namSanXuat, int vanTocToiDa, int soChoNgoi,
			String kieuDongCo) {
		super(hangSanXuat, tenPhuongTien, namSanXuat, vanTocToiDa);
		this.soChoNgoi = soChoNgoi;
		this.kieuDongCo = kieuDongCo;
	}

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

	public String getKieuDongCo() {
		return kieuDongCo;
	}

	public void setKieuDongCo(String kieuDongCo) {
		this.kieuDongCo = kieuDongCo;
	}

	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhập số chỗ ngồi: ");
		this.soChoNgoi = in.nextInt();
		in.nextLine();
		System.out.print("Nhập kiểu động cơ: ");
		this.kieuDongCo = in.nextLine();

	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Số chỗ  ngồi: " + getSoChoNgoi());
		System.out.println("Kiểu động cơ: " + getKieuDongCo());
		System.out.println();
	}

}
