package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập tên học sinh: ");
		String ten = in.nextLine();
		System.out.print("Nhập tuổi: ");
		int tuoi = in.nextInt();
		System.out.print("Nhập điểm toán: ");
		double diemToan = in.nextDouble();
		System.out.print("Nhập điểm hóa: ");
		double diemHoa = in.nextDouble();
		System.out.print("Nhập điểm anh: ");
		double diemAnh = in.nextDouble();
		HocSinh hs = new HocSinh(ten, tuoi, diemToan, diemHoa, diemAnh);
		hs.inThongTin();
		in.close();

	}
}
