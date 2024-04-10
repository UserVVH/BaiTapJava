package hello;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
	private List<SinhVien> students = new ArrayList<>();

	public void addStudent(SinhVien student) {
		students.add(student);
	}

	public SinhVien findStudentByName(String name) {
		for (SinhVien student : students) {
			if (student.getTen().equals(name)) {
				return student;
			}
		}
		return null;
	}

	public SinhVien findStudentById(String id) {
		for (SinhVien student : students) {
			if (student.getMaSV().equals(id)) {
				return student;
			}
		}
		return null;
	}

	public boolean removeStudentById(String id) {
		for (SinhVien student : students) {
			if (student.getMaSV().equals(id)) {
				students.remove(student);
				return true;
			}
		}
		return false;
	}

	public void displayAllStudents() {
		if (students.isEmpty()) {
			System.out.println("Danh sách sinh viên trống");
		} else {
			for (SinhVien student : students) {
				System.out.println(student);
			}
		}
	}

	public void displayWeakStudents() {
		boolean check = false;
		for (SinhVien student : students) {
			if (student.xepLoai().equals("Yếu")) {
				System.out.println(student);
				check = true;
			}
		}
		if (!check) {
			System.out.println("Không có sinh viên loại yếu");
		}
	}

	public void displayTopStudent() {
		if (students.isEmpty()) {
			System.out.println("Danh sách sinh viên trống");
		} else {
			SinhVien topStudent = students.get(0);
			for (SinhVien student : students) {
				if (student.diemTrungBinh() > topStudent.diemTrungBinh()) {
					topStudent = student;
				}
			}
			System.out.println("Sinh viên có điểm trung bình cao nhất:");
			for (SinhVien student : students) {
				if (student.diemTrungBinh() == topStudent.diemTrungBinh()) {
					System.out.println(student);
				}
			}
		}
	}
}
