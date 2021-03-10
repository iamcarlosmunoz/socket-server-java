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
    final int OK = 200;
    final int NOT_BINARY = 400;

    try {
      // Created socket on port 5000
      serverSocket = new ServerSocket(PORT);
      System.out.println("\nServer listening on port " + PORT + "\n");

      // listening to clients
      while (true) {
        clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getLocalAddress());

        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        // Wait for client message
        int number = in.readInt();

        if (checkBinary(number)) {
          // Send status to client
          out.writeInt(OK);
          // Send decimal to client
          int decimal = calculateDecimal(number);
          out.writeInt(decimal);

          // Print numbers
          System.out.println("Status Code: " + OK + " OK");
          System.out.println("Number Received: " + number);
          System.out.println("Number Sent: " + decimal);
        } else {
          // Send status to client
          out.writeInt(NOT_BINARY);

          // Print Error
          System.out.println("Status Code: " + NOT_BINARY + " NOT_BINARY");
          System.out.println("Number Received: " + number);
        }

        // Close client connection
        clientSocket.close();
        System.out.println("Client disconnected\n");

      }
    } catch (IOException ex) {
      System.out.println("\nServer exception: " + ex.getMessage());
      ex.printStackTrace();
    }

  }

  private static int calculateDecimal(int binary) {
    int decimal = 0;
    int exponent = 0;
    int digit;
    while (binary > 0) {
      digit = binary % 10;
      decimal = decimal + digit * (int) Math.pow(2, exponent);
      binary /= 10;
      exponent++;
    }
    return decimal;
  }

  private static boolean checkBinary(int num) {
    int digit;
    while (num > 0) {
      digit = num % 10;
      if (digit != 0 && digit != 1)
        return false;
      num /= 10;
    }
    return true;
  }
}
