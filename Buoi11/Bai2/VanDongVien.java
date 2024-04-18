package hello;

import java.util.Scanner;

public class VanDongVien {
	private String hoTen;
	private int tuoi;
	private String monThiDau;
	private double chieuCao;
	private double canNang;

	public VanDongVien() {

	}

	public VanDongVien(String hoTen, int tuoi, String monThiDau, double chieuCao, double canNang) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.monThiDau = monThiDau;
		this.chieuCao = chieuCao;
		this.canNang = canNang;
	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		this.hoTen = in.nextLine();
		System.out.print("Nhập tuổi: ");
		this.tuoi = in.nextInt();
		System.out.print("Nhập chiều cao: ");
		this.chieuCao = in.nextDouble();
		System.out.print("Nhập cân nặng: ");
		this.canNang = in.nextDouble();

	}

	public void xuat() {
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Tuổi: " + getTuoi());
		System.out.println("Chiều cao: " + getChieuCao());
		System.out.println("Cân nặng: " + getCanNang());
	}

	public void soSanhVdv(VanDongVien other) {
		if (this.chieuCao > other.chieuCao) {
			System.out.println("VĐV " + this.hoTen + " cao hơn VĐV " + other.hoTen);
		} else if (this.chieuCao < other.chieuCao) {
			System.out.println("VĐV " + other.hoTen + " cao hơn VĐV " + this.hoTen);
		} else {
			if (this.canNang > other.canNang) {
				System.out.println("VĐV " + this.hoTen + " cao bằng VĐV " + other.hoTen + " nhưng nặng hơn");
			} else if (this.canNang < other.canNang) {
				System.out.println("VĐV " + other.hoTen + " cao bằng VĐV " + this.hoTen + " nhưng nặng hơn");
			} else {
				System.out.println("VĐV " + this.hoTen + " và VĐV " + other.hoTen + " có cùng chiều cao và cân nặng");
			}
		}
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getMonThiDau() {
		return monThiDau;
	}

	public void setMonThiDau(String monThiDau) {
		this.monThiDau = monThiDau;
	}

	public double getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}

	public double getCanNang() {
		return canNang;
	}

	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}

}
