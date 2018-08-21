package formation;

interface IFoot {

	String quelPoste();

}

public class Personne implements IFoot{

	@Override
	public String quelPoste() {
		
		return "Rouleur";
	}
	
	public String personneMethdode() {
		return "oulalala";
	}

}

class Run {
	public static void main(String[] args) {
		Personne p = new Personne();
		IFoot p2 = new Personne();

		System.out.println(p.personneMethdode());
		System.out.println(p2.quelPoste());
		
	}
}
