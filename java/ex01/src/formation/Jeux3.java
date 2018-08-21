package formation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Jeux3 {

	public static HashMap<Integer, ArrayList<Integer>> oddEven(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> res = new HashMap<Integer, ArrayList<Integer>>();
		res.put(1, new ArrayList<Integer>());
		res.put(2, new ArrayList<Integer>());
		for (int i : arr) {
			if (i % 2 == 0) {

				res.get(2).add(i);
			} else {
				res.get(1).add(i);
			}
		}
		Collections.sort(res.get(2));
		Collections.sort(res.get(1));
		return res;

	}

	public static void main(String args[]) {
		int max = 20;
		int maxNb = 100;
		int[] arr = Jeux2.generateInt(max, maxNb);

		System.out.println(Arrays.toString(arr));

		System.out.println(Jeux3.oddEven(arr));
	}

}
