package formation;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeux5 {


	public static void find(ArrayList<String> arr, String key) {
		if(Math.random()<0.1) {
			System.out.println("MayBe");
		}
		else {
			if(arr.contains(key)) {
				System.out.println("found");
			}else {
				System.out.println("not found");
			}
		}
	}
	
	public static void main(String args[]) {
		int max = 200;
		ArrayList<String> arr =  Generator.generateString(max) ;
		System.out.println("entree valeur");
		Scanner sc = new Scanner(System.in);
		String valeurSaisie = sc.nextLine();
		Jeux5.find(arr,valeurSaisie);
		
	}
	
}
