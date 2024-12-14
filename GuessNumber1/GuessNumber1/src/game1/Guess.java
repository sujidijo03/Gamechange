package game1;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {


		HashMap<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
		boolean playGame = true;
		while (playGame) {

		Random random = new Random();
		int secretNumber = random.nextInt(9999);
		String str = String.format("%04d", secretNumber);

		System.out.println("Enter your name");
		try (Scanner scanner = new Scanner(System.in)) {
			String name = scanner.nextLine();

			int count = 1;

			while(true) {

			System.out.println("Enter your Guess");
			String userGuess = scanner.nextLine();
			if(str.equals(userGuess)) break;

			for(int i=0; i<4; i++) {
			if(str.toCharArray()[i] == userGuess.toCharArray()[i])
			System.out.print('+');
			else
			System.out.print('-');
			}

			count++;
			}

			resultMap.put(name,count);
			System.out.print("Select 1 to continue the game, 2 to display the result,3 to exit");
			int number = scanner.nextInt();
			switch(number) {

			case 1:
			continue;
			case 2:
			printResult(resultMap);
			break;
			case 3:
			playGame = false;

			}
		}

		}



		}

		public static void printResult(Map<String, Integer> map)
		{
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer> > list
		   = new LinkedList<Map.Entry<String, Integer> >(
		   map.entrySet());
		// Sort the list using lambda expression
		Collections.sort(
		   list,
		   (i1,
		    i2) -> i1.getValue().compareTo(i2.getValue()));

		for (Map.Entry<String, Integer> object : list) {

		System.out.println(object.getKey() + " " + object.getValue());
		}

		}
		}



