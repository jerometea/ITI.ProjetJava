package logical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


public class BaseDeDonnees {
	
	private Connection con;
	
	
	public void getConnection(String pForname, String pDriverName,
			String pUserDataBase, String pPasswordDataBase) throws 
	ClassNotFoundException, SQLException{
		Class.forName(pForname);
		con = (Connection)
		DriverManager.getConnection(pDriverName,pUserDataBase,pPasswordDataBase);
	}
	
	public boolean logging (String pseudo, String password) throws SQLException, ParseException
	{
		PreparedStatement ps = con.prepareStatement("select * from admin where pseudo = ? AND mdp = ?");
		ps.setString(1, pseudo);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		rs.last();
		
		if (rs.getRow() > 0) return true;
		return false;
	}
}
