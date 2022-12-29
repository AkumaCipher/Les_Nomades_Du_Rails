import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;


 
public class App extends Application {
    
    
    @Override
    public void start(Stage window) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("./acceuil.fxml"));
            window.setScene(new Scene(root));
            window.setTitle("Game");
            window.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}