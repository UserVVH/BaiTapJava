package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVien extends NhanSu {
	private TruongPhong truongPhong = new TruongPhong();
	private String maTruongPhong;

	public NhanVien() {

	}

	public NhanVien(String maSo, String hoTen, String sdt, int soNgayLamViec, double luong1Ngay) {
		super(maSo, hoTen, sdt, soNgayLamViec, luong1Ngay);
	}

	public void nhap(List<NhanSu> nhanSuList) {
		System.out.println("Nhập thông tin nhân viên: ");
		Scanner in = new Scanner(System.in);
		super.nhap(nhanSuList);
		super.setLuong1Ngay(100000);
		// xuất danh sách mã trưởng phòng hiện có
		List<String> danhSachMaSo = truongPhong.getThongTinTruongPhong(nhanSuList);
		System.out.println("Nhập mã số trưởng phòng quản lý. (Để trống nếu không có ai quản lý)");
		// kiểm tra và nhập mã số trưởng phòng quản lý
		do {
			System.out.print("Nhập mã số trưởng phòng: ");
			this.maTruongPhong = in.nextLine().trim();
			if (danhSachMaSo.contains(maTruongPhong) || maTruongPhong.equals("")) {
				break;
			} else {
				System.out.println("Mã số trưởng phòng không tồn tại, hãy nhập lại");
			}

		} while (!danhSachMaSo.contains(maTruongPhong));

		// tăng số nhân viên dưới quyền của trưởng phòng khi mã trưởng phòng quản lý đã
		// nhập
		// trùng với
		// mã trưởng phòng có trong danh sách
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof TruongPhong && nhanSu.getMaSo().equals(this.maTruongPhong)) {
				TruongPhong truongPhong = (TruongPhong) nhanSu;
				int nhanVienDuoiQuyen = truongPhong.getSoNhanVienDuoiQuyen();
				truongPhong.setSoNhanVienDuoiQuyen(nhanVienDuoiQuyen + 1);
			}
		}
	}

	// Xuất thông tin nhân viên
	public void xuat(List<NhanSu> nhanSuList) {
		System.out.println("\nThông tin nhân viên: ");
		super.xuat();
		System.out.println("Lương tháng: " + super.dinhDangTien(tinhLuong()) + " VNĐ");
		if (getMaTruongPhong().equals("")) {
			this.maTruongPhong = "null";
		}
		System.out.println("Mã trưởng phòng quản lý: " + truongPhong.getMaTruongPhong(nhanSuList, getMaTruongPhong()));
		System.out
				.println("Tên trưởng phòng quản lý: " + truongPhong.getTenTruongPhong(nhanSuList, getMaTruongPhong()));
	}

	// Lấy ra danh sách mã số và tên nhân viên và thêm vào mảng danhSachMaSo
	public List<String> getThongTinNhanVien(List<NhanSu> nhanSuList) {
		List<String> danhSachMaSo = new ArrayList<>();
		System.out.println("Danh sách nhân viên: ");
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof NhanVien) {
				System.out.println("Mã số: " + nhanSu.getMaSo());
				System.out.println("Họ tên: " + nhanSu.getHoTen());
				danhSachMaSo.add(nhanSu.getMaSo());
			}
		}
		if (danhSachMaSo.isEmpty()) {
			System.out.println("Danh sách nhân viên trống");
		}
		return danhSachMaSo;
		// Lấy ra danh sách mã số và tên nhân viên...end
	}

	// Phân bổ nhân viên vào trưởng phòng
	public void phanBoNhanVienVaoTruongPhong(List<NhanSu> nhanSuList) {
		Scanner in = new Scanner(System.in);
		// In ra danh sách mã số và tên nhân viên
		List<String> danhSachMaSo = getThongTinNhanVien(nhanSuList);
		if (danhSachMaSo.isEmpty()) {
			return;
		}
		// In ra danh sách mã số và tên nhân viên...end

		// kiểm tra và nhập mã số nhân viên phải trùng với mã số có trong danh sách
		String maSo = "";
		do {
			System.out.print("Nhập mã nhân viên muốn chuyển thành trưởng phòng: ");
			maSo = in.nextLine().trim();
			if (danhSachMaSo.contains(maSo)) {
				break;
			} else {
				System.out.println("Mã nhân viên không tồn tại, hãy nhập lại");
			}

		} while (!danhSachMaSo.contains(maSo));

		// logic code chuyển nhân viên sang trưởng phòng
		List<NhanSu> phaiThem = new ArrayList<>(); // Danh sách tạm thời
		List<NhanSu> phaiXoa = new ArrayList<>(); // Danh sách tạm thời
		for (NhanSu nhanSu : nhanSuList) {
			if (nhanSu instanceof NhanVien && nhanSu.getMaSo().equals(maSo)) {
				NhanVien nhanVien = (NhanVien) nhanSu;

				// Cập nhật, giảm đi giá trị nhân viên dưới quyền của trưởng phòng khi nhân viên
				// thường
				// đang có trưởng phòng quản lý muốn chuyển sang trưởng phòng
				String maTruongPhong = nhanVien.getMaTruongPhong();
				for (NhanSu tp : nhanSuList) {
					if (tp instanceof TruongPhong && tp.getMaSo().equals(maTruongPhong)) {
						TruongPhong truongPhong = (TruongPhong) tp;
						int nhanVienDuoiQuyen = truongPhong.getSoNhanVienDuoiQuyen();
						truongPhong.setSoNhanVienDuoiQuyen(nhanVienDuoiQuyen - 1);
						break;
					}
				}
				// Cập nhật, giảm đi giá trị nhân viên dưới quyền...end

				TruongPhong truongPhong = new TruongPhong();
				truongPhong.setMaSo(nhanVien.getMaSo());
				truongPhong.setHoTen(nhanVien.getHoTen());
				truongPhong.setSdt(nhanVien.getSdt());
				truongPhong.setSoNgayLamViec(nhanVien.getSoNgayLamViec());
				truongPhong.setSoNhanVienDuoiQuyen(0);
				truongPhong.setLuong1Ngay(200000);
				phaiThem.add(truongPhong); // Thêm vào danh sách tạm thời
				phaiXoa.add(nhanSu); // Xóa khỏi danh sách tạm thời
			}
		}
		nhanSuList.addAll(phaiThem); // Thêm tất cả vào danh sách chính
		nhanSuList.removeAll(phaiXoa); // Xóa tất cả khỏi danh sách chính
		System.out.println("Đã phân bổ nhân viên có mã " + maSo + " sang trưởng phòng");

	}

	@Override
	public double tinhLuong() {
		return super.getLuong1Ngay() * super.getSoNgayLamViec();
	}

	// Getters and Setters
	public String getMaTruongPhong() {
		return maTruongPhong;
	}

	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}

}
