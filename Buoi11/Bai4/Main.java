package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<PhuongTienGiaoThong> ds_oto = new ArrayList<>();
		System.out.print("Nhập số lượng ô tô: ");
		int n = in.nextInt();
		for (int i = 0; i < n; ++i) {
			System.out.println("Nhập ô tô thứ " + (i + 1));
			Oto oto = new Oto();
			oto.nhap();
			ds_oto.add(oto);
		}
		System.out.println("\nThông tin các ô tô:");

		for (PhuongTienGiaoThong oto : ds_oto) {
			oto.xuat();
		}

		System.out.println("Các ô tô có cùng vận tốc:");
		for (int i = 0; i < ds_oto.size() - 1; ++i) {
			for (int j = i + 1; j < ds_oto.size(); ++j) {
				if (ds_oto.get(i).sameSpeed(ds_oto.get(j))) {
					ds_oto.get(i).xuat();
					ds_oto.get(j).xuat();
					System.out.println();
				}
			}
		}

	}
}
