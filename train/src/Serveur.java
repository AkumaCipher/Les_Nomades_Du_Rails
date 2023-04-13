import java.io.*;
import java.net.*;

import engine.*;

public class Serveur extends Thread{

    private ServerSocket server;
    private Socket clientSocket1;
    private InputStream inputStream1;
    private OutputStream outputStream1;
    private Socket clientSocket2;
    private InputStream inputStream2;
    private OutputStream outputStream2;
    private int port ;
    engine.Plateau p = new Plateau();
    private String data = "";

    public Serveur(){
        this.port = 8080;
    }

    public void start() {
        try {
            System.out.println("Serveur en cours d'exécution...");
            server = new ServerSocket(this.port);

            clientSocket1 = server.accept();
            System.out.println("Client 1 connecté.");
            inputStream1 = clientSocket1.getInputStream();
            outputStream1 = clientSocket1.getOutputStream();

            outputStream1.write("Connecté\n".getBytes());
            outputStream1.flush();

            clientSocket2 = server.accept();
            System.out.println("Client 2 connecté.");
            inputStream2 = clientSocket2.getInputStream();
            outputStream2 = clientSocket2.getOutputStream();
            
            // Envoyer le message "partie commence" aux deux clients
            outputStream1.write("partie commence\n".getBytes());
            outputStream1.flush();

            outputStream2.write("partie commence\n".getBytes());
            outputStream2.flush();

            // Ecouter les messages envoyés par les clients
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream1));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

            String message;
            int count =0;
            String set = "";
            while (count<2) {

                // Lire le message du client 1
                message = reader1.readLine();
                if (message != null) {
                    System.out.println("Message du client 1 : " + message);
                    set+=message+"|";
                    count+=1;
                }

                // Lire le message du client 2
                message = reader2.readLine();
                if (message != null) {
                    System.out.println("Message du client 2 : " + message);
                    set+=message;
                    count+=1;
                }
                Thread.sleep(10);
            }
            System.out.println("Ca passe");
            outputStream1.write((set+"\n").getBytes());
            outputStream1.flush();

            outputStream2.write((set+"\n").getBytes());
            outputStream2.flush();

            String couleur = "";
            for (Carte carte : p.get_wagon_face().getPaquet()){
                couleur += carte.getCouleur() +",";
            }

            outputStream1.write((couleur+"\n").getBytes());
            outputStream1.flush();

            outputStream2.write((couleur+"\n").getBytes());
            outputStream2.flush();


            outputStream1.write(("1\n").getBytes());
            outputStream1.flush();

            System.out.println("Tour envoyé 1");

            outputStream2.write(("0\n").getBytes());
            outputStream2.flush();

            System.out.println("Tour envoyé 2");

            while(data.equals("fin")==false){

                // On attend le message de fin du premier joueur
                message = reader1.readLine();
                if (message != null) {
                    System.out.println("Message du client 1 : " + message);
                }
                data=message;

                clientSocket1 = server.accept();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() throws IOException{
        clientSocket1.close();
        clientSocket2.close();
        server.close();
    }

    public static void main(String[] args) {
        Serveur serveur = new Serveur();
        serveur.start();
    } 
}