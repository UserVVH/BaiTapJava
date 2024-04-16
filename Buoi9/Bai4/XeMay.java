package hello;

import java.text.DecimalFormat;

public class XeMay extends PhuongTienGiaoThong {
	private String loaiXe;
	private double giaXe;

	public XeMay(String hangSanXuat, String mauSac, int namSanXuat, String loaiXe, double giaXe) {
		super(hangSanXuat, mauSac, namSanXuat);
		this.loaiXe = loaiXe;
		this.giaXe = giaXe;
	}

	public String dinhDangTien(double soTien) {
		DecimalFormat formatMoney = new DecimalFormat("#,###.##");
		return formatMoney.format(soTien);
	}

	@Override
	public void hienThiThongTin() {
		super.hienThiThongTin();
		System.out.println("Loại xe: " + loaiXe);
		System.out.println("Giá xe: " + dinhDangTien(giaXe) + " VNĐ");
	}

}
