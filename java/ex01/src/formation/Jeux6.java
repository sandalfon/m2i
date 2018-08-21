package formation;

import java.util.ArrayList;
import java.util.Collections;

public class Jeux6 {
	
	

	
	public static void compare(ArrayList<Integer> tirage,ArrayList<Integer> grid) {
		tirage.retainAll(grid);
		System.out.println("commun "+tirage.size()+ "  "+tirage);
	}
	
	public static void main(String args[]) {
		int max = 6;
		int maxVal= 50;
		ArrayList<Integer> tirage =Generator.generateArrayInt(max, maxVal);
		ArrayList<Integer> grid =Generator.generateArrayInt(max, maxVal);
		Collections.sort(tirage);
		Collections.sort(grid);
		System.out.println(tirage);
				System.out.println(grid);
				Jeux6.compare(tirage, grid);
	}
		

}
