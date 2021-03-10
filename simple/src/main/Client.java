package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {

    Socket clientSocket = null;
    DataInputStream in;
    DataOutputStream out;

    final String HOST = "127.0.0.1"; // o localhost
    final int PORT = 5000;

    try {
      // Connect with server
      clientSocket = new Socket(HOST, PORT);

      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());

      // Send Message to server
      out.writeUTF("¡Hello World from client!");

      // Receive message from server
      String message = in.readUTF();
      System.out.println(message);

      // disconnect socket
      clientSocket.close();

    } catch (IOException ex) {
      System.out.println("\nClient exception: " + ex.getMessage());
      ex.printStackTrace();
    }

  }

}
