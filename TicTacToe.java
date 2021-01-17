package TicTacToe;

import java.util.*;

public class TicTacToe {

	static ArrayList<Integer> playerpos = new ArrayList<Integer>();
	static ArrayList<Integer> cpupos = new ArrayList<Integer>();

	public static void BoardPos(char[][] gameBoard, int pos, String user) {
		char symbol = ' ';

		if (user.equals("Player")) {
			symbol = 'X';
			playerpos.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpupos.add(pos);
		}

		switch (pos) {

		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
		}

		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static String winning()

	{

		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List topCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List bottomCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(bottomRow);
		winningConditions.add(topCol);
		winningConditions.add(midCol);
		winningConditions.add(bottomCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for (List l : winningConditions) {
			if (playerpos.containsAll(l)) {
				 System.out.println();
				return ">> Congratulations! You won <<";

			} else if (cpupos.containsAll(l)) {
				System.out.println();
				return ">> CPU wins :( <<";
			}
		}

		if (playerpos.size() + cpupos.size() == 9) {
			return "Tie";
		}
		return "";
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int pos;

		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		System.out.println("Welcome to the TicTacToe by Shubham Soni");

		System.out.println();

		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}

		while (true) {
			
			String result = winning();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			System.out.println("Enter the position (1-9)");

			pos = scan.nextInt();

			while (playerpos.contains(playerpos) || cpupos.contains(playerpos)) {
				System.out.println("The position is already taken. Enter another one!");
				pos = scan.nextInt();
			}

			BoardPos(gameBoard, pos, "Player");

			Random rand = new Random();

			int cpuposi = rand.nextInt(9) + 1;

			while (cpupos.contains(cpupos) || playerpos.contains(cpuposi)) {
				
				cpuposi = rand.nextInt(9) + 1;
			}

			BoardPos(gameBoard, cpuposi, "cpu");

			
		}

	}
}