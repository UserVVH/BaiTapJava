package hello;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Nhập thông tin xe");
		System.out.print("Nhập hãng sản xuất: ");
		String hangSanXuat = in.nextLine();
		System.out.print("Nhập màu sắc: ");
		String mauSac = in.nextLine();
		System.out.print("Nhập năm sản xuất: ");
		int namSanXuat = in.nextInt();
		XeHoi xe = new XeHoi(hangSanXuat, mauSac, namSanXuat);
		xe.inThongTin();
		in.close();

	}
}
