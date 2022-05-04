package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mariadb.jdbc.Driver;

public class DatabaseHandler {
	Connection con;
	String databaseUrl = "localhost";
	String databasePort = "3306";
	String databaseName = "myDb";
	String databaseUser = "dev";
	String databasePass = "root";
	
	public Connection getConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:mariadb://" + databaseUrl + ":"+ databasePort +"/"+ databaseName, databaseUser, databasePass);
		return con;
	}
	
	public boolean initDB() throws SQLException {
		con = getConnection();
		String sqlUser = "IF NOT EXISTS (SELECT * FROM sys.table WHERE NAME = 'USER' ) CREATE TABLE USER ("
				+ " userID int,"
				+ " userName varchar(255),"
				+ " password varchar(255),"
				+ ")";
		String sqlGame = "IF NOT EXISTS (SELECT * FROM sys.table WHERE NAME = 'GAME' ) CREATE TABLE GAME ("
				+ " gameID int,"
				+ " user1 int,"
				+ " user2 int,"
				+ " whoWon varchar(255),"
				+ " key varchar(255)"
				+ ")";
		try(PreparedStatement pStmt = con.prepareStatement(sqlGame)){
			if(!pStmt.execute()) {
				System.out.println("A problem has accured");
				return false;
			}
		}
		try(PreparedStatement pStmt = con.prepareStatement(sqlUser)){
			if(!pStmt.execute()) {
				System.out.println("A problem has accured");
				return false;
			}
		}
		return true;
	}
}
