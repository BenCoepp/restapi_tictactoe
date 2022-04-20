package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
	
    public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("test");
        Client client1 = new Client();
        client1.startConnection("127.0.0.1", 6666);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage("{\"requestType\":\"STOP\"}");
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(terminate);
        Client client2 = new Client();
        client2.startConnection("127.0.0.1", 6666);
        String msgClient1 = client2.sendMessage("hello");
        String msgClient2 = client2.sendMessage("world");
        String terminateClient = client2.sendMessage("{\"requestType\":\"STOP\"}");
        System.out.println(msgClient1);
        System.out.println(msgClient2);
        System.out.println(terminateClient);
	}
    
}
