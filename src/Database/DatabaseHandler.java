package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
	Connection con;
	String databaseUrl = "localhost";
	String databasePort = "3306";
	String databaseName = "myDb";
	String databaseUser = "dev";
	String databasePass = "root";
	
	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mariadb://" + databaseUrl + ":"+ databasePort +"/"+ databaseName, databaseUser, databasePass);
		return con;
	}
}
