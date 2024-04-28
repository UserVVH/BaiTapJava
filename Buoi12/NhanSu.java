package hello;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class NhanSu {
	private String maSo;
	private String hoTen;
	private String sdt;
	private int soNgayLamViec;
	private double luong1Ngay;

	public NhanSu() {

	}

	public int inputIntNumber(Scanner in) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(in.nextLine());
				if (number <= 0) {
					System.out.println("Bạn phải nhập lớn hơn 0");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào chữ số");
			}
		}
		return number;
	}

	public void nhap(List<NhanSu> nhanSuList) {
		Scanner in = new Scanner(System.in);
		this.maSo = kiemTra_MaSo_TonTai(in, nhanSuList);
		this.hoTen = checkString(in, "Nhập họ tên: ", "Họ tên không được phép bỏ trống,  hãy nhập lại");
		this.sdt = kiemTra_SDT_TonTai(in, nhanSuList);
		System.out.print("Nhập số ngày làm việc: ");
		this.soNgayLamViec = inputIntNumber(in);
	}

	public void xuat() {
		System.out.println("Mã số: " + getMaSo());
		System.out.println("Họ tên: " + getHoTen());
		System.out.println("Số điện thoại: " + getSdt());
		System.out.println("Số ngày làm việc: " + getSoNgayLamViec());
		System.out.println("Lương 1 ngày: " + dinhDangTien(getLuong1Ngay()) + " VNĐ");
	}

	public double tinhLuong() {
		return 0;
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	public String checkString(Scanner in, String message, String error) {
		String str = "";
		do {
			System.out.print(message);
			str = in.nextLine().trim();
			if (str.isEmpty()) {
				System.out.println(error);

			}
		} while (str.isEmpty());
		return str;

	}

	public String kiemTra_MaSo_TonTai(Scanner in, List<NhanSu> nhanSuList) {
		boolean maSoDaTonTai = false;
		System.out.print("Danh sách mã số nhân sự hiện có trong công ty: ");
		for (NhanSu nhanSu : nhanSuList) {
			System.out.print(nhanSu.getMaSo() + ", ");
		}
		System.out.println();
		String maSo = "";
		do {
			maSo = checkString(in, "Nhập mã số: ", "Mã số không được phép bỏ trống,  hãy nhập lại");
			maSoDaTonTai = false;
			for (NhanSu nhanSu : nhanSuList) {
				if (nhanSu.getMaSo().equals(maSo)) {
					maSoDaTonTai = true;
					break;
				}
			}
			if (maSoDaTonTai) {
				System.out.println("Mã số đã tồn tại, hãy nhập lại.");
			}
		} while (maSoDaTonTai || maSo.isEmpty());
		return maSo;

	}

	public String kiemTra_SDT_TonTai(Scanner in, List<NhanSu> nhanSuList) {
		boolean sdtDaTonTai = false;
		System.out.print("Danh sách số điện thoại nhân sự hiện có trong công ty: ");
		for (NhanSu nhanSu : nhanSuList) {
			System.out.print(nhanSu.getSdt() + ", ");
		}
		System.out.println();
		String sdt = "";
		do {
			sdt = checkString(in, "Nhập số điện thoại: ", "Số điện thoại không được phép bỏ trống,  hãy nhập lại");
			sdtDaTonTai = false;
			for (NhanSu nhanSu : nhanSuList) {
				if (nhanSu.getSdt().equals(sdt)) {
					sdtDaTonTai = true;
					break;
				}
			}
			if (sdtDaTonTai) {
				System.out.println("Số điện thoại đã tồn tại, hãy nhập lại.");
			}
		} while (sdtDaTonTai || sdt.isEmpty());
		return sdt;
	}

	// Getters and Setters
	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public double getLuong1Ngay() {
		return luong1Ngay;
	}

	public void setLuong1Ngay(double luong1Ngay) {
		this.luong1Ngay = luong1Ngay;
	}
	// Getters and Setters..end

}
