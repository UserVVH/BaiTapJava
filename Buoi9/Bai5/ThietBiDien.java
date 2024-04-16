package hello;

public class ThietBiDien {
	private String ten;
	private int congSuat;

	public ThietBiDien(String ten, int congSuat) {
		this.ten = ten;
		this.congSuat = congSuat;
	}

	public void hienThongTin() {
		System.out.println("Tên: " + ten);
		System.out.println("Công suất: " + congSuat + " W");
	}
}
