package restapi_tictactoe;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import Client.Client;
import Database.DatabaseHandler;
import Server.ServerHandler;

public class main {
	
	public static void main(String[] args) throws IOException, SQLException {
		DatabaseHandler databaseHandler = new DatabaseHandler();
		Connection con = databaseHandler.getConnection();
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.start(6666);
    }
}
