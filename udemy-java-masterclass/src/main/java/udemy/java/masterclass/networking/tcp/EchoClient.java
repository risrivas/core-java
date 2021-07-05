package udemy.java.masterclass.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 5000);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)
        ) {
            socket.setSoTimeout(5000);
            String echoString, serverResponse;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();
                writer.println(echoString);

                if (!echoString.equals("exit")) {
                    serverResponse = reader.readLine();
                    System.out.println(serverResponse);
                }
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException ste) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
