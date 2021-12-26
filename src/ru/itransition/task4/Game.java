package ru.itransition.task4;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		if (args.length <= 2 || (args.length % 2) == 0) {
			System.out.println("Sorry! You must enter the correct parameters for the game. You must enter diferent parameters. The number of parameters must be an odd number more than 2x. Example: rock, scissors, paper.");
		} else {
			HmacGenerator hmac = new HmacGenerator();
			 Key key = hmac.getKey();
			while (true) {
				int computerMoveNumber = (int)(Math.random() * args.length);
				String computerMove = args[computerMoveNumber];
				System.out.printf("HMAC: %02x%n", new BigInteger(1, hmac.getHmac(key, computerMove)));
				System.out.println("Available moves:");
				for (int i = 1; i < args.length + 1; i ++) {
					System.out.println(i + " - " + args[i - 1]);
				}
				System.out.println("0 - exit");
				System.out.println("? - help");
				System.out.println("You move: ");
				@SuppressWarnings("resource")
				Scanner move = new Scanner(System.in);
				String userMove = move.next();
				if (userMove.equals("0")) {
					break;
				} else if (userMove.equals("?")) {
					HelpSheet.GetHelp(args);	
				} else {
					System.out.println("Your move: " + args[Integer.parseInt(userMove)]);
					System.out.println("Computer move: " + computerMove);
					System.out.println(GameWinner.WinnerIs(userMove, computerMoveNumber, args.length));
					System.out.printf("HMAC Key: %02x%n", new BigInteger(1, key.getEncoded()));
				}
			}
		}
	}
}
