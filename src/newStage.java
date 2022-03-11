import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class newStage extends Stage {
    public newStage(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FxmlToNewStage.fxml"));
            Scene scene = new Scene(root);
            setScene(scene);
            this.show();
        }catch (Exception e){

        }

    }


}
