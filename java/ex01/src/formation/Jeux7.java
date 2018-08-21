package formation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jeux7 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("entree phrase");
		String valeurSaisie = sc.nextLine();
		System.out.println("entree mot");
		String motSaisie = sc.nextLine();
		
		String[] splitStr = valeurSaisie.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

		Map<String, Integer> wordCount = new HashMap<>();
		for (String word: splitStr) {
		    if (wordCount.containsKey(word)) {
		        // Map already contains the word key. Just increment it's count by 1
		        wordCount.put(word, wordCount.get(word) + 1);
		    } else {
		        // Map doesn't have mapping for word. Add one with count = 1
		        wordCount.put(word, 1);
		    }
		}
		System.out.println("mot "+motSaisie+" est présent "+wordCount.get(motSaisie)+" fois");

	}

}
