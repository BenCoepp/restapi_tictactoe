package restapi_tictactoe;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;

import Client.Client;
import Server.ServerHandler;

public class main {
	
	public static void main(String[] args) throws IOException {
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.start(6666);
    }
}
