package hello;

import java.util.Scanner;

public class Main {

	public static double inputNumber(Scanner in, String str) {
		double number;
		while (true) {
			System.out.print(str);
			try {
				number = Double.parseDouble(in.nextLine());
				if (number < 0 || number > 10) {
					System.out.println("Bạn phải nhập vào điểm từ 0-10");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào chữ số");
			}
		}
		return number;
	}

	public static double diemTrungBinh(double diemToan, double diemLy, double diemHoa) {
		return (diemToan + diemLy + diemHoa) / 3;
	}

	public static void xepLoai(double diemTrungBinh) {
		if (diemTrungBinh >= 9) {
			System.out.println("Đạt sinh viên loại xuất sắc");
		} else if (diemTrungBinh >= 8 && diemTrungBinh < 9) {
			System.out.println("Đạt sinh viên loại giỏi");
		} else if (diemTrungBinh >= 7 && diemTrungBinh < 8) {
			System.out.println("Đạt sinh viên loại khá");
		} else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
			System.out.println("Đạt sinh viên loại trung bình");
		} else {
			System.out.println("Đạt sinh viên loại yếu");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhập tên sv: ");
		String tenSV = in.nextLine();
		System.out.print("Nhập mã sv: ");
		String maSV = in.nextLine();
		double diemToan = inputNumber(in, "Nhập điểm toán: ");
		double diemLy = inputNumber(in, "Nhập điểm lý: ");
		double diemHoa = inputNumber(in, "Nhập điểm hóa: ");
		double diemTrungBinh = diemTrungBinh(diemToan, diemLy, diemHoa);
		System.out.printf("Sinh viên %s, mã sv %s, điểm trung bình %.2f %n", tenSV, maSV, diemTrungBinh);
		xepLoai(diemTrungBinh);
		in.close();

	}
}
