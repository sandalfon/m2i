package formation;

import java.util.ArrayList;
import java.util.Collections;

public class Jeux9 {
	
	public static ArrayList<ArrayList<Integer>> split(ArrayList<Integer> arr){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
		Collections.sort(arr);
		int count =1;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int i : arr) {
			
			if(!(i > 10*(count-1) &&  i  < 10*count)) {
				res.add(tmp);
				count++;
				 tmp = new ArrayList<Integer>();
			}
			tmp.add(i);

		}
		
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = Generator.generateArrayInt(50, 100);
		System.out.println(Jeux9.split(arr));
	}
	

}
