package hello;

public class Main {

	public static void main(String[] args) {
		NhanVien nvvp = new NhanVienVanPhong();
		NhanVien nvsx = new NhanVienSanXuat();

		System.out.println("Nhập thông tin nhân viên văn phòng:");
		nvvp.nhap();
		nvvp.setLuong(nvvp.tinhLuong());
		nvvp.xuat();
		System.out.println();

		System.out.println("Nhập thông tin nhân viên sản xuất:");
		nvsx.nhap();
		nvsx.setLuong(nvsx.tinhLuong());
		nvsx.xuat();
	}
}
