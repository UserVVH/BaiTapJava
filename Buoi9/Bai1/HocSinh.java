package hello;

public class HocSinh {
	private String ten;
	private int tuoi;
	private double diemToan;
	private double diemHoa;
	private double diemAnh;

	public HocSinh() {

	}

	public HocSinh(String ten, int tuoi, double diemToan, double diemHoa, double diemAnh) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.diemToan = diemToan;
		this.diemHoa = diemHoa;
		this.diemAnh = diemAnh;
	}

	public double diemTrungBinh() {
		return (diemToan + diemHoa + diemAnh) / 3;
	}

	public void inThongTin() {
		System.out.println("Tên học sinh: " + ten);
		System.out.println("Tuổi: " + tuoi);
		System.out.println("Điểm toán: " + diemToan);
		System.out.println("Điểm hóa: " + diemHoa);
		System.out.println("Điểm anh: " + diemAnh);
		System.out.printf("Điểm trung bình: %.2f", diemTrungBinh());
	}

}
