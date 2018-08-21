package formation;

import java.util.Scanner;

public class Jeux8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("entree phrase");
		String valeurSaisie = sc.nextLine();
		String str="";
		for(int i=valeurSaisie.length()-1; i>=0; i--) {
			str= str+valeurSaisie.charAt(i);
		}
		System.out.println(str);
	}

}
