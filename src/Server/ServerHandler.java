package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerHandler {
	private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true)
            new Server(serverSocket.accept()).start();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}
