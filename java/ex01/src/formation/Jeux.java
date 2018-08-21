package formation;

import java.util.*;

class Jeux {
	int valeurSecrete = (int) Math.ceil(Math.random() * 100);
	int valeurSaisie;
	int i = 0;

	public void demanderValeur() {
		Scanner sc = new Scanner(System.in);
		this.valeurSaisie = sc.nextInt();
		
	}

	public void comparer() {
		System.out.println("Bonjour, nous allons jouer � un jeu, veuillez saisir un nombre entre 0 et 100");
		do{ 
			 demanderValeur();
			if (this.valeurSaisie < this.valeurSecrete) {
				System.out.println("C'est plus");
				;
			} else if (this.valeurSaisie > this.valeurSecrete) {
				System.out.println("C'est moins");
			} else {
				System.out.println("Bravo, vous avez trouv� en " + i + " coup(s)");
			}
			i++;
		}while (valeurSaisie != valeurSecrete && i < 10);
			System.out.println("Dommage vous avez perdu, le nombre � trouver �tait " + valeurSecrete);
	}



	public static void main(String[] args) {
		Jeux j = new Jeux();
		j.comparer();
	}
}