package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiamDoc extends NhanSu {
	private double soCoPhan;

	public GiamDoc() {

	}

	public void nhap(List<NhanSu> nhanSuList) {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập thông tin giám đốc: ");
		super.nhap(nhanSuList);
		super.setLuong1Ngay(300000);
		do {
			System.out.print("Nhập số cổ phần: ");
			this.soCoPhan = in.nextDouble();
			if (getSoCoPhan() > 100 || getSoCoPhan() <= 0) {
				System.out.println("Số cổ phần phải 0 < số cổ phần < 100. Hãy nhập lại.");
			}

		} while (getSoCoPhan() > 100 || getSoCoPhan() <= 0);
	}

	public void xuat() {
		System.out.println("\nThông tin giám đốc: ");
		super.xuat();
		System.out.println("Lương tháng: " + super.dinhDangTien(tinhLuong()) + " VNĐ");
		System.out.println("Số cổ phần sở hữu: " + String.format("%.2f", getSoCoPhan()) + " %");
	}

	// Lấy ra danh sách mã số và tên giám đốc và thêm vào mảng danhSachMaSo
	public List<String> getThongTinGiamDoc(List<NhanSu> nhanSuList) {
		List<String> danhSachMaSo = new ArrayList<>();
		System.out.println("Danh sách giám đốc: ");
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof GiamDoc) {
				System.out.println("Mã số: " + nhanSu.getMaSo());
				System.out.println("Họ tên: " + nhanSu.getHoTen());
				danhSachMaSo.add(nhanSu.getMaSo());
			}
		}
		if (danhSachMaSo.isEmpty()) {
			System.out.println("Danh sách giám đốc trống");
		}
		return danhSachMaSo;
	}

	@Override
	public double tinhLuong() {
		return super.getLuong1Ngay() * super.getSoNgayLamViec();
	}

	public double getSoCoPhan() {
		return soCoPhan;
	}

	public void setSoCoPhan(double soCoPhan) {
		this.soCoPhan = soCoPhan;
	}

}
