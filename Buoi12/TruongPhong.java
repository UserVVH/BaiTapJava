package hello;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends NhanSu {

	private int soNhanVienDuoiQuyen = 0;

	public TruongPhong() {

	}

	public void nhap(List<NhanSu> nhanSuList) {
		System.out.println("Nhập thông tin trưởng phòng: ");
		super.nhap(nhanSuList);
		super.setLuong1Ngay(200000);
	}

	public void xuat() {
		System.out.println("\nThông tin trưởng phòng: ");
		super.xuat();
		System.out.println("Số nhân viên dưới quyền: " + getSoNhanVienDuoiQuyen());
		System.out.println("Lương tháng: " + super.dinhDangTien(tinhLuong()) + " VNĐ");

	}

	// Lấy ra danh sách mã số và tên trưởng phòng và thêm vào mảng danhSachMaSo
	public List<String> getThongTinTruongPhong(List<NhanSu> nhanSuList) {
		List<String> danhSachMaSo = new ArrayList<>();
		System.out.println("Danh sách trưởng phòng: ");
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof TruongPhong) {
				System.out.println("Mã số: " + nhanSu.getMaSo());
				System.out.println("Họ tên: " + nhanSu.getHoTen());
				danhSachMaSo.add(nhanSu.getMaSo());
			}
		}
		if (danhSachMaSo.isEmpty()) {
			System.out.println("Danh sách trưởng phòng trống");
		}
		return danhSachMaSo;
	}

	@Override
	public double tinhLuong() {
		return (super.getLuong1Ngay() * super.getSoNgayLamViec()) + (100000 * getSoNhanVienDuoiQuyen());
	}

	// lấy tên trưởng phòng
	public String getTenTruongPhong(List<NhanSu> nhanSuList, String maTruongPhong) {
		String hoTen = "null";
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof TruongPhong && nhanSu.getMaSo().equals(maTruongPhong)) {
				hoTen = nhanSu.getHoTen();
			}
		}
		return hoTen;
	}

	// lấy mã số trưởng phòng
	public String getMaTruongPhong(List<NhanSu> nhanSuList, String maTruongPhong) {
		String maSo = "null";
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof TruongPhong && nhanSu.getMaSo().equals(maTruongPhong)) {
				maSo = nhanSu.getMaSo();
			}
		}
		return maSo;
	}

	// Getter and Setter
	public int getSoNhanVienDuoiQuyen() {
		return soNhanVienDuoiQuyen;
	}

	public void setSoNhanVienDuoiQuyen(int soNhanVienDuoiQuyen) {
		this.soNhanVienDuoiQuyen = soNhanVienDuoiQuyen;
	}

}
