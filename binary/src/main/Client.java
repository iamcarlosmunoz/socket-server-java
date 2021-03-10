package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {

    Socket clientSocket = null;
    DataInputStream in;
    DataOutputStream out;
    Scanner sc;

    final String HOST = "127.0.0.1"; // o localhost
    final int PORT = 5000;

    try {
      // Connect with server
      clientSocket = new Socket(HOST, PORT);
      System.out.println("\nConnected to the server");

      // initialize data entry
      sc = new Scanner(System.in);
      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());

<<<<<<< HEAD:isbn/src/main/Client.java
      // Get ISBN
      System.out.print("\nEnter ISBN (9 digit): ");
      String isbnNumber = sc.next();

      // Send ISBN (9 digit) to Server
      out.writeUTF(isbnNumber);
=======
      // Get number
      System.out.print("\nEnter binary number: ");
      int number = sc.nextInt();

      // Send number to Server
      out.writeInt(number);
>>>>>>> binary:binary/src/main/Client.java

      // Receive status from server
      int status = in.readInt();

      // Assess status
      if (status == 200) { // all ok
<<<<<<< HEAD:isbn/src/main/Client.java
        String ISBN = in.readUTF();
        System.out.println("Result: " + ISBN + "\n");
      } else if (status == 400) { // Bad response
        System.out.println("Error: number entered is wrong\n");
=======
        int decimal = in.readInt();
        System.out.println("Decimal: " + decimal + "\n");
      } else if (status == 400) { // Bad response = not binary
        System.out.println("Error: Number is NOT binary\n");
>>>>>>> binary:binary/src/main/Client.java
      }

      // disconnect socket
      clientSocket.close();
      sc.close();

    } catch (IOException ex) {
      System.out.println("\nClient exception: " + ex.getMessage());
      ex.printStackTrace();
    }

  }

}
