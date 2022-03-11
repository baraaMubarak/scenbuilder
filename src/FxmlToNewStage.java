import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FxmlToNewStage{

    FileChooser fileChooser = new FileChooser();
    File file;
    Stage stage;


    @FXML
    private Slider slider;

    @FXML
    private TextArea textArea;

    @FXML
    private WebView webView;
    @FXML
    private ComboBox comboBox;


    @FXML
    public void initialize() {
        fileChooser.setInitialDirectory(new File("src"));

        comboBox.getItems().clear();
        comboBox.getItems().addAll("Instructor GitHub", "JavaFX Guide", "My account");
        comboBox.getSelectionModel().select(1);

        onAction(null);
    }

    public void onSliderChanged(MouseEvent mouseEvent) {
        textArea.setFont(new Font(slider.getValue()));
    }



    public void menuOpen(ActionEvent actionEvent) throws IOException {

        file = fileChooser.showOpenDialog(null);
        Scanner in = new Scanner(file);
        String concatText = "";
        while(in.hasNext()){
            concatText += in.nextLine()+"\n";
        }
        textArea.setText(concatText);

    }

    public void existMenu(ActionEvent actionEvent) {
        stage = (Stage) slider.getScene().getWindow();
        stage.close();

        System.exit(0);
    }

    public void closeMenu(ActionEvent actionEvent) {
        file = null;
        textArea.setText("");
    }

    public void saveMenu(ActionEvent actionEvent) throws IOException {
        File file = fileChooser.showSaveDialog(null);
        FileWriter writer = new FileWriter(file);
        writer.write(textArea.getText());
        writer.close();

    }

    public void cyanMenu(ActionEvent actionEvent) {
        textArea.setStyle("-fx-text-fill:cyan");
    }

    public void redMenu(ActionEvent actionEvent) {
        textArea.setStyle("-fx-text-fill:red");
    }

    public void blueMenu(ActionEvent actionEvent) {
        textArea.setStyle("-fx-text-fill:blue");
    }

    public void aboutMenu(ActionEvent actionEvent) throws IOException {
        new About().show();
    }

    public void onAction(ActionEvent actionEvent) {
        if(comboBox.getSelectionModel().getSelectedIndex() == 0)
            webView.getEngine().load("https://github.com");
        else if(comboBox.getSelectionModel().getSelectedIndex() == 1)
            webView.getEngine().load("https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html");
        else if(comboBox.getSelectionModel().getSelectedIndex() == 2)
            webView.getEngine().load("https://github.com/baraaMubarak");
    }

}
