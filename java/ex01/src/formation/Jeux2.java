package formation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Jeux2 {

	public static void main(String args[]) {
		int max = 20;

		int[] arr = Generator.generateInt(max);
		System.out.println(Arrays.toString(arr));
		HashMap<Integer, Integer> res = Jeux2.hashVersion(arr);
		System.out.println(res.toString());
		Scanner sc = new Scanner(System.in);
		int valeurSaisie = sc.nextInt();
		System.out.println(res.get(valeurSaisie));
		System.out.println(Jeux2.odd(arr).toString());
		Jeux2.minMax(arr);
	}



	public static HashMap<Integer, Integer> hashVersion(int[] arr) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (res.keySet().contains(i)) {
				res.put(i, res.get(i) + 1);
			} else {
				res.put(i, 1);
			}
		}

		return res;
	}
	
	public static HashMap<Integer,Integer> odd(int[] arr){
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		res.put(1,0);
		res.put(2,0);
		for (int i : arr) {
			if( i% 2==0){
				
				res.put(2, res.get(2) + 1);
			} else {
				res.put(1, res.get(1) + 1);
			}
		}
		return res;
	}
	
	public static void minMax(int[] arr) {
		Arrays.sort(arr);
		System.out.println(arr[0]);
		System.out.println(arr[arr.length-1]);
	}
}