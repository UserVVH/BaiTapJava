package hello;

public class XeHoi {
	private String hangSanXuat;
	private String mauSac;
	private int namSanXuat;

	public XeHoi() {

	}

	public XeHoi(String hangSanXuat, String mauSac, int namSanXuat) {
		this.hangSanXuat = hangSanXuat;
		this.mauSac = mauSac;
		this.namSanXuat = namSanXuat;
	}

	public void inThongTin() {
		System.out.println("Hãng sản xuất " + hangSanXuat);
		System.out.println("Màu sắc: " + mauSac);
		System.out.println("Năm sản xuất: " + namSanXuat);
	}

}
