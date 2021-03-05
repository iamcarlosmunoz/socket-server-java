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
      serverSocket = new ServerSocket(PORT);
      System.out.println("\nServidor escuchando en el puerto " + PORT);

      while (true) {
        clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado");

        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        String message = in.readUTF();
        System.out.println(message);

        out.writeUTF("¡Hello world from Server!");

        clientSocket.close();
        System.out.println("Cliente desconectado");

      }
    } catch (IOException ex) {
      System.out.println("\nServer exception: " + ex.getMessage());
      ex.printStackTrace();
    }

  }
}
