package hello;

import java.util.Scanner;

public class PhanSo {
	private double tuSo;
	private double mauSo;

	public PhanSo() {
		this.tuSo = 0;
		this.mauSo = 1;
	}

	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập tử số: ");
		this.tuSo = in.nextDouble();
		System.out.print("Nhập mẫu số: ");
		this.mauSo = in.nextDouble();
	}

	public void xuat() {
		System.out.println(this.tuSo + "/" + this.mauSo);
	}

	public PhanSo cong(PhanSo other) {
		double tuSoMoi = this.tuSo * other.mauSo + other.tuSo * this.mauSo;
		double mauSoMoi = this.mauSo * other.mauSo;
		PhanSo ps = new PhanSo();
		ps.setTuSo(tuSoMoi);
		ps.setMauSo(mauSoMoi);
		return ps;
	}

	public PhanSo tru(PhanSo other) {
		double tuSoMoi = this.tuSo * other.mauSo - other.tuSo * this.mauSo;
		double mauSoMoi = this.mauSo * other.mauSo;
		PhanSo ps = new PhanSo();
		ps.setTuSo(tuSoMoi);
		ps.setMauSo(mauSoMoi);
		return ps;
	}

	public PhanSo nhan(PhanSo other) {
		double tuSoMoi = this.tuSo * other.tuSo;
		double mauSoMoi = this.mauSo * other.mauSo;
		PhanSo ps = new PhanSo();
		ps.setTuSo(tuSoMoi);
		ps.setMauSo(mauSoMoi);
		return ps;
	}

	public PhanSo chia(PhanSo other) {
		double tuSoMoi = this.tuSo * other.mauSo;
		double mauSoMoi = this.mauSo * other.tuSo;
		PhanSo ps = new PhanSo();
		ps.setTuSo(tuSoMoi);
		ps.setMauSo(mauSoMoi);
		return ps;
	}

	public double getTuSo() {
		return tuSo;
	}

	public void setTuSo(double tuSo) {
		this.tuSo = tuSo;
	}

	public double getMauSo() {
		return mauSo;
	}

	public void setMauSo(double mauSo) {
		this.mauSo = mauSo;
	}

}
