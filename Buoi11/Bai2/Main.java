package hello;

public class Main {

	public static void main(String[] args) {
		VanDongVien vdv1 = new VanDongVien();
		VanDongVien vdv2 = new VanDongVien();

		System.out.println("Nhập thông tin vận động viên 1:");
		vdv1.nhap();
		System.out.println("\nNhập thông tin vận động viên 2:");
		vdv2.nhap();

		System.out.println("\nThông tin vận động viên 1:");
		vdv1.xuat();
		System.out.println("\nThông tin vận động viên 2:");
		vdv2.xuat();
		System.out.println();

		vdv1.soSanhVdv(vdv2);

	}
}
