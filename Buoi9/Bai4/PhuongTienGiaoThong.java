package hello;

public class PhuongTienGiaoThong {
	private String hangSanXuat;
	private String mauSac;
	private int namSanXuat;

	public PhuongTienGiaoThong(String hangSanXuat, String mauSac, int namSanXuat) {
		this.hangSanXuat = hangSanXuat;
		this.mauSac = mauSac;
		this.namSanXuat = namSanXuat;
	}

	public void hienThiThongTin() {
		System.out.println("Hãng sản xuất: " + hangSanXuat);
		System.out.println("Màu sắc: " + mauSac);
		System.out.println("Năm sản xuất: " + namSanXuat);
	}

}
