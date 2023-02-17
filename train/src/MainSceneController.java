import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    // Variable de base pour le jeu
    int piocheWagonCompte = 1000;
    PaquetCarte piocheList = new PaquetCarte(3,"Destination");
    ArrayList<Boolean> checkList = new ArrayList<>();
    boolean joueW = false;
    boolean joueD = false;
    boolean joueR = false;
    boolean last = false;


    Image destination = new Image(".\\wagon\\cartedestination.png",100,150,true,true);

    // Creation nouvelle partie
    public void Start(String nom1,String nom2,String couleur1, String couleur2) throws Exception{
        j0= new Joueur(nom1,couleur1,p.get_wagon_carte(),p.get_destination_carte());
        j1= new Joueur(nom2,couleur2,p.get_wagon_carte(),p.get_destination_carte());
        
    }

    // Quitter la partie en cours 
    public void exit(ScrollEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Applique un flou au route non prises au début
    public void flouRoute(){
        for (Node n : rootPane.getChildren()){
            String id = n.getId();
            if (id != null && id.charAt(0)=='r' && id.charAt(1)=='o' && id.charAt(2)=='u'){
                n.setOpacity(0.4);
            }
        }
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
        
        if (joueW==false && joueD==false && joueR==false){

            // Floutage des routes et affichage des couleurs
            if (tour==0){
                this.flouRoute();
            }

            // Carte a eliminer au premier tour 
            if (elimine1==false && tour==1 && joueur.equals(j0)){
                return;
            }else if(elimine2==false && tour==1 && joueur.equals(j1)){
                return;
            }

            // Options de jeu 
            if (elimine1==true && elimine2==true){
                piocheDestination.setStyle("visibility:visible;");
                piocheWagon.setStyle("visibility:visible;");
                jouerPlateau.setStyle("visibility:visible;");
            }

            if (last==true){
                this.changeMessage("C'est le dernier tour");
            }
            else if (j0.getWagons()<3 || j1.getWagons()<3){
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
            if(joueur.equals(j0) && tour!=0){
                joueur=j1;
            }else{
                joueur=j0;
                tour+=1;
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
        int i =p.get_index_ville(joueur.getCartesDestination().getCarte(0).getDepart());
        int i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(0).getArrive());
        point1.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
        arrive1.setText(joueur.getCartesDestination().getCarte(0).getArrive());
        if (taille>=2){
            destination2.setImage(destination);
            depart2.setText(joueur.getCartesDestination().getCarte(1).getDepart());
            i =p.get_index_ville(joueur.getCartesDestination().getCarte(1).getDepart());
            i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(1).getArrive());
            point2.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
            arrive2.setText(joueur.getCartesDestination().getCarte(1).getArrive());
        }if (taille>=3){
            destination3.setImage(destination);
            depart3.setText(joueur.getCartesDestination().getCarte(2).getDepart());
            i =p.get_index_ville(joueur.getCartesDestination().getCarte(2).getDepart());
            i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(2).getArrive());
            point3.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
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
            int i =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD).getDepart());
            int i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD).getArrive());
            point1.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
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
                i =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD+1).getDepart());
                i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD+1).getArrive());
                point2.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
                arrive2.setText(joueur.getCartesDestination().getCarte(indiceD+1).getArrive());

                depart3.setText(null);
                point3.setText(null);
                arrive3.setText(null);
            }
            if (taille-indiceD>=3){
                destination3.setImage(destination);

                depart3.setText(joueur.getCartesDestination().getCarte(indiceD+2).getDepart());
                i =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD+2).getDepart());
                i2 =p.get_index_ville(joueur.getCartesDestination().getCarte(indiceD+2).getArrive());
                point3.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
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
        }if (piocheWagonCompte==2 && joueW==true){
            joueW=false;
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
        int i =p.get_index_ville(piocheList.getCarte(0).getDepart());
        int i2 =p.get_index_ville(piocheList.getCarte(0).getArrive());
        piocheD1p.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
        piocheD1a.setText(piocheList.getCarte(0).getArrive());

        // 2eme carte
        piocheD2d.setText(piocheList.getCarte(1).getDepart());
        i =p.get_index_ville(piocheList.getCarte(1).getDepart());
        i2 =p.get_index_ville(piocheList.getCarte(1).getArrive());
        piocheD2p.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
        piocheD2a.setText(piocheList.getCarte(1).getArrive());

        // 3 eme carte
        piocheD3d.setText(piocheList.getCarte(2).getDepart());
        i =p.get_index_ville(piocheList.getCarte(2).getDepart());
        i2 =p.get_index_ville(piocheList.getCarte(2).getArrive());
        piocheD3p.setText(p.dijkstra(p.get_ville().get(i), p.get_ville().get(i2))[0]+"");
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
            this.flouRoute();
            this.hideCardDestination(event);
            this.showCardDestination(event);
            joueD=false;
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
                routePrise.setImage(new Image(".\\wagon\\r"+p.get_route().get(num-1).getTaille()+"_"+joueur.getCouleur()+".png"));
                if (joueur.equals(j0)){
                    routePrise.setStyle("-fx-opacity:1;-fx-effect: innershadow(gaussian, #039ed3, 10, 0.5, 0, 0);");
                }else{
                    routePrise.setStyle("-fx-opacity:1;-fx-effect: innershadow(gaussian, #FF0000, 10, 0.5, 0, 0);");
                }

                p.get_route().get(num-1).setProprietaire(joueur);

                // Mis a jour du nb de point
                joueur.addPoint(route.getPoints());

                // Verif point carte destination *Coming Soon*
                this.verifCarteDestination(joueur.getCartesDestination().getCarte(0).getVilleDestination()[0],joueur.getCartesDestination().getCarte(0).getVilleDestination()[1]);

                joueR=false;
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
    

}
