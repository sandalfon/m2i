package formation;

import java.util.Arrays;
import java.util.Collections;

public class Jeux4 {
	
	
	public static void main(String args[]) {
		int max = 20;
		int maxNb = 100;
		int[] arr = Jeux2.generateInt(max, maxNb);

		System.out.println(Arrays.toString(arr));
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
	}
	
	
}
