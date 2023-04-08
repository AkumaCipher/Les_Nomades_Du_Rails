import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            System.out.println("Serveur en cours d'exécution...");
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket clientSocket1 = serverSocket.accept();
            System.out.println("Client 1 connecté.");
            OutputStream outputStream1 = clientSocket1.getOutputStream();

            Socket clientSocket2 = serverSocket.accept();
            System.out.println("Client 2 connecté.");
            OutputStream outputStream2 = clientSocket2.getOutputStream();

            // Envoyer le message "partie commence" aux deux clients
            outputStream1.write("partie commence\n".getBytes());
            outputStream1.flush();
            outputStream2.write("partie commence\n".getBytes());
            outputStream2.flush();

            // Fermer les connexions
            clientSocket1.close();
            clientSocket2.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}