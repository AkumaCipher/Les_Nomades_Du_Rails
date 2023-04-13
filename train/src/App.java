
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
 
/**
 * Lance l'application 
 */
public class App extends Application {
    
    @Override
    public void start(Stage window) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("./acceuil.fxml"));
            window.setScene(new Scene(root));
            window.setTitle("Game");
            window.setResizable(true);
            window.setFullScreen(true);
            window.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}