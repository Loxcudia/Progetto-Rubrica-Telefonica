package Model;
import java.sql.Statement;
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
	public static DBConnection getInstance()
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
	public ResultSet executeQuery(String query) throws SQLException
	{
		s = c.createStatement();
		return s.executeQuery(query);
	}
	public void execute(String query) throws SQLException
	{
		s = c.createStatement();
		s.execute(query);
	}
}
