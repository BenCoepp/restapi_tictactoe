package restapi_tictactoe;

import java.io.IOException;

import Server.Server;

public class main {
	
    public static void main(String[] args) throws IOException {
        Server server=new Server();
        server.start(6666);
    }
}
