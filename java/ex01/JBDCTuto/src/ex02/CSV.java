package ex02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {
	private File file;
	public CSV(File file) {
		this.file =file;
	}
	
	public ArrayList<String> readLine() {
		 ArrayList<String> res =new  ArrayList<String>();
		BufferedReader br = null;
		FileReader fr = null;
		if(this.file==null) {
			return res;
		}
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(this.file);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				res.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				

			} catch (IOException ex) {

				ex.printStackTrace();

			}
			return res;

		}
	}
	
	public ArrayList<ArrayList<String>> getElements(){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> csv = this.readLine();
		for(String line : csv) {
			String[] tmp = line.split(";");
			ArrayList<String> tmpArray = new ArrayList<String>();
			if(tmp.length>2) {
				tmpArray.add(tmp[1]);
				tmpArray.add(tmp[2]);
				res.add(tmpArray);
			}
		}
		
		return res;
		
	}

}
