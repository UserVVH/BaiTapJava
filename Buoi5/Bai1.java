package hello;

import java.util.Random;
import java.util.Scanner;

public class DemoBuoi6 {

	private static int inputNumber(Scanner in) {
		int number;
		while (true) {
			try {
				number = Integer.parseInt(in.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.print("Bạn phải nhập vào chữ số: ");
			}
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("*******************************");
		System.out.println("      Trò chơi Oẳn tù tì         ");
		System.out.println("Quy luật trò chơi: ");
		System.out.print("+ Kéo thắng Bao\n+ Bao thắng Búa\n+ Búa thắng Kéo\n");
		System.out.println("*******************************");

		String[] choices = { "kéo", "búa", "bao" };
		Random random = new Random();

		String chon;
		int scoreUser = 0;
		int scoreRobot = 0;
		int dungTroChoi;
		while (true) {
			// chọn ngẫu nhiên các giá trị trong mảng choices
			String randomChoice = choices[random.nextInt(choices.length)];
//			System.out.println(randomChoice);
			///////////////
			System.out.print("Mời bạn chọn Kéo/Búa/Bao: ");
			chon = in.nextLine().toLowerCase(); // chuyển giá trị người dùng nhập sang chữ thường
			switch (chon) {
			case "búa": {
				if (randomChoice.equals("kéo")) {
					System.out.println("Bạn đã chiến thắng");
					++scoreUser;
				} else if (randomChoice.equals("bao")) {
					System.out.println("Bạn đã thua");
					++scoreRobot;
				} else {
					System.out.println("Hòa");
				}
				break;
			}
			case "kéo": {
				if (randomChoice.equals("bao")) {
					System.out.println("Bạn đã chiến thắng");
					++scoreUser;
				} else if (randomChoice.equals("búa")) {
					System.out.println("Bạn đã thua");
					++scoreRobot;
				} else {
					System.out.println("Hòa");
				}
				break;
			}
			case "bao": {
				if (randomChoice.equals("búa")) {
					System.out.println("Bạn đã chiến thắng");
					++scoreUser;
				} else if (randomChoice.equals("kéo")) {
					System.out.println("Bạn đã thua");
					++scoreRobot;
				} else {
					System.out.println("Hòa");
				}
				break;
			}
			default:
				System.out.println("Bạn chỉ được nhập Kéo/Búa/Bao");
				continue;
			}
			System.out.println("Bạn có muốn tiếp tục trò chơi?");
			System.out.print("Nhập vào số khác 0 để tiếp tục hoặc 0 để dừng: ");
			dungTroChoi = inputNumber(in);
			if (dungTroChoi == 0) {
				break;
			}
		}
		System.out.printf("Kết quả: Bạn %d - Máy %d", scoreUser, scoreRobot);
		in.close();

	}

}
