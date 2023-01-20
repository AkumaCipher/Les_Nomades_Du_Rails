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
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Controlleur de la Scene d'acceuil et de connexion
public class HomeSceneController {
    // Declaration d'elements graphique de la scene
    @FXML
    private Button charge;
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

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String[] color = {"blanc", "bleu", "jaune", "vert", "rouge", "violet", "noire", "orange"};
    int click=0;

    // Creer la partie et passe sur la scene jeu si les joueurs sont rempli correctement
    @FXML
    void newPartie(MouseEvent event) throws Exception{
        // On verifie qu'il a choisi 2 couleurs différentes et tout rempli
        if (couleurField1.getValue().equals(couleurField2.getValue())==false && nomField1.getText()!=null && nomField2.getText()!=null && couleurField1.getValue()!=null && couleurField2.getValue()!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("jeu.fxml"));
            root=loader.load();
            MainSceneController mainController = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setResizable(true);
            stage.show();
            mainController.Start(nomField1.getText(),nomField2.getText(),couleurField1.getValue(),couleurField2.getValue());
        }
    }

    // Si nouvelle partie cliqué, on met en place l'ecran de connexion des joueurs
    @FXML
    void setupJoueur(ActionEvent event) {
        charge.setVisible(false);
        partie.setVisible(false);
        quitter.setVisible(false);
        joueurPane.setVisible(true);
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

}