package ru.itransition.task4;

class GameWinner {
	
	public static String WinnerIs(String userMove, int computerMoveNumber, int length) {
		String[][] winners = GameWinner.winners(length);
		int userMoveNumber = Integer.parseInt(userMove);
		String winner = "You " + winners[userMoveNumber][computerMoveNumber] + "!";
		return winner;	
	}
	public static String[][] winners(int length) {
		String[][] winners = new String[length][length];
		int move = (length - 1) / 2;
		int control = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					winners[i][j] = "draw";
				} else if ((control != ((length - 1) / 2)) && (j > i)) {
						winners[i][j] = "win";
						control++;
				} else if ((control != ((length - 1) / 2)) && ((i - move) > 0)) {
					winners[i][j] = "win";
					control++;
					move++;	
				} else {
					winners[i][j] = "lose";
				}
			}
			control = 0;
			move = (length - 1) / 2;
			}	
		return winners;
	}
}
	

