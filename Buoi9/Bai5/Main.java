package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DieuHoa dieuHoa = new DieuHoa("Điều hòa Panasonic", 1500, true, 38);
		MaySay maySay = new MaySay("Máy sấy Electrolux", 2000, 80);

		System.out.println("Thông tin về điều hòa:");
		dieuHoa.hienThongTin();
		dieuHoa.bat();
		dieuHoa.giamNhietDo(23);
		dieuHoa.tat();
		System.out.println();

		System.out.println("Thông tin về máy sấy:");
		maySay.hienThongTin();
		maySay.bat();
		maySay.sayKho();
		maySay.tat();
		in.close();
	}
}
