package ex02;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class Run {
	
	
	public static void main(String[] args) throws SQLException {
		BDD bdd = new BDD("exo01","postgres","MyDb","eleves");
		CSV csv = new CSV(new File("DATA\\lestotos.txt"));
		bdd.start();
		for(ArrayList<String> elems : csv.getElements()) {
			String name = elems.get(0);
			int age = Integer.parseInt(elems.get(1));
			bdd.insert(name, age);
		}
		bdd.close();
	}

}
