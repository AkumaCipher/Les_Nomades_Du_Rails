import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Thread;
import engine.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Defintion des joueurs de base 
    engine.Plateau p = new Plateau();
    engine.Joueur j0 = new Joueur("Bob",p.get_wagon_carte(),p.get_destination_carte());
    engine.Joueur j1 = new Joueur("John",p.get_wagon_carte(),p.get_destination_carte());

    engine.Joueur joueur = j0;
    int tour = 0;

    // Page de jeu
    @FXML
    private AnchorPane rootPane;

    // Joueurs
    @FXML
    private ImageView joueur1;
    @FXML
    private ImageView joueur2;

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
    private Text carteville1;
    @FXML
    private Text carteville2;
    @FXML
    private Text carteville3;
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

    Image f1 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(0).getLink());
    Image f2 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(1).getLink());
    Image f3 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(2).getLink());
    Image f4 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(3).getLink());
    Image f5 = new javafx.scene.image.Image(p.get_wagon_face().getCarte(4).getLink());

    Image vide = new Image(".\\wagon\\cartevide.png",100,150,true,true);

    // Creation nouvelle partie
    public void newPartie(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void exit(ScrollEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setFullScreen(false);
        stage.show();
    }

    public void setupWagon(){
        // Recuperation des prochaines images pour les wagons

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

        // Carte a eliminer au premier tour 
        if (elimine1==false && tour==1 && joueur.equals(j0)){
            return;
        }else if(elimine2==false && tour==1 && joueur.equals(j1)){
            return;
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
        if(joueur.equals(j0) && tour!=0){
            joueur=j1;
        }else{
            joueur=j0;
            tour+=1;
        }

        if (tour==1){
            text1.setStyle("visibility : visible;-fx-text-alignment:center;");
        }else{
            text1.setStyle("visibility: hidden");
        }

        // Affichage carte wagon révélé
        face1.setImage(f1);
        face2.setImage(f2);
        face3.setImage(f3);
        face4.setImage(f4);
        face5.setImage(f5);

        // Affichage nombre wagon du joueur
        Text nbwagon = new Text(Integer.toString(joueur.getWagons()));
        nbwagon.setLayoutX(100);
        nbwagon.setLayoutY(800);
        nbwagon.setStyle("-fx-font-size:30;");
        rootPane.getChildren().addAll(nbwagon);

        // Affichage des joueurs actuels 
        if (joueur.equals(j0)){
            joueur2.setStyle("-fx-opacity:0.4;");
            joueur1.setStyle("-fx-opacity:1;");
        }else{
            joueur1.setStyle("-fx-opacity:0.4;");
            joueur2.setStyle("-fx-opacity:1;");
        }

        // Affichage statistiques joueurs
        Text nom = new Text(j0.getNom());
        nom.setLayoutX(100);
        nom.setLayoutY(225);

        Text point = new Text(Integer.toString(j0.getPoint())+" points");
        point.setLayoutX(100);
        point.setLayoutY(250);

        Text nom2 = new Text(j1.getNom());
        nom2.setLayoutX(100);
        nom2.setLayoutY(500);

        Text point2 = new Text(Integer.toString(j1.getPoint())+" points");
        point2.setLayoutX(100);
        point2.setLayoutY(525);

        rootPane.getChildren().addAll(nom,nom2,point,point2);

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
            bottom.setStyle("visibility:visible;-fx-background-color:white;");

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
        destination1.setImage(vide);
        carteville1.setText(joueur.getCartesDestination().getCarte(0).getDepart()+" --> "+joueur.getCartesDestination().getCarte(0).getArrive());
        if (taille>=2){
            destination2.setImage(vide);
            carteville2.setText(joueur.getCartesDestination().getCarte(1).getDepart()+" --> "+joueur.getCartesDestination().getCarte(1).getArrive());
        }if (taille>=3){
            destination3.setImage(vide);
            carteville3.setText(joueur.getCartesDestination().getCarte(2).getDepart()+" --> "+joueur.getCartesDestination().getCarte(2).getArrive());
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
        carteville1.setText(null);
        carteville2.setText(null);
        carteville3.setText(null);
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
            if (taille-indiceD >3){
                destination1.setImage(vide);
                destination2.setImage(vide);
                destination3.setImage(vide);
                carteville1.setText(joueur.getCartesDestination().getCarte(indiceD).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD).getArrive());
                carteville2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD+1).getArrive());
                carteville3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD+2).getArrive());
                indiceD+=3;
            }
            else{
                destination1.setImage(vide);
                destination2.setImage(null);
                destination3.setImage(null);
                carteville1.setText(joueur.getCartesDestination().getCarte(indiceD).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD).getArrive());
                carteville2.setText(null);
                carteville3.setText(null);
                if (taille-indiceD>=2){
                    destination2.setImage(vide);
                    carteville2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD+1).getArrive());
                }
                if (taille-indiceD==3){
                    destination3.setImage(vide);
                    carteville3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getDepart()+" --> "+joueur.getCartesDestination().getCarte(indiceD+2).getArrive());
                }
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
            this.changeMessage("Piochez 2 cartes, dans la pioche ou dans les cartes révélés");
            this.hideCardDestination(event);
            this.showCardDestination(event);
        }
    }

    // Change le message affiché
    public void changeMessage(String message){
        text1.setText(message);
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

    public void ConserveCarte(MouseEvent event) throws Exception{
        if(joueur.equals(j0)){
            elimine1=true;
        }else{
            elimine2=true;
        }
        this.hideCardDestination(event);
        this.changeMessage("Piochez 2 cartes, dans la pioche ou dans les cartes révélés");
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
}
