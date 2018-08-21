package formation;

import java.util.ArrayList;

public class Generator {
	
	public static int[] generateInt(int max) {
		int[] arr = new int[max];
		for (int i = 0; i < max; i++)
			arr[i] = (int) Math.ceil(Math.random() * 10);
		return arr;

	}
	
	public static int[] generateInt(int max, int maxNb) {
		int[] arr = new int[max];
		for (int i = 0; i < max; i++)
			arr[i] = (int) Math.ceil(Math.random() * maxNb);
		return arr;

	}
	
	public static ArrayList<String> generateString(int max) {
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < max; i++)
			arr.add("toto"+i);
		return arr;

	}

	
	public static ArrayList<Integer> generateArrayInt(int max, int maxVal) {
		int count =0; 
		ArrayList<Integer> res = new ArrayList<Integer> ();
		while(count<= max*5 && res.size()<=max ) {
		 int val =	(int) Math.ceil(Math.random() * maxVal);
			if(!res.contains(val)) {
				res.add(val);
			}
		
				count++;
		}
		return res;

	}
}
