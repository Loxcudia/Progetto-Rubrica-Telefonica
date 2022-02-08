package Classi;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
	private Connection c;
	private Statement s;
	private ResultSet rs;
	private DBConnection()
	{
		
	}
	public DBConnection getInstance()
	{
		if(instance == null)
			instance = new DBConnection();
		return instance;
	}
	public void getConnection(String url, String username, String password) throws SQLException
	{
		c = DriverManager.getConnection(url, username, password);
	}
	public void closeConnection() throws SQLException
	{
		c.close();
	}
}
