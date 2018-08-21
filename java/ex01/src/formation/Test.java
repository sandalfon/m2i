package formation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		double[] ti = new double[10];
		for (int i = 0; i < 10; i++) {
			ti[i] = Math.random() * i;
			System.out.println(a.getInfo() + " " + ti[i]);
		}

		int ii = 3;
		String s = (ii <= 3 ? (ii < 0 ? "neg" : "inf3") : "sup3");
		System.out.println(s);

		for (int i = 0; i < 5; i++) {
			a = new A();
		System.out.println(a.getId());
		}
	}
}
