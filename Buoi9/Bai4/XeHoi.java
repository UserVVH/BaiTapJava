package hello;

import java.text.DecimalFormat;

public class XeHoi extends PhuongTienGiaoThong {
	private String loaiXe;
	private int soCho;
	private double giaXe;

	public XeHoi(String hangSanXuat, String mauSac, int namSanXuat, String loaiXe, int soCho, double giaXe) {
		super(hangSanXuat, mauSac, namSanXuat);
		this.loaiXe = loaiXe;
		this.soCho = soCho;
		this.giaXe = giaXe;
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	@Override
	public void hienThiThongTin() {
		super.hienThiThongTin();
		System.out.println("loại Xe: " + loaiXe);
		System.out.println("Số chỗ: " + soCho);
		System.out.println("Giá xe: " + dinhDangTien(giaXe) + " VNĐ");
	}

}
