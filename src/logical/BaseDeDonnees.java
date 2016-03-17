package logical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {
	
	private Connection con;
	
	
	public void getConnection(String pForname, String pDriverName,
			String pUserDataBase, String pPasswordDataBase) throws 
	ClassNotFoundException, SQLException{
		Class.forName(pForname);
		con = (Connection)
		DriverManager.getConnection(pDriverName,pUserDataBase,pPasswordDataBase);
	}
}
