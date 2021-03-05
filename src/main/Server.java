package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {

    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    DataInputStream in;
    DataOutputStream out;

    final int PORT = 5000;

    try {
      // Created socket on port 5000
      serverSocket = new ServerSocket(PORT);
      System.out.println("\nServidor escuchando en el puerto " + PORT);

      // listening to clients
      while (true) {
        clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado");

        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        // Wait for client message
        String message = in.readUTF();
        System.out.println(message);

        // Send message to client
        out.writeUTF("¡Hello world from Server!");

        // Close client connection
        clientSocket.close();
        System.out.println("Cliente desconectado");

      }
    } catch (IOException ex) {
      System.out.println("\nServer exception: " + ex.getMessage());
      ex.printStackTrace();
    }

  }
}
