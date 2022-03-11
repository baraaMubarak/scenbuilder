import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class About extends Stage {
    public About() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = new Scene(parent);
        setScene(scene);
    }
}
