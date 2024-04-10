package hello;

public class SinhVien {
	String ten, maSV;
	double diemToan, diemmLy, diemHoa;

	public SinhVien() {
	}

	public SinhVien(String ten, String maSV, double diemToan, double diemmLy, double diemHoa) {
		this.ten = ten;
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemmLy = diemmLy;
		this.diemHoa = diemHoa;
	}

	public String getTen() {
		return ten;
	}

	public String getMaSV() {
		return maSV;
	}

	public double diemTrungBinh() {
		return (diemToan + diemmLy + diemHoa) / 3;
	}

	public String xepLoai() {
		double diemTrungBinh = diemTrungBinh();
		if (diemTrungBinh >= 9) {
			return "Xuất Sắc";
		} else if (diemTrungBinh >= 8 && diemTrungBinh < 9) {
			return "Giỏi";
		} else if (diemTrungBinh >= 7 && diemTrungBinh < 8) {
			return "Khá";
		} else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
			return "Trung bình";
		} else {
			return "Yếu";
		}
	}

	@Override
	public String toString() {
		return "Tên: " + ten + ", Mã SV: " + maSV + ", Điểm trung bình: " + String.format("%.2f", diemTrungBinh())
				+ ", Xếp loại: " + xepLoai();
	}

}
