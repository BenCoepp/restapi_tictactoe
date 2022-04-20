package Server;
import java.net.*;

import org.junit.Test;

import Client.Client;

import java.io.*;

public class Server extends Thread{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public Server (Socket socket) {
    	this.clientSocket = socket;
    }

    public void start() {
        try {
        	out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
              new InputStreamReader(clientSocket.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (".".equals(inputLine)) {
                    out.println("bye");
                    break;
                }
                out.println(inputLine);
            }

            in.close();
            out.close();
            clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}