import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFxml {




    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;

    @FXML
    private Button cancel;

    @FXML
    private Label hint;

    @FXML
    void clickCancel(ActionEvent event) {
        password.setText("");
        userName.setText("");
    }

    @FXML
    void clickSubmit(ActionEvent event) {
        try{
            Scanner in= new Scanner(new File("src\\Password.txt"));
            while(in.hasNext()){
                String text = in.nextLine();
                String userNameInFile = text.substring(0,text.indexOf(" "));
                String passwordInFile = (text.substring(userNameInFile.length())).trim();
                if(password.getText().equals(passwordInFile) && userName.getText().equals(userNameInFile)){
                    new newStage().show();
                }else{
                    hint.setText("Invalid Data");
                }
            }
        }catch(IOException e){
            e.getMessage();
        }


    }

}
