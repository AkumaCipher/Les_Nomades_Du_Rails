import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Controlleur de la Scene d'acceuil et de connexion
public class HomeSceneController {
    // Declaration d'elements graphique de la scene
    @FXML
    private Button online;
    @FXML
    private ChoiceBox<String> couleurField1;
    @FXML
    private ChoiceBox<String> couleurField2;
    @FXML
    private Text couleurText1;
    @FXML
    private Text couleurText2;
    @FXML
    private AnchorPane joueurPane;
    @FXML
    private TextField nomField1;
    @FXML
    private TextField nomField2;
    @FXML
    private Text nomText1;
    @FXML
    private Text nomText2;
    @FXML
    private AnchorPane pageAcceuil;
    @FXML
    private Button partie;
    @FXML
    private ImageView photo1;
    @FXML
    private ImageView photo2;
    @FXML
    private Button play;
    @FXML
    private Button quitter;
    @FXML
    private ImageView imageRegle;
    @FXML
    private Button regle;
    @FXML
    private Button adversaire;
    @FXML
    private Button stat;
    @FXML
    private AnchorPane statPane;
    @FXML
    private Button backButton;
    @FXML
    private Text ad1;
    @FXML
    private Text ad2;
    @FXML
    private Text ad3;
    @FXML
    private Text ad4;
    @FXML
    private Text ad5;
    @FXML
    private Text date1;
    @FXML
    private Text date2;
    @FXML
    private Text date3;
    @FXML
    private Text date4;
    @FXML
    private Text date5;
    @FXML
    private Text res1;
    @FXML
    private Text res2;
    @FXML
    private Text res3;
    @FXML
    private Text res4;
    @FXML
    private Text res5;
    @FXML
    private Text score1;
    @FXML
    private Text score2;
    @FXML
    private Text score3;
    @FXML
    private Text score4;
    @FXML
    private Text score5;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private Text index;
    @FXML
    private AnchorPane onlinePane;
    @FXML
    private TextField nomFieldO;
    @FXML
    private ChoiceBox<String> couleurFieldO;
    @FXML
    private Button playO;
    @FXML
    private AnchorPane connectPane;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String[] color = {"blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"};
    int click=0;
    int click2=0;
    int indice =0;
    int count =0;
    String confirmation =" ";
    

    // Creer la partie et passe sur la scene jeu si les joueurs sont rempli correctement
    @FXML
    void newPartie(MouseEvent event) throws Exception{
        // On verifie qu'il a choisi 2 couleurs différentes et tout rempli
        if (click2==0 && couleurField1.getValue().equals(couleurField2.getValue())==false && nomField1.getText()!=null && nomField2.getText()!=null && couleurField1.getValue()!=null && couleurField2.getValue()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));
            root=loader.load();
            MainSceneController mainController = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setResizable(true);
            stage.show();
            mainController.Start(nomField1.getText(),nomField2.getText(),couleurField1.getValue(),couleurField2.getValue(),false);
        }
        if (click2==1 && couleurField1.getValue()!=null && nomField1.getText()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));
            root=loader.load();
            MainSceneController mainController = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setResizable(true);
            stage.show();
            mainController.Start(nomField1.getText(),null,couleurField1.getValue(),null,true);
        }
    }

    // Si nouvelle partie cliqué, on met en place l'ecran de connexion des joueurs
    @FXML
    void setupJoueur(MouseEvent event) {
        online.setVisible(false);
        partie.setVisible(false);
        quitter.setVisible(false);
        joueurPane.setVisible(true);
        stat.setVisible(false);
        couleurField1.getItems().addAll(color);
        couleurField2.getItems().addAll(color);
    }

    // Permet de quitter la fenetre 
    @FXML
    void close(ActionEvent event){
        Stage window = (Stage) quitter.getScene().getWindow();
        window.close();
    }

    // Affiche les règles
    @FXML 
    void showRegle(ActionEvent event){
        imageRegle.setVisible(true);
    }

    // Défile les pages de règles 
    @FXML 
    void updateRegle(MouseEvent event){
        click+=1;
        if (click==1){
            imageRegle.setImage(new Image("./design/regle2.png"));
        }
        if (click==2){
            imageRegle.setImage(new Image("./design/regle3.png"));
        }
        if (click==3){
            imageRegle.setImage(new Image("./design/regle1.png"));
            imageRegle.setVisible(false);
            click=0;
        }
    }

    // Change d'adversaire et active l'IA
    @FXML
    void changeAdversaire(MouseEvent event){
        if (click2==0){
            adversaire.setText("Autre Joueur");
            adversaire.setLayoutX(340);
            adversaire.setMinWidth(120);
            nomField2.setVisible(false);
            nomText2.setVisible(false);
            photo2.setVisible(false);
            couleurField2.setVisible(false);
            couleurText2.setVisible(false);
            click2+=1;
        }else{
            adversaire.setText("IA");
            adversaire.setLayoutX(350);
            adversaire.setMinWidth(100);
            nomField2.setVisible(true);
            nomText2.setVisible(true);
            photo2.setVisible(true);
            couleurField2.setVisible(true);
            couleurText2.setVisible(true);
            click2=0;
        } 
    }

    @FXML 
    void online(MouseEvent event) throws IOException{
        for (Node n : pageAcceuil.getChildren()){
            n.setOpacity(0.0);
        }
        onlinePane.setOpacity(1);
        onlinePane.setVisible(true);
        couleurFieldO.getItems().addAll(color);
    }

    @FXML
    void connect(MouseEvent event) throws IOException{
        if (count !=0 || couleurFieldO.getValue()==null || nomFieldO.getText()==null){
            return;
        }
        for (Node n : onlinePane.getChildren()){
            n.setOpacity(0.0);
        }
        connectPane.setOpacity(1);
        connectPane.setVisible(true);

        // Créer un nouveau thread pour la connexion
        Thread connectThread = new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 8080);
                // Lire les messages du serveur dans un nouveau thread
                Thread readThread = new Thread(() -> {
                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (confirmation.equals("partie commence")==false) {
                            String message = input.readLine();
                            if (message == null) {
                                break;
                            }
                            confirmation=message;
                            System.out.println(message);
                        }
                        // Envoyer un message au serveur
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write((nomFieldO.getText()+","+couleurFieldO.getValue()+"\n").getBytes());
                        System.out.println("Bonjour serveur");
                        outputStream.flush();

                        confirmation = "get";
                        while (confirmation.equals("get")){
                            String message = input.readLine();
                            if (message == null) {
                                break;
                            }
                            confirmation=message;
                            System.out.println(message);
                        }
                        // Lancement du jeu
                        String[] tab = confirmation.split("\\|");
                        String[] tab1 = tab[0].split(",");
                        String[] tab2 = tab[1].split(",");
                        System.out.println(tab[0]);
                        Platform.runLater(() -> {
                            try{
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));
                                root=loader.load();
                                MainSceneController mainController = loader.getController();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.setFullScreen(true);
                                stage.setResizable(true);
                                stage.show();
                                mainController.Start(tab1[0],tab2[0],tab1[1],tab2[1],false);
                            }catch(Exception e){
                                System.out.println(e);
                            }                        
                        });
                        

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                readThread.start();

            } catch (Exception e) {
                System.out.println("Erreur");
            }
        });
        connectThread.start();
        count+=1;
    }

    @FXML
    void data(MouseEvent event) throws IOException{
        for (Node n : pageAcceuil.getChildren()){
            n.setOpacity(0.0);
        }
        statPane.setOpacity(1);
        String json = new String(Files.readAllBytes(Paths.get("src/data.json")));
        JSONObject jsonObject = new JSONObject(json);
        JSONArray parties = jsonObject.getJSONArray("parties");
        this.updateStat();
        index.setText("1/" + String.valueOf(parties.length() / 5 + 1));
        indice=0;
    }

    @FXML
    void back(MouseEvent event) throws IOException{
        for (Node n : pageAcceuil.getChildren()){
            n.setOpacity(1);
        }
        statPane.setOpacity(0);
    }

    @FXML
    void previous() throws IOException{
        String json = new String(Files.readAllBytes(Paths.get("src/data.json")));
        JSONObject jsonObject = new JSONObject(json);
        JSONArray parties = jsonObject.getJSONArray("parties");
        if (parties.length()-1-indice+5<parties.length()){
            indice-=9;
            System.out.println(indice);
            if (parties.length()-1-indice>=0){
                JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
                date1.setText(actual.getString("date"));
                JSONObject joueur1=actual.getJSONObject("joueur1");
                JSONObject joueur2=actual.getJSONObject("joueur2");
                score1.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
                ad1.setText(joueur2.getString("nom"));
                if (actual.getInt("win")==0){
                    res1.setText("Victoire");
                    res1.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res1.setFill(Color.GREEN);
                }else{
                    res1.setText("Défaite");
                    res1.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res1.setFill(Color.RED);
                }
            }
            indice+=1;
            if (parties.length()-1-indice>=0){
                JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
                date2.setText(actual.getString("date"));
                JSONObject joueur1=actual.getJSONObject("joueur1");
                JSONObject joueur2=actual.getJSONObject("joueur2");
                score2.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
                ad2.setText(joueur2.getString("nom"));
                if (actual.getInt("win")==0){
                    res2.setText("Victoire");
                    res2.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res2.setFill(Color.GREEN);
                }else{
                    res2.setText("Défaite");
                    res2.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res2.setFill(Color.RED);
                }
            }else{
                date2.setText("|");
            }
            indice+=1;
            if (parties.length()-1-indice>=0){
                JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
                date3.setText(actual.getString("date"));
                JSONObject joueur1=actual.getJSONObject("joueur1");
                JSONObject joueur2=actual.getJSONObject("joueur2");
                score3.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
                ad3.setText(joueur2.getString("nom"));
                if (actual.getInt("win")==0){
                    res3.setText("Victoire");
                    res3.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res3.setFill(Color.GREEN);
                }else{
                    res3.setText("Défaite");
                    res3.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res3.setFill(Color.RED);
                }
            }else{
                date3.setText("|");
            }
            indice+=1;
            if (parties.length()-1-indice>=0){
                JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
                date4.setText(actual.getString("date"));
                JSONObject joueur1=actual.getJSONObject("joueur1");
                JSONObject joueur2=actual.getJSONObject("joueur2");
                score4.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
                ad4.setText(joueur2.getString("nom"));
                if (actual.getInt("win")==0){
                    res4.setText("Victoire");
                    res4.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res4.setFill(Color.GREEN);
                }else{
                    res4.setText("Défaite");
                    res4.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                    res4.setFill(Color.RED);
                }
            }else{
                date4.setText("|");
            }
            indice+=1;
            if (parties.length()-1-indice>=0){
                JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
                date5.setText(actual.getString("date"));
                JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score5.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad5.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res5.setText("Victoire");
                res5.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res5.setFill(Color.GREEN);
            }else{
                res5.setText("Défaite");
                res5.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res5.setFill(Color.RED);
            }
            }else{
                date5.setText("|");
            }
            indice-=4;
            index.setText(String.valueOf(indice / 5 + 1)+"/" + String.valueOf(parties.length() / 5 + 1));
        }
    }

    @FXML
    void next() throws IOException{
        String json = new String(Files.readAllBytes(Paths.get("src/data.json")));
        JSONObject jsonObject = new JSONObject(json);
        JSONArray parties = jsonObject.getJSONArray("parties");
        if (parties.length()-1-indice-5>=0){
            indice+=5;
            System.out.println(indice);
            updateStat();
            index.setText(String.valueOf(indice / 5 + 1)+"/" + String.valueOf(parties.length() / 5 + 1));
        }else{
            indice=0;
            this.updateStat();
            indice=0;
            index.setText("1/" + String.valueOf(parties.length() / 5 + 1));
        }
    }

    @FXML
    void updateStat() throws IOException{
        String json = new String(Files.readAllBytes(Paths.get("src/data.json")));
        JSONObject jsonObject = new JSONObject(json);
        JSONArray parties = jsonObject.getJSONArray("parties");
        if (parties.length()-1-indice>=0){
            JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
            date1.setText(actual.getString("date"));
            JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score1.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad1.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res1.setText("Victoire");
                res1.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res1.setFill(Color.GREEN);
            }else{
                res1.setText("Défaite");
                res1.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res1.setFill(Color.RED);
            }

        }
        indice+=1;
        if (parties.length()-1-indice>=0){
            JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
            date2.setText(actual.getString("date"));
            JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score2.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad2.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res2.setText("Victoire");
                res2.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res2.setFill(Color.GREEN);
            }else{
                res2.setText("Défaite");
                res2.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res2.setFill(Color.RED);
            }
        }else{
            date2.setText("|");
            res2.setText("|");
            ad2.setText("|");
            score2.setText("|");
            res2.setFill(Color.WHITE);
        }
        indice+=1;
        if (parties.length()-1-indice>=0){
            JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
            date3.setText(actual.getString("date"));
            JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score3.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad3.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res3.setText("Victoire");
                res3.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res3.setFill(Color.GREEN);
            }else{
                res3.setText("Défaite");
                res3.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res3.setFill(Color.RED);
            }
        }else{
            date3.setText("|");
            res3.setText("|");
            ad3.setText("|");
            score3.setText("|");
            res3.setFill(Color.WHITE);
        }
        indice+=1;
        if (parties.length()-1-indice>=0){
            JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
            date4.setText(actual.getString("date"));
            JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score4.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad4.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res4.setText("Victoire");
                res4.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res4.setFill(Color.GREEN);
            }else{
                res4.setText("Défaite");
                res4.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res4.setFill(Color.RED);
            }
        }else{
            date4.setText("|");
            res4.setText("|");
            ad4.setText("|");
            score4.setText("|");
            res4.setFill(Color.WHITE);
        }
        indice+=1;
        if (parties.length()-1-indice>=0){
            JSONObject actual = parties.getJSONObject(parties.length() - 1 - indice);
            date5.setText(actual.getString("date"));
            JSONObject joueur1=actual.getJSONObject("joueur1");
            JSONObject joueur2=actual.getJSONObject("joueur2");
            score5.setText(String.valueOf(joueur1.get("score"))+" | "+String.valueOf(joueur2.get("score")));
            ad5.setText(joueur2.getString("nom"));
            if (actual.getInt("win")==0){
                res5.setText("Victoire");
                res5.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res5.setFill(Color.GREEN);
            }else{
                res5.setText("Défaite");
                res5.setStyle("-fx-text-alignment: center; -fx-font-weight: bold;");
                res5.setFill(Color.RED);
            }
        }else{
            date5.setText("|");
            res5.setText("|");
            res5.setFill(Color.WHITE);
            ad5.setText("|");
            score5.setText("|");
        }
    }

}