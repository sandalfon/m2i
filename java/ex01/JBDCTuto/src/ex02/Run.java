package ex02;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class Run {
	
	
	public void read(String file) throws SQLException {
		BDD bdd = new BDD("exo01","postgres","MyDb","eleves");
		CSV csv = new CSV(new File(file));
		bdd.start();
		for(ArrayList<String> elems : csv.getElements()) {
			String name = elems.get(0);
			int age = Integer.parseInt(elems.get(1));
			bdd.insert(name, age);
		}
		bdd.close();
	}
	
	
	
	
	public static void main(String[] args) throws SQLException {
		String file="DATA\\lestotos.txt";
		String fileCopy="DATA\\lestotosCOpy.txt";
		Run run = new Run();
		//run.read(file);
		run.write(fileCopy);
	}

	private void write(String fileCopy) throws SQLException {
		BDD bdd = new BDD("exo01","postgres","MyDb","eleves");
		CSV csv = new CSV(new File(fileCopy));
		bdd.start();
		csv.writeLine(bdd.select());
		bdd.close();
		
	}

}
