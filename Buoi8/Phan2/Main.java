package hello;

import java.util.Scanner;

public class Main {

	public static double inputDoubleNumber(Scanner in, String str) {
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

	public static int inputIntNumber(Scanner in) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(in.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Bạn phải nhập vào chữ số");
			}
		}
		return number;
	}

	// Hàm tạo dữ liệu giả
	private static void generateFakeData(StudentManagement management) {
		management.addStudent(new SinhVien("Nguyễn Văn A", "SV01", 8.8, 7.5, 9.9));
		management.addStudent(new SinhVien("Nguyễn Văn B", "SV02", 7.1, 8.9, 6.8));
		management.addStudent(new SinhVien("Nguyễn Văn C", "SV03", 6.5, 7.3, 5.5));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentManagement management = new StudentManagement();

		// Hàm tạo dữ liệu giả
		generateFakeData(management);

		int choice;
		do {
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Tìm sinh viên theo tên");
			System.out.println("3. Tìm sinh viên theo mã");
			System.out.println("4. Xóa sinh viên theo mã");
			System.out.println("5. Hiển thị tất cả sinh viên");
			System.out.println("6. Hiển thị sinh viên yếu");
			System.out.println("7. Hiển thị sinh viên có điểm trung bình cao nhất");
			System.out.println("0. Thoát");
			System.out.print("Chọn chức năng: ");
			choice = inputIntNumber(in);

			switch (choice) {
			case 1:
				System.out.print("Nhập tên: ");
				String ten = in.nextLine();
				System.out.print("Nhập mã SV: ");
				String maSV = in.nextLine();
				double diemToan = inputDoubleNumber(in, "Nhập điểm Toán: ");
				double diemLy = inputDoubleNumber(in, "Nhập điểm Lý: ");
				double diemHoa = inputDoubleNumber(in, "Nhập điểm Hóa: ");
				management.addStudent(new SinhVien(ten, maSV, diemToan, diemLy, diemHoa));
				break;
			case 2:
				System.out.print("Nhập tên sinh viên cần tìm: ");
				String searchName = in.nextLine();
				SinhVien foundByName = management.findStudentByName(searchName);
				if (foundByName != null) {
					System.out.println("Thông tin sinh viên:");
					System.out.println(foundByName);
				} else {
					System.out.println("Không tìm thấy sinh viên có tên " + searchName);
				}
				break;
			case 3:
				System.out.print("Nhập mã sinh viên cần tìm: ");
				String searchId = in.nextLine();
				SinhVien foundById = management.findStudentById(searchId);
				if (foundById != null) {
					System.out.println("Thông tin sinh viên:");
					System.out.println(foundById);
				} else {
					System.out.println("Không tìm thấy sinh viên có mã " + searchId);
				}
				break;
			case 4:
				System.out.print("Nhập mã sinh viên cần xóa: ");
				String deleteId = in.nextLine();
				boolean deleteStudent = management.removeStudentById(deleteId);
				if (deleteStudent) {
					System.out.println("Đã xóa sinh viên có mã " + deleteId);
				} else {
					System.out.println("Mã sinh viên không có trong danh sách sinh viên");
				}
				break;
			case 5:
				System.out.println("Danh sách sinh viên:");
				management.displayAllStudents();
				break;
			case 6:
				System.out.println("Danh sách sinh viên yếu:");
				management.displayWeakStudents();
				break;
			case 7:
				management.displayTopStudent();
				break;
			case 0:
				System.out.println("Kết thúc chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		} while (choice != 0);
		in.close();

	}
}
