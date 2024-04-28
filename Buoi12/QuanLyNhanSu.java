package hello;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhanSu {
	private List<NhanSu> ds_nhanSu;

	public QuanLyNhanSu() {
		this.ds_nhanSu = new ArrayList<>();
	}

	// Thêm nhân viên mới vào danh sách
	public void addEmployee(NhanSu nhanSu) {
		ds_nhanSu.add(nhanSu);
	}

	// phân bổ nhân viên vào trưởng phòng
	public void phanBoNhanVienVaoTruongPhong() {
		NhanVien nhanVien = new NhanVien();
		nhanVien.phanBoNhanVienVaoTruongPhong(ds_nhanSu);
	}

	// Nhập thông tin nhân sự
	public void nhapThongTinNhanSu(Scanner in) {
		int chonNhanSu;
		do {
			System.out.println("\n--- LỰA CHỌN NHẬP THÔNG TIN NHÂN SỰ ---");
			System.out.println("1. Nhập thông tin nhân viên: ");
			System.out.println("2. Nhập thông tin Trưởng phòng: ");
			System.out.println("3. Nhập thông tin Giám đốc: ");
			System.out.println("0. Quay lại");
			System.out.print("Nhập lựa chọn của bạn: ");
			chonNhanSu = in.nextInt();
			in.nextLine();
			switch (chonNhanSu) {
			case 1:
				// nhập thông tin nhân viên
				NhanVien nhanVien = new NhanVien();
				nhanVien.nhap(getDs_nhanSu());
				addEmployee(nhanVien);
				break;
			case 2:
				// nhập thông tin trưởng phòng
				TruongPhong truongPhong = new TruongPhong();
				truongPhong.nhap(getDs_nhanSu());
				addEmployee(truongPhong);
				break;
			case 3:
				// nhập thông tin giám đốc
				GiamDoc giamDoc = new GiamDoc();
				giamDoc.nhap(getDs_nhanSu());
				addEmployee(giamDoc);
				break;
			case 0:
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		} while (chonNhanSu != 0);
	}

	// Xóa thông tin nhân sự
	public void xoaThongTinNhanSu(Scanner in) {
		String maNhanSu = "";
		int chonNhanSu;
		do {
			System.out.println("\n--- LỰA CHỌN XÓA THÔNG TIN NHÂN SỰ ---");
			System.out.println("1. Xóa thông tin Nhân viên");
			System.out.println("2. Xóa thông tin Trưởng phòng");
			System.out.println("3. Xóa thông tin Giám đốc");
			System.out.println("0. Quay lại");
			System.out.print("Nhập lựa chọn của bạn: ");
			chonNhanSu = in.nextInt();
			in.nextLine();
			switch (chonNhanSu) {
			case 1:
				// lấy ra thông tin nhân viên và kiểm tra mã nhập vào có trong danh sách nhân
				// viên
				NhanVien nv = new NhanVien();
				List<String> nhanVien_List = nv.getThongTinNhanVien(getDs_nhanSu());
				if (nhanVien_List.isEmpty()) {
					break;
				}
				System.out.print("Nhập mã nhân viên bạn muốn xóa: ");
				maNhanSu = in.nextLine().trim();
				if (!nhanVien_List.contains(maNhanSu)) {
					System.out.println("Mã nhân viên không tồn tại, hãy nhập lại");
				}

				// xóa thông tin nhân viên
				Iterator<NhanSu> iteratorNV = getDs_nhanSu().iterator();
				while (iteratorNV.hasNext()) {
					NhanSu nhanSu = iteratorNV.next();
					if (nhanSu instanceof NhanVien && nhanSu.getMaSo().equals(maNhanSu)) {
						// Cập nhật, giảm đi giá trị nhân viên dưới quyền của trưởng phòng khi nhân viên
						// đang có trưởng phòng quản lý
						NhanVien nhanVien = (NhanVien) nhanSu;
						String maTruongPhong = nhanVien.getMaTruongPhong();
						for (NhanSu tp : ds_nhanSu) {
							if (tp instanceof TruongPhong && tp.getMaSo().equals(maTruongPhong)) {
								TruongPhong truongPhong = (TruongPhong) tp;
								int nhanVienDuoiQuyen = truongPhong.getSoNhanVienDuoiQuyen();
								truongPhong.setSoNhanVienDuoiQuyen(nhanVienDuoiQuyen - 1);
								break;
							}
						}
						// Cập nhật, giảm đi giá trị nhân viên dưới quyền...end
						iteratorNV.remove();
						System.out.println("Đã xóa nhân viên có mã số: " + maNhanSu);
					}
				}
				break;
			case 2:
				// lấy ra thông tin trưởng phòng và kiểm tra mã nhập vào có trong danh sách
				// trưởng phòng
				TruongPhong truongPhong = new TruongPhong();
				List<String> truongPhong_List = truongPhong.getThongTinTruongPhong(getDs_nhanSu());
				if (truongPhong_List.isEmpty()) {
					break;
				}
				System.out.print("Nhập mã trưởng phòng bạn muốn xóa: ");
				maNhanSu = in.nextLine().trim();
				if (!truongPhong_List.contains(maNhanSu)) {
					System.out.println("Mã trưởng phòng không tồn tại, hãy nhập lại");
				}
				// xóa thông tin trưởng phòng
				Iterator<NhanSu> iteratorTP = getDs_nhanSu().iterator();
				while (iteratorTP.hasNext()) {
					NhanSu nhanSu = iteratorTP.next();
					if (nhanSu instanceof TruongPhong && nhanSu.getMaSo().equals(maNhanSu)) {
						iteratorTP.remove();
						System.out.println("Đã xóa trưởng phòng có mã số: " + maNhanSu);
					}
				}
				break;
			case 3:
				// lấy ra thông tin giám đốc và kiểm tra mã nhập vào có trong danh sách giám đốc
				GiamDoc giamDoc = new GiamDoc();
				List<String> giamDoc_List = giamDoc.getThongTinGiamDoc(getDs_nhanSu());
				if (giamDoc_List.isEmpty()) {
					break;
				}
				System.out.print("Nhập mã giám đốc bạn muốn xóa: ");
				maNhanSu = in.nextLine().trim();
				if (!giamDoc_List.contains(maNhanSu)) {
					System.out.println("Mã giám đốc không tồn tại, hãy nhập lại");
				}
				// xóa thông tin giám đốc
				Iterator<NhanSu> iteratorGD = getDs_nhanSu().iterator();
				while (iteratorGD.hasNext()) {
					NhanSu nhanSu = iteratorGD.next();
					if (nhanSu instanceof GiamDoc && nhanSu.getMaSo().equals(maNhanSu)) {
						iteratorGD.remove();
						System.out.println("Đã xóa giám đốc có mã số: " + maNhanSu);
					}
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		} while (chonNhanSu != 0);
	}

	// Hiển thị thông tin toàn bộ nhân viên
	public void xuatThongTinNhanSu() {
		if (ds_nhanSu.isEmpty()) {
			System.out.println("Công ty chưa có nhân sự hãy thêm vào nhân sự");
		}
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc) {
				GiamDoc giamDoc = (GiamDoc) nhanSu;
				giamDoc.xuat();
			} else if (nhanSu instanceof TruongPhong) {
				TruongPhong truongPhong = (TruongPhong) nhanSu;
				truongPhong.xuat();
			} else if (nhanSu instanceof NhanVien) {
				NhanVien nhanVien = (NhanVien) nhanSu;
				nhanVien.xuat(ds_nhanSu);
			}
		}
	}

	// In tổng lương toàn nhân sự trong công ty
	public void tongLuongNhanSu() {
		double tongLuong = 0;
		for (NhanSu nhanSu : ds_nhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		String tongLuongFormatted = dinhDangTien(tongLuong);
		System.out.println("Tổng lương nhân sự trong công ty là: " + tongLuongFormatted + " VNĐ");
	}

	// Tìm nhân viên thường có lương cao nhất
	public void timNhanVienLuongCaoNhat() {

		// kiểm tra nhân viên thường có trong danh sách nhân sự
		boolean check = false;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof NhanVien) {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("Công ty chưa có nhân viên, hãy thêm nhân viên");
			return;
		}

		// tìm ra giá trị lương cao nhất trong danh sách nhân viên thường
		double luongCaoNhat = 0;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof NhanVien && nhanSu.tinhLuong() > luongCaoNhat) {
				luongCaoNhat = nhanSu.tinhLuong();
			}
		}
		// in tất cả nhân viên thường có lương cao nhất
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof NhanVien && nhanSu.tinhLuong() == luongCaoNhat) {
				System.out.println("Nhân viên thường có lương cao nhất là: ");
				System.out.println("Mã số: " + nhanSu.getMaSo());
				System.out.println("Họ tên: " + nhanSu.getHoTen());
				System.out.println("Với số lương là: " + dinhDangTien(nhanSu.tinhLuong()) + " VNĐ");
			}
		}

	}

	// Tìm trưởng phòng có nhân viên dưới quyền nhiều nhất
	public void timTruongPhongNhieuNhanVienNhat() {
		// kiểm tra trưởng phòng có trong danh sách nhân sự
		boolean check = false;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof TruongPhong) {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("Công ty chưa có trưởng phòng, hãy thêm trưởng phòng");
			return;
		}

		// tìm ra số lượng nhân viên dưới quyền lớn nhất trong danh sách trưởng phòng
		int soNhanVienNhieuNhat = 0;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof TruongPhong
					&& ((TruongPhong) nhanSu).getSoNhanVienDuoiQuyen() > soNhanVienNhieuNhat) {
				soNhanVienNhieuNhat = ((TruongPhong) nhanSu).getSoNhanVienDuoiQuyen();
			}
		}

		// in thông tin của tất cả trưởng phòng có số nhân viên dưới
		// quyền nhiều nhất
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof TruongPhong
					&& ((TruongPhong) nhanSu).getSoNhanVienDuoiQuyen() == soNhanVienNhieuNhat) {
				System.out.println("Trưởng phòng có số nhân viên dưới quyền nhiều nhất là: ");
				System.out.println("Mã số: " + ((TruongPhong) nhanSu).getMaSo());
				System.out.println("Họ tên: " + ((TruongPhong) nhanSu).getHoTen());
				System.out.println("Số lượng nhân viên dưới quyền: " + ((TruongPhong) nhanSu).getSoNhanVienDuoiQuyen());
				System.out.println();
			}
		}
	}

	// Sắp xếp nhân sự theo thứ tự abc
	public void sapXepNhanVienTheoABC() {
		if (ds_nhanSu.isEmpty()) {
			System.out.println("Công ty chưa có nhân sự hãy thêm vào nhân sự");
		} else {
			// So sánh sắp xếp danh sách nhân sự theo thứ tự abc
			Collections.sort(ds_nhanSu, new Comparator<NhanSu>() {
				@Override
				public int compare(NhanSu ns1, NhanSu ns2) {
					return ns1.getHoTen().compareToIgnoreCase(ns2.getHoTen());
				}
			});

			// Xuất thông tin nhân sự sau khi đã sắp xếp
			xuatThongTinNhanSu();

		}
	}

	// Sắp xếp nhân sự theo lương giảm dần
	public void sapXepNhanVienTheoLuongGiamDan() {
		if (ds_nhanSu.isEmpty()) {
			System.out.println("Công ty chưa có nhân sự hãy thêm vào nhân sự");
		} else {
			// So sánh sắp xếp danh sách nhân sự theo lương giảm dần
			Collections.sort(ds_nhanSu, new Comparator<NhanSu>() {
				@Override
				public int compare(NhanSu ns1, NhanSu ns2) {
					// Đảo vị trí của ns1 và ns2 để sắp xếp giảm dần
					return Double.compare(ns2.tinhLuong(), ns1.tinhLuong());
				}
			});

			// Xuất thông tin nhân sự sau khi đã sắp xếp
			xuatThongTinNhanSu();
		}
	}

	// Tìm giám đốc có cổ phần nhiều nhất
	public void timGiamDocCoNhieuCoPhanNhat() {
		// kiểm tra giám đốc có trong danh sách nhân sự
		boolean check = false;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc) {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("Công ty chưa có giám đốc, hãy thêm vào giám đốc");
			return;
		}
		double coPhanNhieuNhat = 0;
		// tìm ra cổ phần nhiều nhất trong danh sách giám đốc
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc && ((GiamDoc) nhanSu).getSoCoPhan() > coPhanNhieuNhat) {
				coPhanNhieuNhat = ((GiamDoc) nhanSu).getSoCoPhan();
			}
		}

		// in thông tin của tất cả giám đốc có số cổ phần nhiều nhất
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc && ((GiamDoc) nhanSu).getSoCoPhan() == coPhanNhieuNhat) {
				String soCoPhan = String.format("%.2f", ((GiamDoc) nhanSu).getSoCoPhan()) + " %";
				System.out.println("Giám đốc có số cổ phần nhiều nhất là: ");
				System.out.println("Mã số: " + ((GiamDoc) nhanSu).getMaSo());
				System.out.println("Họ tên: " + ((GiamDoc) nhanSu).getHoTen());
				System.out.println("Số cổ phần: " + soCoPhan);
				System.out.println();
			}
		}
	}

	// xuất tổng thu nhập của các giám đốc
	public void tongThuNhapCuaGiamDoc(CongTy congTy) {
		// kiểm tra chưa có thông tin công ty
		if (congTy.getDoanhThuThang() == 0) {
			System.out.println("Công ty chưa có thông tin, hãy nhập thông tin cho công ty");
			return;
		}

		// kiểm tra trong danh sách nhân sự chưa có giám đốc
		boolean check = false;
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc) {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("Công ty chưa có giám đốc, hãy thêm vào giám đốc");
			return;
		}

		// tính tổng lương toàn nhân sự
		double tongLuong = 0;
		for (NhanSu nhanSu : ds_nhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		// xuất các thông tin và tổng thu nhập của giám đốc
		System.out.println("Tổng thu nhập của từng giám đốc là: ");
		for (NhanSu nhanSu : ds_nhanSu) {
			if (nhanSu instanceof GiamDoc) {
				GiamDoc giamDoc = (GiamDoc) nhanSu;
				System.out.println("Mã số: " + giamDoc.getMaSo());
				System.out.println("Họ tên: " + giamDoc.getHoTen());
				double loiNhuanCongTy = congTy.loiNhuanCongTy(tongLuong);

				// làm tròn số cổ phần
				double soCoPhan = giamDoc.getSoCoPhan();
				BigDecimal bd = new BigDecimal(soCoPhan).setScale(2, RoundingMode.HALF_UP);
				soCoPhan = bd.doubleValue();

				double tongThuNhap = giamDoc.tinhLuong() + (soCoPhan * loiNhuanCongTy);
				System.out.println("Tổng thu nhập: " + dinhDangTien(tongThuNhap) + " VNĐ");
				System.out.println();
			}
		}
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	// Getter and Setter
	public List<NhanSu> getDs_nhanSu() {
		return ds_nhanSu;
	}

	public void setDs_nhanSu(List<NhanSu> ds_nhanSu) {
		this.ds_nhanSu = ds_nhanSu;
	}

}
