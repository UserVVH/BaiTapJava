package hello;

import java.util.Scanner;

public class GameChanLe {
	private long randomNumber;
	private boolean gameWon;

	public GameChanLe() {
	}

	public long getRandomNumber() {
		// Sử dụng thời gian Unix milliseconds làm số ngẫu nhiên
		randomNumber = System.currentTimeMillis();
		return randomNumber;
	}

	public void startGame() {
		System.out.println("Trò chơi chẵn lẻ");
		System.out.println(
				"Một số ngẫu nhiên sẽ được tạo ra. Bạn hãy đoán xem chữ số cuối cùng của nó là số chẵn hay số lẻ");
		System.out.println("Nhập 'C' cho số chẵn và 'L' cho số lẻ.");

		Scanner scanner = new Scanner(System.in);
		gameWon = false;

		while (!gameWon) {
			long random = getRandomNumber();
//		System.out.println(random);
			System.out.print("Nhập dự đoán của bạn C(chẵn) hoặc L(lẻ): ");
			String guess = scanner.nextLine().toUpperCase();

			// Kiểm tra xem người chơi có đoán đúng không
			int lastDigit = (int) (random % 10);
			boolean isEven = lastDigit % 2 == 0;
			boolean guessIsCorrect = (guess.equals("C") && isEven) || (guess.equals("L") && !isEven);

			if (guessIsCorrect) {
				gameWon = true;
				System.out.println("Chúc mừng bạn đã chiến thắng");
			} else {
				System.out.println("Bạn đã thua, hãy chơi lại");
			}
		}

		scanner.close();
	}
}
