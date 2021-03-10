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
    final int ERROR = 400;

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
        String number = in.readUTF();
        System.out.println(number.length());

        if (isISBN(number)) {
          // Send status to client
          out.writeInt(OK);
          // Send ISBN to client
          out.writeUTF(getCheckDigit(number));

          // Print numbers
          System.out.println("Status Code: " + OK + " OK");
          System.out.println("Number Received: " + number);
          System.out.println("Number Sent: " + getCheckDigit(number));
        } else {
          // Send status to client
          out.writeInt(ERROR);

          // Print Error
          System.out.println("Status Code: " + ERROR + " ERROR");
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

  public static boolean isISBN(String number) {
    try {
      if (number.length() != 9)
        return false;
      Integer.parseInt(number);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  public static String getCheckDigit(String number) {
    // declare variables
    int sum = 0;
    int digit = 0;
    int controlDigit = 0;
    char ch = '\0';

    // add upto 9th digit
    for (int i = 1; i <= 9; i++) {
      ch = number.charAt(i - 1);
      digit = Character.getNumericValue(ch);
      sum += (i * digit);
    }

    if ((sum / 11) < 10) {
      controlDigit = sum / 11;
      return number.concat(String.valueOf(controlDigit));
    }

    return String.valueOf(number.concat(String.valueOf("X")));
  }
}
