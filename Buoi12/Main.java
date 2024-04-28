package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CongTy congTy = new CongTy();
		QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
		int choice;
		do {
			System.out.println("╔══════════════════════════════════════════════════════╗");
			System.out.println("║                   QUẢN LÝ NHÂN SỰ                    ║");
			System.out.println("╠══════════════════════════════════════════════════════╣");
			System.out.println("║ 1. Nhập thông tin công ty                            ║");
			System.out.println("║ 2. Xuất thông tin công ty                            ║");
			System.out.println("║ 3. Nhập thông tin nhân sự                  	       ║");
			System.out.println("║ 4. Phân bổ Nhân viên vào Trưởng phòng      	       ║");
			System.out.println("║ 5. Xóa thông tin nhân sự                             ║");
			System.out.println("║ 6. Xuất ra thông tin toàn bộ nhân sự trong công ty   ║");
			System.out.println("║ 7. Tính và xuất tổng lương cho toàn công ty          ║");
			System.out.println("║ 8. Tìm Nhân viên thường có lương cao nhất            ║");
			System.out.println("║ 9. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền ║");
			System.out.println("║    nhiều nhất                                        ║");
			System.out.println("║ 10. Sắp xếp nhân sự toàn công ty theo thứ tự abc     ║");
			System.out.println("║ 11. Sắp xếp nhân sự toàn công ty theo thứ tự lương   ║");
			System.out.println("║    giảm dần                                          ║");
			System.out.println("║ 12. Tìm Giám Đốc có số lượng cổ phần nhiều nhất      ║");
			System.out.println("║ 13. Tính và xuất tổng thu nhập của từng Giám Đốc     ║");
			System.out.println("║ 0. Thoát                                             ║");
			System.out.println("╚══════════════════════════════════════════════════════╝");
			System.out.print("Nhập lựa chọn của bạn (0-13): ");
			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
			case 1:
				congTy.nhap();
				break;
			case 2:
				congTy.xuat();
				break;
			case 3:
				quanLyNhanSu.nhapThongTinNhanSu(in);
				break;
			case 4:
				quanLyNhanSu.phanBoNhanVienVaoTruongPhong();
				break;
			case 5:
				quanLyNhanSu.xoaThongTinNhanSu(in);
				break;
			case 6:
				quanLyNhanSu.xuatThongTinNhanSu();
				break;
			case 7:
				quanLyNhanSu.tongLuongNhanSu();
				break;
			case 8:
				quanLyNhanSu.timNhanVienLuongCaoNhat();
				break;
			case 9:
				quanLyNhanSu.timTruongPhongNhieuNhanVienNhat();
				break;
			case 10:
				quanLyNhanSu.sapXepNhanVienTheoABC();
				break;
			case 11:
				quanLyNhanSu.sapXepNhanVienTheoLuongGiamDan();
				break;
			case 12:
				quanLyNhanSu.timGiamDocCoNhieuCoPhanNhat();
				break;
			case 13:
				quanLyNhanSu.tongThuNhapCuaGiamDoc(congTy);
				break;
			case 0:
				System.out.println("Chương trình kết thúc.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
			if (choice != 0) {
				System.out.println("\nNhấn Enter để tiếp tục...");
				in.nextLine();
			}
		} while (choice != 0);
		in.close();
	}

}
