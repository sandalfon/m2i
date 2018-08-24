package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDD {
	private String bd;
	private String login;
	private String pwd; 
	private String table;
	private Connection c=null;
	private Statement st=null;
	private PreparedStatement pst=null;
	
	
	public BDD(String bd, String login, String pwd, String table) {
		this.bd= bd;
		this.login = login;
		this.pwd = pwd;
		this.table=table;
	}
	
	
	public void start() {
		this.c = null;
        try {
           // charger le driver
           Class.forName("org.postgresql.Driver");
           // se connecter
           this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+this.bd,this.login ,this.pwd);
          
        
       } catch (Exception e) {
           e.printStackTrace();
       }
        
	}
	
	
	
	public void close() throws SQLException {
		if(this.st!=null) {
			this.st.close();
		}
		if(this.pst!=null) {
			this.pst.close();
		}
		if(this.c!=null) {
			this.c.close();
		}
	}
	
	
	public void insert(String name, int age) throws SQLException {
		this.pst = this.c.prepareStatement("INSERT INTO "+this.table+" (nom , age) VALUES (?,?)");
		this.pst.setObject(1, name);
		this.pst.setObject(2, age);
		this.pst.executeUpdate();
	}
	
	public ArrayList<ArrayList<String>> select() throws SQLException{
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		this.st = this.c.createStatement();
		  ResultSet rs = this.st.executeQuery("Select *  from "+this.table);
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();

		while(rs.next()) {
			ArrayList<String> tmp = new ArrayList<String>();
		    for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		        Object object = rs.getObject(columnIndex);
		        tmp.add(object.toString());
		    }
		    res.add(tmp);
		    
		}
		return res;
		
	}
	
	
}
