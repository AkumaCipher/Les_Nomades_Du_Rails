import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = input.readLine();
            System.out.println("Message du serveur : " + serverMessage);

            input.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}