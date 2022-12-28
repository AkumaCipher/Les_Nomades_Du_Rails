import java.util.Scanner;

import engine.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    // Defintion des joueurs de base 
    engine.Plateau p = new Plateau();
    engine.Joueur j0 = new Joueur("Bob",p.get_wagon_carte(),p.get_destination_carte());
    engine.Joueur j1 = new Joueur("John",p.get_wagon_carte(),p.get_destination_carte());

    // Creation nouvelle partie
    public void newPartie(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    
    @FXML
    private ImageView face1;
    @FXML
    private ImageView face2;
    @FXML
    private ImageView face3;
    @FXML
    private ImageView face4;
    @FXML
    private ImageView face5;

    Image f1 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(0).getLink());
    Image f2 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(1).getLink());
    Image f3 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(2).getLink());
    Image f4 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(3).getLink());
    Image f5 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(4).getLink());

    // Bouton debut de jeu 
    public void play(ActionEvent event) throws Exception{
        System.out.println("Partie commence");

        // Affichage carte wagon révélé
        face1.setImage(f1);
        face2.setImage(f2);
        face3.setImage(f3);
        face4.setImage(f4);
        face5.setImage(f5);

        // Au premier tour
        int tour = 0;
        /* 
        if (tour==0){
            System.out.println("    --- "+j0.getNom()+" ---");
            System.out.println(j0.getCartesDestination().toString());
            System.out.println(j0.getCartesWagon().toString()+"\n");
            Scanner lecteur = new Scanner(System.in);
            System.out.println(j0.getNom()+", quelle carte destination souhaitez vous rendre ? (1,2 ou 3)");
            j0.getCartesDestination().removeCarte(Integer.parseInt(lecteur.nextLine())-1);

            System.out.println("    --- "+j1.getNom()+" ---");
            System.out.println(j1.getCartesDestination().toString());
            System.out.println(j1.getCartesWagon().toString()+"\n");
            System.out.println(j1.getNom()+", quelle carte destination souhaitez vous rendre ? (1,2 ou 3)");
            j1.getCartesDestination().removeCarte(Integer.parseInt(lecteur.nextLine())-1);
            tour+=1;
        }
        */

    }

}
