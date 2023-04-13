import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import engine.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

// Controlleur de la Scene de jeu
public class MainSceneController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Defintion des joueurs de base 
    engine.Plateau p = new Plateau();
    engine.Joueur j0 =new Joueur();
    engine.Joueur j1 =new Joueur();

    engine.Joueur joueur = j0;
    int tour = 0;
    int win=0;

    // Page Acceuil
    @FXML 
    AnchorPane pageAcceuil ;

    // Page de jeu
    @FXML
    private AnchorPane rootPane;

    // Joueurs
    @FXML
    private ImageView joueur1;
    @FXML
    private ImageView joueur2;
    @FXML
    private Text nbwagon;

    // Carte wagon Joueur
    @FXML
    private BorderPane cartePane;
    @FXML
    private AnchorPane bottom;
    @FXML
    private ImageView carteW;
    @FXML
    private Text text1;
    @FXML 
    private ImageView closebutton;
    boolean elimine1 = false;
    boolean elimine2 = false;
    Map<String, Integer> dic = new HashMap<>();
    ArrayList<ImageView> listeW = new ArrayList<>();
    ArrayList<Text> listeT = new ArrayList<>();
    

    // Carte destination Joueur
    @FXML
    private AnchorPane cartePane2;
    @FXML
    private ImageView carteD;
    @FXML
    private ImageView destination1;
    @FXML
    private ImageView destination2;
    @FXML
    private ImageView destination3;
    @FXML
    private Text depart1;
    @FXML
    private Text depart2;
    @FXML
    private Text depart3;
    @FXML
    private Text point1;
    @FXML
    private Text point2;
    @FXML
    private Text point3;
    @FXML
    private Text arrive1;
    @FXML
    private Text arrive2;
    @FXML
    private Text arrive3;
    @FXML
    private Button conserveButton;
    @FXML
    private Button nextButton;
    int indiceD =0;
    int indice2 =0;


    // Carte wagon révélés
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

    // Jouer 
    @FXML
    private ImageView playButton;
    @FXML
    private AnchorPane IAPane;
    @FXML
    private Button piocheDestination;
    @FXML
    private Button piocheWagon;
    @FXML
    private Button jouerPlateau;
    @FXML
    private ImageView piocheCarteWagon;
    @FXML
    private AnchorPane piocheDestinationPane;
    @FXML
    private ImageView piocheD1;
    @FXML
    private Text piocheD1a;
    @FXML
    private Text piocheD1d;
    @FXML
    private Text piocheD1p;
    @FXML
    private ImageView piocheD2;
    @FXML
    private Text piocheD2a;
    @FXML
    private Text piocheD2d;
    @FXML
    private Text piocheD2p;
    @FXML
    private ImageView piocheD3;
    @FXML
    private Text piocheD3a;
    @FXML
    private Text piocheD3d;
    @FXML
    private Text piocheD3p;
    @FXML
    private Button piocheDButton;
    @FXML
    private Text piocheDText;
    @FXML
    private ImageView route1;
    @FXML
    private ImageView route10;
    @FXML
    private ImageView route11;
    @FXML
    private ImageView route12;
    @FXML
    private ImageView route13;
    @FXML
    private ImageView route14;
    @FXML
    private ImageView route15;
    @FXML
    private ImageView route16;
    @FXML
    private ImageView route17;
    @FXML
    private ImageView route18;
    @FXML
    private ImageView route19;
    @FXML
    private ImageView route2;
    @FXML
    private ImageView route20;
    @FXML
    private ImageView route21;
    @FXML
    private ImageView route22;
    @FXML
    private ImageView route23;
    @FXML
    private ImageView route24;
    @FXML
    private ImageView route25;
    @FXML
    private ImageView route26;
    @FXML
    private ImageView route27;
    @FXML
    private ImageView route28;
    @FXML
    private ImageView route29;
    @FXML
    private ImageView route3;
    @FXML
    private ImageView route30;
    @FXML
    private ImageView route31;
    @FXML
    private ImageView route32;
    @FXML
    private ImageView route33;
    @FXML
    private ImageView route34;
    @FXML
    private ImageView route35;
    @FXML
    private ImageView route36;
    @FXML
    private ImageView route37;
    @FXML
    private ImageView route38;
    @FXML
    private ImageView route4;
    @FXML
    private ImageView route5;
    @FXML
    private ImageView route6;
    @FXML
    private ImageView route7;
    @FXML
    private ImageView route8;
    @FXML
    private ImageView route9;
    @FXML
    private Text nom;
    @FXML
    private Text point;
    @FXML
    private Text nom2;
    @FXML
    private Text point_2;
    @FXML
    private AnchorPane EndPane;
    @FXML
    private Text wpiochej1;
    @FXML
    private Text wpiochej2;
    @FXML
    private Text wposej1;
    @FXML
    private Text wposej2;
    @FXML
    private Text tourj1;
    @FXML
    private Text tourj2;
    @FXML
    private Text vainqueur;
    @FXML
    private Text routej1;
    @FXML
    private Text routej2;
    @FXML
    private Text pointj1;
    @FXML
    private Text pointj2;
    @FXML
    private Text nomj1;
    @FXML
    private Text nomj2;
    @FXML
    private Text longj1;
    @FXML
    private Text longj2;
    @FXML
    private Text dratej1;
    @FXML
    private Text dratej2;
    @FXML
    private Text dreussij1;
    @FXML
    private Text dreussij2;
    @FXML
    private Text dpiochej1;
    @FXML
    private Text dpiochej2;
    @FXML
    private Text textIA;

    // Variable de base pour le jeu
    int piocheWagonCompte = 1000;
    PaquetCarte piocheList = new PaquetCarte(3,"Destination");
    public ArrayList<String> couleur = new ArrayList(Arrays.asList("blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"));
    ArrayList<Boolean> checkList = new ArrayList<>();
    boolean joueW = false;
    boolean joueD = false;
    boolean joueR = false;
    boolean last = false;
    boolean IA = false;
    boolean jouable = false;
    DropShadow dropShadow = new DropShadow();
    // Statistiques
    int piochewj1=0;
    int piochewj2=0;
    int piochedj1=0;
    int piochedj2=0;
    int toursj1 =0;
    int toursj2 =0;
    int routepj1=0;
    int routepj2=0;

    int start = -1;

    Image destination = new Image(".\\wagon\\cartedestination.png",100,150,true,true);

    // Creation nouvelle partie
    public void Start(String nom1,String nom2,String couleur1, String couleur2,boolean intelligence) throws Exception{
        dropShadow.setRadius(50.0);
        dropShadow.setColor(javafx.scene.paint.Color.GREEN);
        playButton.setEffect(dropShadow);
        for (Node n : rootPane.getChildren()){
            n.setOpacity(1);
        }
        IAPane.setOpacity(0);
        // IAPane.setBackground(background);

        if(intelligence == false){
            j0= new Joueur(nom1,couleur1,p.get_wagon_carte(),p.get_destination_carte());
            j1= new Joueur(nom2,couleur2,p.get_wagon_carte(),p.get_destination_carte());
        }else{
            j0= new Joueur(nom1,couleur1,p.get_wagon_carte(),p.get_destination_carte());
            j1= new Joueur(intelligence,p.get_wagon_carte(),p.get_destination_carte(),couleur1);
        }
        EndPane.setVisible(false);
    }

    // Creation nouvelle partie en ligne
    public void StartOnline(String nom1,String nom2,String couleur1, String couleur2,ArrayList<String> carteFace, Socket socket) throws Exception{
        dropShadow.setRadius(50.0);
        dropShadow.setColor(javafx.scene.paint.Color.GREEN);
        playButton.setEffect(dropShadow);
        for (Node n : rootPane.getChildren()){
            n.setOpacity(1);
        }
        IAPane.setOpacity(0);
        // IAPane.setBackground(background);
        j0= new Joueur(nom1,couleur1,p.get_wagon_carte(),p.get_destination_carte());
        j1= new Joueur(nom2,couleur2,p.get_wagon_carte(),p.get_destination_carte());
        EndPane.setVisible(false);
        
        Thread readThread = new Thread(() -> {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (start!=1) {
                    String message = input.readLine();
                    if (message == null) {
                        break;
                    }
                    start=Integer.parseInt(message);
                    System.out.println(message);
                }       
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        readThread.start();

        PaquetCarte paqueta = new PaquetCarte(5, new String("Wagon"));
        for (String carte : carteFace){
            if (carte.equals(new String("Destination"))){
                System.out.println("test");
            }else{
                paqueta.add(new WagonCarte(carte));
            }
        }
        System.out.println(paqueta);
        p.set_wagon_face(paqueta);

        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null);
        this.play(event);
        this.play(event);
    }



    // Quitter la partie en cours 
    public void exit(ScrollEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    // Renvoie le code hexadecimal de la couleur 
    public String getHexaColor(String couleur){
        String code = "";
        if (couleur.charAt(0)=='b' && couleur.charAt(2)=='a' ){
            code= "#FFFFFF";
        }else if (couleur.charAt(0)=='b' && couleur.charAt(2)=='e' ){
            code ="#0000FF";
        }else if (couleur.charAt(0)=='j' ){
            code ="#FFFF00";
        }else if (couleur.charAt(0)=='v' && couleur.charAt(1)=='e'){
            code ="#00FF00";
        }else if (couleur.charAt(0)=='r' ){
            code ="#FF0000";
        }else if (couleur.charAt(0)=='v' && couleur.charAt(1)=='i' ){
            code ="#EE82EE";
        }else if (couleur.charAt(0)=='o' ){
            code ="#FFA500";
        }else{
            code ="#000000";
        }
        return code;
    }

    public void trouveRoute(Plateau p,Joueur joueur,int num){
        if (num == 1) {
            route1.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route1.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        } else if (num == 2) {
            route2.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route2.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        } else if (num == 3) {
            route3.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route3.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }else if (num == 4) {
            route4.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route4.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        } else if (num == 5) {
            route5.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route5.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }else if (num == 6) {
            route6.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route6.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 7) {
            route7.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route7.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 8) {
            route8.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route8.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 9) {
            route9.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route9.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 10) {
            route10.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route10.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 11) {
            route11.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route11.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 12) {
            route12.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route12.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 13) {
            route13.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route13.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 14) {
            route14.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route14.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 15) {
            route15.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route15.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 16) {
            route16.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route16.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 17) {
            route17.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route17.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 18) {
            route18.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route18.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 19) {
            route19.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route19.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 20) {
            route20.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route20.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 21) {
            route21.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route21.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 22) {
            route22.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route22.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 23) {
            route23.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route23.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 24) {
            route24.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route24.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 25) {
            route25.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route25.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 26) {
            route26.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route26.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 27) {
            route27.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route27.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 28) {
            route28.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route28.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 29) {
            route29.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route29.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 30) {
            route30.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route30.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 31) {
            route31.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route31.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 32) {
            route32.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route32.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 33) {
            route33.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route33.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 34) {
            route34.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route34.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 35) {
            route35.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route35.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 36) {
            route36.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route36.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 37) {
            route37.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route37.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }if (num == 38) {
            route38.setImage(new Image(".\\wagon\\w" + p.get_route().get(num-1).getTaille() + "_" + joueur.getCouleur() + ".png"));
            route38.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");
            p.get_route().get(num-1).setProprietaire(joueur);
        }

    }

    public int[] besoinCouleur(Joueur j){
        int[] besoin = new int[8];
        for (Carte destination : joueur.getCartesDestination().getPaquet()){
            if(verifCarteDestination(destination.getVilleDestination()[0], destination.getVilleDestination()[1])==false){
                ArrayList<Ville> chemin = this.cheminCourt(joueur, destination.getVilleDestination()[0],destination.getVilleDestination()[1]);
                for (int i=0; i<chemin.size()-2; i++){
                    Route route_actuel = p.getOneRoute(chemin.get(i), chemin.get(i+1));
                    besoin[couleur.indexOf(route_actuel.getCouleur())]= route_actuel.getTaille();
                }
            }
        }for (int i=0; i<8; i++){
            besoin[i]=besoin[i]-joueur.getCartesWagon().nbcarte(couleur.get(i),joueur.getCartesWagon());
        }
        return besoin;
    }

    // Recuperation des prochaines images pour les wagons
    public void setupWagon(){

        // On recupere la liste des images prévus 
        int indice =0;
        for (Node n : bottom.getChildren()){
            if(n instanceof ImageView && indice!=0){
                listeW.add((ImageView)n);
            }
            indice+=1;
        }
        
        // On recupere la liste des textes pour les numero des cartes 
        for (Node n : bottom.getChildren()){
            if(n instanceof Text ){
                listeT.add((Text)n);
            }
        } 
    }

    // Bouton debut de tour
    public void play(MouseEvent event) throws Exception{

        if (start ==0){
            IAPane.setOpacity(1);
            IAPane.setVisible(true);
            textIA.setText("L'adversaire joue");
            System.out.println(start);
        }
        
        if (joueW==false && joueD==false && joueR==false && IA==false && jouable ==false){
            jouable=true;

            if (start == 1){
                System.out.println(start);
            }

            // Desactivation des effets 
            for (Node n : rootPane.getChildren()){
                n.setOpacity(1);
            }
            if (j1.getIA()){
                IAPane.setOpacity(0);
                playButton.setEffect(null);
                playButton.setOpacity(0.4);
            }

            // Carte a eliminer au premier tour 
            if (elimine1==false && tour==1 && joueur.equals(j0)){
                return;
            }else if(elimine2==false && tour==1 && joueur.equals(j1) && j1.getIA()== false){
                return;
            }

            // Options de jeu 
            if (elimine1==true && elimine2==true || elimine1==true && j1.getIA()){
                piocheDestination.setStyle("visibility:visible;");
                piocheWagon.setStyle("visibility:visible;");
                jouerPlateau.setStyle("visibility:visible;");
            }

            // Verification de la fin de jeu
            if (last==true){
                // Affichage panneau de fin de jeu 
                for (Node n : rootPane.getChildren()){
                    n.setOpacity(0.0);
                }
                EndPane.setOpacity(1.0);
                EndPane.setVisible(true);

                int reussij1=0;
                int reussij2=0;
                int echouej1=0;
                int echouej2=0;

                // Mis a jour des points carte destination
                for (Carte element :j0.getCartesDestination().getPaquet()){
                    if (this.verifCarteDestination(element.getVilleDestination()[0], element.getVilleDestination()[1])){
                        j0.addPoint(element.getPoint());
                        reussij1+=1;
                    }else{
                        j0.addPoint(-element.getPoint());
                        echouej1+=1;
                    }
                }
                for (Carte element :j1.getCartesDestination().getPaquet()){
                    if (this.verifCarteDestination(element.getVilleDestination()[0], element.getVilleDestination()[1])){
                        j1.addPoint(element.getPoint());
                        reussij2+=1;
                    }else{
                        j1.addPoint(-element.getPoint());
                        echouej2+=1;
                    }
                }

                if (cheminLong(j0)>cheminLong(j1)){
                    j0.addPoint(10);
                    longj1.setFill(Color.GREEN);
                }else if (cheminLong(j0)<cheminLong(j1)){
                    j1.addPoint(10);
                    longj2.setFill(Color.GREEN);
                }else{
                    j0.addPoint(10);
                    longj1.setFill(Color.GREEN);
                    j1.addPoint(10);
                    longj2.setFill(Color.GREEN);
                }
    
                nomj1.setText(j0.getNom());
                nomj2.setText(j1.getNom());
                tourj1.setText(toursj1+"");
                tourj2.setText(toursj2+"");
                dpiochej1.setText(piochedj1+"");
                dpiochej2.setText(piochedj2+"");
                wpiochej1.setText(piochewj1+"");
                wpiochej2.setText(piochewj2+"");
                routej1.setText(routepj1+"");
                routej2.setText(routepj2+"");
                wposej1.setText((45-j0.getWagons())+"");
                wposej2.setText((45-j1.getWagons())+"");
                longj1.setText(cheminLong(j0)+"");
                longj2.setText(cheminLong(j1)+"");
                pointj1.setText(j0.getPoint()+"");
                pointj2.setText(j1.getPoint()+"");
                dreussij1.setText(reussij1+"");
                dreussij2.setText(reussij2+"");
                dratej1.setText(echouej1+"");
                dratej2.setText(echouej2+"");
                

                // Vainqueur
                if (j0.getPoint()>j1.getPoint()){
                    vainqueur.setText(j0.getNom()+" a gagné !");
                    win=0;
                }else if (j1.getPoint()>j0.getPoint()){
                    vainqueur.setText(j1.getNom()+" a gagné !");
                    win=1;
                }else{
                    if (reussij1>reussij2){
                        vainqueur.setText(j0.getNom()+" a gagné !");
                        win=0;
                    }else if (reussij2>reussij1){
                        vainqueur.setText(j1.getNom()+" a gagné !");
                        win=1;
                    }else{
                        // Chemin le plus long
                    }
                }

                // Mise a jour de la base de donnée
                String json = new String(Files.readAllBytes(Paths.get("src/data.json")));
                JSONObject jsonObject = new JSONObject(json);
                JSONArray parties = jsonObject.getJSONArray("parties");

                JSONObject nouvellePartie = new JSONObject();
                nouvellePartie.put("id", parties.length() );
                nouvellePartie.put("date",LocalDate.now().toString() );
                nouvellePartie.put("win",win );

                JSONObject joueur1 = new JSONObject();
                joueur1.put("nom", j0.getNom());
                joueur1.put("score", j0.getPoint());
                joueur1.put("tours_joues", toursj1);
                joueur1.put("destinations_piochees", piochedj1);
                joueur1.put("wagons_pioches", piochewj1);
                joueur1.put("routes_prises", routepj1);
                joueur1.put("wagons_poses", 45-j0.getWagons());
                joueur1.put("destinations_reussies", reussij1);
                joueur1.put("destinations_ratees", echouej1);
                joueur1.put("chemin_plus_long", cheminLong(j0));

                JSONObject joueur2 = new JSONObject();
                joueur2.put("nom", j1.getNom());
                joueur2.put("score", j1.getPoint());
                joueur2.put("tours_joues", toursj2);
                joueur2.put("destinations_piochees", piochedj2);
                joueur2.put("wagons_pioches", piochewj2);
                joueur2.put("routes_prises", routepj2);
                joueur2.put("wagons_poses", 45-j1.getWagons());
                joueur2.put("destinations_reussies", reussij2);
                joueur2.put("destinations_ratees", echouej2);
                joueur2.put("chemin_plus_long", cheminLong(j1));

                nouvellePartie.put("joueur1", joueur1);
                nouvellePartie.put("joueur2", joueur2);

                // Ajout de la nouvelle partie dans le JSON
                parties.put(nouvellePartie);
                jsonObject.put("parties", parties);
                System.out.println(jsonObject);
                Files.write(Paths.get("src/data.json"), jsonObject.toString(4).getBytes());
            }

            else if (joueur.equals(j0) && j1.getWagons()<45){
                this.changeMessage("C'est le dernier tour");
                last=true;
            }else if (joueur.equals(j1) && j0.getWagons()<45){
                this.changeMessage("C'est le dernier tour");
                last=true;
            }

            // Initialisation des images et textes wagons
            if (tour==0){
                this.setupWagon();
            }// Sinon on ferme les fenetres ouvertes
            else{
                this.hideCardDestination(event);
                this.hideCardWagon(event);
            }

            // Changement de joueur et de tour
            if (j1.getIA()){
                IA = true ;
                joueur=j0;
                toursj2+=1;
                tour+=1;
            }else{
                if(joueur.equals(j0) && tour!=0){
                    joueur=j1;
                    toursj2+=1;
                }else{
                    joueur=j0;
                    tour+=1;
                    toursj1+=1;
                }
            }

            if (tour==1){
                text1.setStyle("visibility : visible;-fx-text-alignment:center;");
                this.changeMessage("Retirez une carte Destination ou conservez");
            }else{
                this.changeMessage("Choisissez votre action pour ce tour");
            }

            // Affichage carte wagon révélé
            this.setFace();

            // Affichage nombre wagon du joueur
            nbwagon.setText(Integer.toString(joueur.getWagons()));

            // Affichage des joueurs actuels 
            if (joueur.equals(j0)){
                joueur2.setStyle("-fx-opacity:0.4;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j1.getCouleur())+", 40, 0.5, 0, 0);");
                joueur1.setStyle("-fx-opacity:1;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j0.getCouleur())+", 40, 0.5, 0, 0);");
            }else{
                joueur1.setStyle("-fx-opacity:0.4;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j0.getCouleur())+", 40, 0.5, 0, 0);");
                joueur2.setStyle("-fx-opacity:1;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j1.getCouleur())+", 40, 0.5, 0, 0);");
            }

            // Affichage statistiques joueurs
            nom.setText(j0.getNom());
            point.setText(Integer.toString(j0.getPoint())+" points");
            nom2.setText(j1.getNom());
            point_2.setText(Integer.toString(j1.getPoint())+" points");
            }
        // Tour de l'IA
        else if (joueW==false && joueD==false && joueR==false && IA==true && jouable == false){
            System.out.println("Tour de l'IA");
            joueur=j1;
            toursj1+=1;
            IA=false;
            joueur1.setStyle("-fx-opacity:0.4;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j0.getCouleur())+", 40, 0.5, 0, 0);");
            joueur2.setStyle("-fx-opacity:1;-fx-effect: innershadow(gaussian, "+this.getHexaColor(j1.getCouleur())+", 40, 0.5, 0, 0);");
            if (tour==1){
                int max =0;
                int id =0;
                int id2 =0;
                for (Carte destination : joueur.getCartesDestination().getPaquet()){
                    if (destination.getPoint()>max){
                        max = destination.getPoint();
                        id2=id;
                    }
                    id+=1;
                }
                joueur.getCartesDestination().removeCarte(id2);
            }
            String resultat = evaluation(joueur);
            for (Node n : rootPane.getChildren()){
                n.setOpacity(0.5);
            }
            this.hideCardDestination(event);
            this.hideCardWagon(event);
            playButton.setOpacity(1.0);
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(50.0);
            dropShadow.setColor(javafx.scene.paint.Color.YELLOWGREEN);
            playButton.setEffect(dropShadow);
            IAPane.setOpacity(1);
            if (resultat.charAt(0)=='D'){
                this.changeMessageIA("L'IA pioche une carte destination");
            }if (resultat.charAt(0)=='W'){
                this.changeMessageIA("L'IA pioche des cartes wagon");
            }if (resultat.charAt(0)=='R'){
                this.changeMessageIA("L'IA a pris une route");
            }
        }
    }

    // Affichage des cartes wagon du joueur
    public void showCardWagon(MouseEvent event)throws Exception{
        if (tour!=0){  
            this.setdic();

            // On rempli les images par les cartes a afficher
            int indiceImage =0;
            for (int i=0;i<joueur.getCartesWagon().couleur.size();i++){
                if (dic.get(joueur.getCartesWagon().couleur.get(i)) != null){
                    Image img = new Image(".\\wagon\\"+joueur.getCartesWagon().couleur.get(i)+".png",100,150,true,true);
                    listeW.get(indiceImage).setImage(img);
                    // Nombre d'exemplaire de la carte
                    if (dic.get(joueur.getCartesWagon().couleur.get(i))>1){
                        listeT.get(indiceImage).setText(Integer.toString(dic.get(joueur.getCartesWagon().couleur.get(i))));
                    }
                    indiceImage+=1;
                }
            }
            // On rajoute le joker si present
            if (dic.get("joker") != null){
                Image img = new Image(".\\wagon\\joker.png",100,150,true,true);
                listeW.get(indiceImage).setImage(img);
                // Nombre de joker 
                if (dic.get("joker") > 1){
                    listeT.get(indiceImage).setText(Integer.toString(dic.get("joker")));
                }
            }

            // Affichage de chaque carte
            carteW.setVisible(false);
            bottom.setStyle("visibility:visible;-fx-background-color:white;-fx-background-image:url('./design/fond2.jpg');");

        } 
    }

    // Cacher les cartes wagon
    public void hideCardWagon(MouseEvent event)throws Exception{
        // nettoyage des images et textes precedents
        for (ImageView image : listeW){
            image.setImage(null);
        }
        for (Text texte : listeT){
            texte.setText(null);
        }
        dic.clear();
        bottom.setStyle("visibility:hidden;");
        carteW.setVisible(true);
    }

    // Affichage carte destination 
    public void showCardDestination(MouseEvent event)throws Exception{
        // Nettoyer l'affichage
        indiceD=0;
        face1.setVisible(false);
        face2.setVisible(false);
        face3.setVisible(false);
        face4.setVisible(false);
        face5.setVisible(false);
        cartePane2.setVisible(true);
        carteD.setVisible(false);
        // Image et texte des cartes mis a jour
        if (tour==1 && joueur.equals(j0) && elimine1==false){
            conserveButton.setStyle("visibility:visible;");
        }else if (tour==1 && joueur.equals(j1) && elimine2==false){
            conserveButton.setStyle("visibility:visible;");
        }else{
            conserveButton.setStyle("visibility:hidden;");
        }
        int taille = joueur.getCartesDestination().getPaquet().size();

        // Calcul des points et remplissage de la carte
        destination1.setImage(destination);
        depart1.setText(joueur.getCartesDestination().getCarte(0).getDepart());
        point1.setText(joueur.getCartesDestination().getCarte(0).getPoint()+"");
        arrive1.setText(joueur.getCartesDestination().getCarte(0).getArrive());
        if (taille>=2){
            destination2.setImage(destination);
            depart2.setText(joueur.getCartesDestination().getCarte(1).getDepart());
            point2.setText(joueur.getCartesDestination().getCarte(1).getPoint()+"");
            arrive2.setText(joueur.getCartesDestination().getCarte(1).getArrive());
        }if (taille>=3){
            destination3.setImage(destination);
            depart3.setText(joueur.getCartesDestination().getCarte(2).getDepart());
            point3.setText(joueur.getCartesDestination().getCarte(2).getPoint()+"");
            arrive3.setText(joueur.getCartesDestination().getCarte(2).getArrive());
            
        }if (taille>3){
            nextButton.setStyle("visibility:visible;");
        }else{
            nextButton.setStyle("visibility:hidden;");
        }
        // Indice des cartes affichés
        indiceD+=3;
    }

    // Cache les cartes destination
    public void hideCardDestination(MouseEvent event)throws Exception{
        // On cache et reaffiche comme avant
        destination1.setImage(null);
        destination2.setImage(null);
        destination3.setImage(null);

        depart1.setText(null);
        depart2.setText(null);
        depart3.setText(null);
        point1.setText(null);
        point2.setText(null);
        point3.setText(null);
        arrive1.setText(null);
        arrive2.setText(null);
        arrive3.setText(null);

        cartePane2.setVisible(false);
        face1.setVisible(true);
        face2.setVisible(true);
        face3.setVisible(true);
        face4.setVisible(true);
        face5.setVisible(true);
        carteD.setVisible(true);
    }

    // Defilent les cartes destination disposibles 
    public void nextCardDestination(ActionEvent event)throws Exception{
        int taille = joueur.getCartesDestination().getPaquet().size();
        if (taille>indiceD){
            indice2+=3;
            if (indice2>taille){
                indice2=0;
            }
            destination1.setImage(destination);
            destination2.setImage(null);
            destination3.setImage(null);

            depart1.setText(joueur.getCartesDestination().getCarte(indiceD).getDepart());
            point1.setText(joueur.getCartesDestination().getCarte(indiceD).getPoint()+"");
            arrive1.setText(joueur.getCartesDestination().getCarte(indiceD).getArrive());

            depart2.setText(null);
            depart3.setText(null);
            point2.setText(null);
            point3.setText(null);
            arrive2.setText(null);
            arrive3.setText(null);

            // Affiche plus ou moins de carte selon le nombre qu'il reste a afficher
            if (taille-indiceD>=2){
                destination2.setImage(destination);

                depart2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getDepart());
                point2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getPoint()+"");
                arrive2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getArrive());

                depart3.setText(null);
                point3.setText(null);
                arrive3.setText(null);
            }
            if (taille-indiceD>=3){
                destination3.setImage(destination);

                depart3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getDepart());
                point3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getPoint()+"");
                arrive3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getArrive());
            }
            if (taille-indiceD>3){
                indiceD+=3;
            }else{
                indiceD=0;
            }
            
        }
    }

    // Retirer une carte de la liste au debut 
    public void removeCard(MouseEvent event) throws Exception{
        if (tour==1&&((joueur.equals(j0) && elimine1==false) || (joueur.equals(j1) && elimine2==false))){
            String id = event.getPickResult().getIntersectedNode().getId();
            int num = Character.getNumericValue(id.charAt(11));
            int index =num+indice2-1;
            joueur.getCartesDestination().removeCarte(index);
            if(joueur.equals(j0)){
                elimine1=true;
            }else{
                elimine2=true;
            }
            this.changeMessage("Choisissez votre action pour ce tour");
            piocheDestination.setStyle("visibility:visible;");
            piocheWagon.setStyle("visibility:visible;");
            jouerPlateau.setStyle("visibility:visible;");
            this.hideCardDestination(event);
            this.showCardDestination(event);
        }
    }

    // Change le message affiché
    public void changeMessage(String message){
        text1.setText(message);
    }

    // Change le message affiché
    public void changeMessageIA(String message){
        textIA.setText(message);
    }

    // Dictionnaire des cartes présentes
    public void setdic(){
        for (int i=0;i<joueur.getCartesWagon().getPaquet().size();i++){
            String couleur =joueur.getCartesWagon().getCarte(i).getCouleur();
            if (dic.containsKey(couleur)){
                dic.replace(couleur, dic.get(couleur)+1);
            }else{
                dic.put(joueur.getCartesWagon().getCarte(i).getCouleur(),1);
            }
        }
    }

    // Conserve les carte destination du premier tour
    public void ConserveCarte(MouseEvent event) throws Exception{
        if(joueur.equals(j0)){
            elimine1=true;
        }else{
            elimine2=true;
        }
        this.hideCardDestination(event);
        this.changeMessage("Choisissez votre action pour ce tour");
        piocheDestination.setStyle("visibility:visible;");
        piocheWagon.setStyle("visibility:visible;");
        jouerPlateau.setStyle("visibility:visible;");
    }

    // Change la couleur d'une carte survolée
    public void survol(MouseEvent event){
        ImageView carteSurvol = (ImageView) event.getSource();
        carteSurvol.setStyle("-fx-opacity:0.5;");
    }

    // Remet a la normale une carte qui n'est plus survolée
    public void normal(MouseEvent event){
        ImageView carteSurvol = (ImageView) event.getSource();
        carteSurvol.setStyle("-fx-opacity:1;");
    }

    // Choix de piocher Wagon dans le tour
    public void piocheCarteWagon(MouseEvent event) throws Exception{
        this.changeMessage("Piochez vos carte wagon");
        piocheWagonCompte=0;
        joueW=true;
        piocheDestination.setStyle("visibility:hidden;");
        piocheWagon.setStyle("visibility:hidden;");
        jouerPlateau.setStyle("visibility:hidden;");
        this.hideCardDestination(event);
    }

    // Pioche des carte face révélés dans le tour 
    public void piocheFace(MouseEvent event) throws Exception{
        if (piocheWagonCompte<2 && joueW==true){
            String id = event.getPickResult().getIntersectedNode().getId();
            int num = Character.getNumericValue(id.charAt(4))-1;
            if(piocheWagonCompte==1 && p.get_wagon_face().getCarte(num).getCouleur().equals("joker")){
                this.changeMessage("Le joker ne peut pas etre pioché comme 2eme carte");
            }else{
                if(piocheWagonCompte==0 && p.get_wagon_face().getCarte(num).getCouleur().equals("joker")){
                    piocheWagonCompte+=1;
                    if (joueur.equals(j0)){
                        piochewj1+=1;
                    }else{
                        piochewj2+=1;
                    }
                }else if (piocheWagonCompte==0 && p.get_wagon_face().getCarte(num).getCouleur().equals("joker")==false){
                    if (joueur.equals(j0)){
                        piochewj1+=1;
                    }else{
                        piochewj2+=1;
                    }
                }else if (piocheWagonCompte==1 ){
                    if (joueur.equals(j0)){
                        piochewj1+=1;
                    }else{
                        piochewj2+=1;
                    }
                }
                joueur.getCartesWagon().getPaquet().add(p.get_wagon_face().getCarte(num));
                p.removeCarteFace(num);
                p.get_wagon_face().pioche(1, p.get_wagon_carte());
                // Evite 3 joker sur les cartes face révélés
                p.checkNbJoker();
                this.setFace();
                this.hideCardWagon(event);
                this.showCardWagon(event);
                this.changeMessage("Il reste une carte a piocher");
                piocheWagonCompte+=1;
            }
            if (piocheWagonCompte==2){
                joueW=false;
                jouable = false;
                this.play(event);
            }
        }
    }

    // Prendre dans la pioche Wagon
    public void carteWagonPioche(MouseEvent event) throws Exception{
        if (piocheWagonCompte<2 && joueW==true){
            joueur.getCartesWagon().pioche(1, p.get_wagon_carte());
            this.hideCardWagon(event);
            this.showCardWagon(event);
            this.changeMessage("Il reste une carte a piocher");
            piocheWagonCompte+=1;
        }
        if (joueur.equals(j0)){
            piochewj1+=1;
        }else{
            piochewj2+=1;
        }
        if (piocheWagonCompte==2 && joueW==true){
            joueW=false;
            jouable = false;
            this.play(event);
        }
    }

    // Choix de piocher Destination dans le tour
    public void piocheCarteDestination(MouseEvent event) throws Exception{
        joueD=true;
        // Affichage du paneau de pioche
        piocheDestinationPane.setStyle("visibility:visible;-fx-background-color:white;-fx-background-image:url('./design/fond2.jpg');");
        piocheDText.setText("Selectionnez les cartes a garder");
        piocheDestination.setStyle("visibility:hidden;");
        piocheWagon.setStyle("visibility:hidden;");
        jouerPlateau.setStyle("visibility:hidden;");
        this.showCardDestination(event);
        for (Node n : rootPane.getChildren()){
            n.setOpacity(0.5);
        }
        piocheDestinationPane.setOpacity(1);
        cartePane2.setOpacity(1);

        // Affichage des cartes
        piocheList.pioche(3, p.get_destination_carte()); 

        // 1ere carte
        piocheD1d.setText(piocheList.getCarte(0).getDepart());
        piocheD1p.setText(piocheList.getCarte(0).getPoint()+"");
        piocheD1a.setText(piocheList.getCarte(0).getArrive());

        // 2eme carte
        piocheD2d.setText(piocheList.getCarte(1).getDepart());
        piocheD2p.setText(piocheList.getCarte(1).getPoint()+"");
        piocheD2a.setText(piocheList.getCarte(1).getArrive());

        // 3 eme carte
        piocheD3d.setText(piocheList.getCarte(2).getDepart());
        piocheD3p.setText(piocheList.getCarte(2).getPoint()+"");
        piocheD3a.setText(piocheList.getCarte(2).getArrive());
        
        checkList.clear();
        checkList.add(false);checkList.add(false);checkList.add(false);
    }

    // Validation du choix de pioche Destination
    public void hidePiocheDestination(MouseEvent event) throws Exception{
        if (joueD==true){
            // Verification qu'une carte est bien cochée
            int count =0;
            for (boolean b : checkList){
                if (b==false){
                    count+=1;
                }
            }
            if (joueur.equals(j0)){
                piochedj1+=3-count;
            }else{
                piochedj2+=3-count;
            }
            if (count==3){
                piocheDText.setText("Selectionnez au moins 1 carte");
                return;
            }
            // Recuperation des cartes
            for (int i=0;i<checkList.size();i++){
                if (checkList.get(i)==true){
                    joueur.getCartesDestination().getPaquet().add(piocheList.getCarte(i));
                }else{
                    p.get_destination_carte().getPaquet().add(piocheList.getCarte(i));
                }
            }
            // Nettoyage des affichage Destination
            piocheList.getPaquet().clear();
            piocheD1.setEffect(null);
            piocheD2.setEffect(null);
            piocheD3.setEffect(null);
            piocheDestinationPane.setStyle("visibility:hidden;");
            for (Node n : rootPane.getChildren()){
                n.setOpacity(1);
            }
            this.hideCardDestination(event);
            this.showCardDestination(event);
            joueD=false;
            jouable = false;
            this.play(event);
        }
    }

    // Selectionner une carte de la pioche Destination
    public void selectPiocheDestination(MouseEvent event)throws Exception{
        String id = event.getPickResult().getIntersectedNode().getId();
        int num = Character.getNumericValue(id.charAt(7))-1;
        ImageView selectImage = (ImageView) event.getSource();
        if (checkList.get(num)==false){
            checkList.set(num, true);
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(0.8);
            selectImage.setEffect(colorAdjust);
        }else{
            checkList.set(num, false);
            selectImage.setEffect(null);
        }
    }

    // Choix de jouer des cartes dans le tour 
    public void joueRoute(MouseEvent event)throws Exception{
        joueR=true;
        piocheDestination.setStyle("visibility:hidden;");
        piocheWagon.setStyle("visibility:hidden;");
        jouerPlateau.setStyle("visibility:hidden;");
    }

    // Choix de la route a prendre
    public void prendreRoute(MouseEvent event)throws Exception{
        if (joueR==false){
            return;
        }
        if (joueur.equals(j0)){
            routepj1+=1;
        }else{
            routepj2+=1;
        }
        // Recuperation de la route cliquée
        String id = event.getPickResult().getIntersectedNode().getId();
        Character charnum = id.charAt(5);
        String strnum=""+charnum;
        // Si id avec 2 chiffres
        if (id.length()>6){
            strnum=""+charnum+id.charAt(6);
        }
        Integer num=Integer.parseInt(strnum);
        Route route =p.get_route().get(num-1);

        // Si la route n'est pas encore prise
        Boolean verif = false;
        if (route.getProprietaire()==null){
            // On verifie qu'on peut la prendre , d'abord avec des cartes wagon
            if(joueur.getCartesWagon().nbcarte(route.getCouleur(), joueur.getCartesWagon())>=route.getTaille()){
                int numdelete = 0;
                // On supprime les cartes wagons utilisés
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (numdelete !=route.getTaille() && joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals(route.getCouleur())){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                }

                verif=true;
            }
            // Sinon avec des cartes Joker en plus
            if (joueur.getCartesWagon().nbcarte(route.getCouleur(), joueur.getCartesWagon()) + joueur.getCartesWagon().nbcarte("joker", joueur.getCartesWagon()) >=route.getTaille()){
                int numdelete = 0;
                // On supprime les cartes wagons utilisés
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals(route.getCouleur())){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                } // Puis les cartes joker
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (numdelete !=route.getTaille() && joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals("joker")){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                }
                verif=true;
            }
            if (verif==true){
                // Mis a jour nb wagon
                joueur.setWagons(joueur.getWagons()-route.getTaille());
                nbwagon.setText(Integer.toString(joueur.getWagons()));

                // Mise a jour de la route
                ImageView routePrise = (ImageView) event.getSource();
                routePrise.setImage(new Image(".\\wagon\\w"+p.get_route().get(num-1).getTaille()+"_"+joueur.getCouleur()+".png"));
                routePrise.setStyle("-fx-effect: dropshadow(gaussian, #000000, 30, 0, 0, 0);");

                p.get_route().get(num-1).setProprietaire(joueur);

                // Mis a jour du nb de point
                joueur.addPoint(route.getPoints());

                joueR=false;
                jouable = false;
                this.play(event);
            }else{
                // Si erreur et route impossible a prendre
                joueR=false;
                piocheDestination.setStyle("visibility:visible;");
                piocheWagon.setStyle("visibility:visible;");
                this.changeMessage("Jeu impossible changez d'option");
            }
        }
    }

    // Mettre a jour les cartes Wagons révélés
    public void setFace(){
        Image f1 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(0).getLink());
        Image f2 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(1).getLink());
        Image f3 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(2).getLink());
        Image f4 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(3).getLink());
        Image f5 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(4).getLink());

        face1.setImage(f1);
        face2.setImage(f2);
        face3.setImage(f3);
        face4.setImage(f4);
        face5.setImage(f5);

    }
    
    // Verification des points des carte destinations en fin de partie 
    public boolean verifCarteDestination(Ville depart, Ville arrive){
        boolean verif=false;

        // Récuperation des route possédés par le joueur
        ArrayList<Route> routePrises = new ArrayList<>();
        Route routeDepart=new Route();
        for (Route element :p.get_route()){
            if (element.getProprietaire()!= null && element.getProprietaire().getNom().equals(joueur.getNom())){
                routePrises.add(element);
            }
        }
        // On verifie si le depart et l'arrivé sont sur 2 route qui lui appartiennent
        boolean dTrouve = false;
        boolean aTrouve = false;
        for (Route element :routePrises){
            if (element.getDestination()[0].getName().equals(depart.getName()) || element.getDestination()[1].getName().equals(depart.getName())){
                routeDepart=new Route(element);
                dTrouve=true;
            }
            if (element.getDestination()[0].getName().equals(arrive.getName()) || element.getDestination()[1].getName().equals(arrive.getName())){
                aTrouve=true;
            }
        }

        // Si le début et la fin sont présent on verifie qu'ils sont reliés
        if (aTrouve==true && dTrouve==true){
            
            // Parcours en largeur
            ArrayList<Route> file = new ArrayList<>();
            ArrayList<Route> deja_parcouru = new ArrayList<>();
            file.add(routeDepart);
            deja_parcouru.add(routeDepart);
            while (file.size()!=0){
                for (Route voisin : file.get(0).getVoisins(routePrises) ){
                    if (deja_parcouru.contains(voisin)==false){
                        file.add(voisin);
                        deja_parcouru.add(voisin);
                        if (voisin.getDestination()[0].getName().equals(arrive.getName()) || voisin.getDestination()[1].getName().equals(arrive.getName())){
                            verif=true;
                        }
                    }
                }
                file.remove(file.get(0));
            }
        }
        return verif;
    }

    // Calcul du plus long chemin
    public int cheminLong(Joueur j){

        // Récuperation des route possédés par le joueur
        ArrayList<Route> routePrises = new ArrayList<>();
        for (Route element :p.get_route()){
            if (element.getProprietaire()!= null && element.getProprietaire().getNom().equals(j.getNom())){
                routePrises.add(element);
            }
        }

        // On parcoure en longueur depuis chaque sommet et on prend le maximum
        int max=0;
        for (Route element : routePrises){
            if (calculerProfondeur(routePrises.indexOf(element), routePrises)>max){
                max=calculerProfondeur(routePrises.indexOf(element), routePrises);
            }
        }

        return max;
    }

    // Mesure des parcours en profondeur
    public static int calculerProfondeur(int sommetDepart, ArrayList<Route> routePrises) {
        int nombreSommets = routePrises.size();
        ArrayList<Route> parcouru = new ArrayList<>(); // Pour garder une trace des sommets visités
        int[] profondeur = new int[nombreSommets]; // Pour stocker la profondeur de chaque sommet
    
        dfs(sommetDepart, parcouru, profondeur, routePrises.get(sommetDepart).getTaille(), routePrises); // Recherche en profondeur
    
        int maxProfondeur = 0;
        for (int i = 0; i < nombreSommets; ++i) {
            if (profondeur[i] > maxProfondeur) {
                maxProfondeur = profondeur[i];
            }
        }
    
        return maxProfondeur;
    }

    // Parcours en profondeur
    private static void dfs(int sommet, ArrayList<Route> parcouru, int[] profondeur, int niveau, ArrayList<Route> routePrises) {
        parcouru.add(routePrises.get(sommet));
        profondeur[sommet] = niveau; // Stocker la profondeur du sommet
    
        for (Route voisin: routePrises.get(sommet).getVoisins(routePrises)) { 
            if (parcouru.contains(voisin)==false) { // Si le voisin n'a pas été visité, le visiter
                dfs(routePrises.indexOf(voisin), parcouru, profondeur, niveau + routePrises.get(routePrises.indexOf(voisin)).getTaille(), routePrises); // Recherche en profondeur récursive
            }
        }
    }

    // Evaluation de la situation
    public String evaluation(Joueur joueur){
        int jouer = 0;

        ArrayList<Route> route_possibles = new ArrayList<>();
        ArrayList<Route> route_def = new ArrayList<>();
        ArrayList<Route> route_val = new ArrayList<>();
        int joker=0;
        joker = joueur.getCartesWagon().nbcarte("joker", joueur.getCartesWagon());

        for (Route route : p.get_route()){
            if (route.getProprietaire()==null){
                if(joueur.getCartesWagon().nbcarte(route.getCouleur(), joueur.getCartesWagon())>=route.getTaille()-joker){
                    route_possibles.add(route);
                }
            }
        }

        boolean route_jouable = false ;

        for (Route route : route_possibles){
            
            for (Carte destination : joueur.getCartesDestination().getPaquet()){
                if(verifCarteDestination(destination.getVilleDestination()[0], destination.getVilleDestination()[1])==false){
                    ArrayList<Ville> chemin = this.cheminCourt(joueur, destination.getVilleDestination()[0],destination.getVilleDestination()[1]);

                    for (int i=0; i<chemin.size()-2; i++){
                        if ((chemin.get(i).equals(route.getDestination()[0]) && chemin.get(i+1).equals(route.getDestination()[1])) || (chemin.get(i).equals(route.getDestination()[1]) && chemin.get(i+1).equals(route.getDestination()[0]))){
                            route_val.add(route);
                            route_jouable=true;
                            jouer = 10;
                        }
                    }
                }
            }

            // Route par défaut
            if(route.getTaille()>3 ){
                route_def.add(route);
                route_jouable = true;
                jouer=5;
            }
        }

        // Jeu 
        if(route_jouable ==false){
            // Carte destination
            ArrayList<Carte> paquet_destination = joueur.getCartesDestination().getPaquet() ;
            if (paquet_destination.size()<3 && this.verifCarteDestination(paquet_destination.get(0).getVilleDestination()[0], paquet_destination.get(0).getVilleDestination()[1]) && this.verifCarteDestination(paquet_destination.get(1).getVilleDestination()[0], paquet_destination.get(1).getVilleDestination()[1])==false){
                System.out.println("destination");
                piochedj2+=1;
                piocheList.pioche(3, p.get_destination_carte()); 
                int max =100;
                for (Carte element : piocheList.getPaquet()){
                    if (element.getPoint()<max){
                        max=element.getPoint();
                    }
                }for (Carte element : piocheList.getPaquet()){
                    if (element.getPoint()==max){
                        joueur.getCartesDestination().getPaquet().add(element);
                    }else{
                        p.get_destination_carte().getPaquet().add(element);
                    }
                }
                piocheList.getPaquet().clear();
                return "Destination";
            }else{
                // Carte Wagon 
                boolean fini = false;
                int indice=0;
                // si Joker 
                for (Carte element : p.get_wagon_face().getPaquet()){
                    if (element.getCouleur().equals("joker")){
                        p.removeCarteFace(indice);
                        p.get_wagon_face().pioche(1, p.get_wagon_carte());
                        p.checkNbJoker();
                        joueur.getCartesWagon().getPaquet().add(element);
                        fini=true;
                        piochewj2+=1;
                        System.out.println("Joker");
                        return "WFace";
                    }
                    indice+=1;
                } // Sinon
                if (fini == false){
                    int[] tableau = this.besoinCouleur(joueur);
                    int max =0;
                    for (int i =0; i<8 ;i++){
                        if (tableau[i]>max && p.get_wagon_face().nbcarte(couleur.get(i), p.get_wagon_face())>0){
                            max=tableau[i];
                            indice =i;
                        }
                    }if (max!=0){
                        System.out.println("Wagon face");
                        int indice2=0;
                        for (Carte element : p.get_wagon_face().getPaquet()){
                            if(element.getCouleur().equals(couleur.get(indice))){
                                p.removeCarteFace(indice2);
                                p.get_wagon_face().pioche(1, p.get_wagon_carte());
                                p.checkNbJoker();
                                joueur.getCartesWagon().getPaquet().add(element);
                                break;
                            }
                            indice2+=1;
                        }
                        indice2=0;
                        // 2eme carte 
                        for (Carte element : p.get_wagon_face().getPaquet()){
                            if(element.getCouleur().equals("joker")==false){
                                p.removeCarteFace(indice2);
                                p.get_wagon_face().pioche(1, p.get_wagon_carte());
                                p.checkNbJoker();
                                joueur.getCartesWagon().getPaquet().add(element);
                                break;
                            }
                            indice2+=1;
                        }
                        piochewj2+=2;
                    return "WFace";
                    }else{
                        System.out.println("Wagon pioche");
                        joueur.getCartesWagon().pioche(2, p.get_wagon_carte());
                        piochewj2+=2;
                        return "WPioche";
                    }
                }
            }
        }else{
            System.out.println("route");
            // Choix de la route :
            Route route_cible = new Route();
            if (jouer == 5){
                route_cible=route_def.get(0);
            }else{
                int max =0;
                for (Route route : route_val){
                    if (route.getTaille()>max ){
                        max=route.getTaille();
                        route_cible=route;
                    }
                }
            }

            boolean verif=false;
            // Prise avec carte wagon
            if(joueur.getCartesWagon().nbcarte(route_cible.getCouleur(), joueur.getCartesWagon())>=route_cible.getTaille()){
                int numdelete = 0;
                // On supprime les cartes wagons utilisés
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (numdelete !=route_cible.getTaille() && joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals(route_cible.getCouleur())){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                }
                verif = true;
            } // Prise avec joker 
            else{
                int numdelete = 0;
                // On supprime les cartes wagons utilisés
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals(route_cible.getCouleur())){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                } // Puis les cartes joker
                for (int i=joueur.getCartesWagon().getPaquet().size()-1;i>=0;i--){
                    if (numdelete !=route_cible.getTaille() && joueur.getCartesWagon().getPaquet().get(i).getCouleur().equals("joker")){
                        numdelete+=1;
                        joueur.getCartesWagon().getPaquet().remove(i);
                    }
                }
                verif=true;
            }
            if (verif=true){
                joueur.setWagons(joueur.getWagons()-route_cible.getTaille());
                nbwagon.setText(Integer.toString(joueur.getWagons()));
                int num = p.get_route().indexOf(route_cible);
                this.trouveRoute(p, joueur, num+1);
                // Mis a jour du nb de point
                routepj2+=1;
                
                joueur.addPoint(route_cible.getPoints());
            }
            return "Route";
        }
        return "Erreur";
    }

    // Chemin le plus court pour accomplir sa carte destination 
    public ArrayList<Ville> cheminCourt(Joueur joueur, Ville depart, Ville arrivé){
        // Dijkstra
        ArrayList<Ville> Q = new ArrayList<>();
        int dist[] = new int[p.get_ville().size()];
        Ville prev[] = new Ville[p.get_ville().size()];

        for (int i=0;i< p.get_ville().size();i++){
            dist[i]= 1000;
            prev[i]= null;
            Q.add(p.get_ville().get(i));
        }

        dist[p.getIndexVille(depart)]=0;

        while (Q.size()!=0){
            Ville now = p.get_ville().get(p.indexDistMini(dist,Q));
            int index = p.indexDistMini(dist,Q);
            Q.remove(now);
            // Parcours des voisins
            for (Map.Entry<Ville,Integer> voisin: now.getVraiVoisins(p, joueur).entrySet()){
                // On verifie que la route est libre
                int alt = dist[index] + voisin.getValue();
                int v = p.getIndexVille(voisin.getKey());
                if (alt<dist[v]){
                    dist[v] = alt;
                    prev[v] = now;
                }
            }
        }

        // Reconstitution du chemin
        ArrayList<Ville> chemin = new ArrayList<>();
        chemin.add(arrivé);
        int j=p.getIndexVille(arrivé);
        
        while (prev[j]!=null){
            chemin.add(prev[j]);
            j=p.getIndexVille(prev[j]);
        }
        return chemin;
    }

}
