package ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class Run {

	public void read(String file) throws SQLException {
		BDD bdd = new BDD("exo01", "postgres", "MyDb", "eleves");
		CSV csv = new CSV(new File(file));
		bdd.start();
		for (ArrayList<String> elems : csv.getElements()) {
			String name = elems.get(0);
			int age = Integer.parseInt(elems.get(1));
			bdd.insert(name, age);
		}
		bdd.close();
	}

	private void write(String fileCopy) throws SQLException {
		BDD bdd = new BDD("exo01", "postgres", "MyDb", "eleves");
		CSV csv = new CSV(new File(fileCopy));
		bdd.start();
		csv.writeLine(bdd.select());
		bdd.close();

	}

	private void writeBoucle(String path) throws IOException, SQLException {
		Path dir = Paths.get(path);
		while (true) {
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) {
				for (Path aPath : stream) {
					File file = new File(aPath.toString());
					System.out.println(file);
					this.read(aPath.toString());
					if (file.delete()) {
						System.out.println(file.getName() + " is deleted!");
					} else {
						System.out.println("Delete operation is failed.");
					}
				}
			}
		}

	}

	public static void main(String[] args) throws SQLException, IOException {
		String file = "DATA\\lestotos.txt";
		String fileCopy = "DATA\\lestotosCOpy.txt";
		Run run = new Run();
		// run.read(file);
		// run.write(fileCopy);
		run.writeBoucle("DATA\\Boucle");
	}

}
