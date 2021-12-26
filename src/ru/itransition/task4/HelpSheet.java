package ru.itransition.task4;

public class HelpSheet {
	public static String GetHelp(String[] args) {
		String[][] winners = GameWinner.winners(args.length);	
		System.out.print("+");
		printDashes(args.length * 12);
		System.out.println("+");
		System.out.printf("|%6s |", "     ");
		for (int i = 0; i < args.length;i++) {
			System.out.printf("|%6s |", args[i]);
		}
		System.out.println("+");
		printDashes(args.length * 12);
		System.out.println("+");
		for (int i = 0; i < args.length; i++) {
			System.out.printf("|%6s |", args[i]);
			for(int j = 0; j < args.length; j++) {
				System.out.printf("|%6s |", winners[i][j]);
			}
			System.out.println("+");
			printDashes(args.length * 12);
			System.out.println("+");
		}
	return null;
	}
	private static void printDashes(int numberOfDashes) {
		for (int i = 0; i < numberOfDashes; i++) {
			System.out.print("-");
		}
	}
}
