package com.example.covidapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.text.Text;

import java.sql.SQLException;

import static javafx.scene.paint.Color.*;

public class RegisterController {
    @FXML
    private TextField usernameRegisterField;
    @FXML
    private PasswordField passwordRegisterField;
    @FXML
    private TextField firstnameRegisterField;
    @FXML
    private TextField lastnameRegisterField;
    @FXML
    private Button registerInRegisterButton;
    @FXML
    private Button loginInRegisterButton;
    @FXML
    private Text registerTextAlert;

    public void loginInRegisterButtonOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;


        if(event.getSource()==loginInRegisterButton){
            stage = (Stage) loginInRegisterButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void registerInRegisterButtonOnAction(ActionEvent event) throws SQLException {

        Window owner = registerInRegisterButton.getScene().getWindow();

        System.out.println(firstnameRegisterField.getText());
        System.out.println(lastnameRegisterField.getText());
        System.out.println(usernameRegisterField.getText());
        System.out.println(passwordRegisterField.getText());
        if (firstnameRegisterField.getText().isEmpty()||lastnameRegisterField.getText().isEmpty()||usernameRegisterField.getText().isEmpty()||passwordRegisterField.getText().isEmpty()) {
            registerTextAlert.setFill(RED);
            registerTextAlert.setText("Please fill out your information completely");
            return;
        }
        JDBCDao jdbcDao = new JDBCDao();

        String FirstName = firstnameRegisterField.getText();
        String Lastname = lastnameRegisterField.getText();
        String Username = usernameRegisterField.getText();
        String Password = passwordRegisterField.getText();


        try {
            jdbcDao.insertRecord(FirstName, Lastname, Username, Password);
            int id_account = jdbcDao.getID();
            jdbcDao.insertUserInfo(" "," "," "," ",id_account);
            //System.out.println(id_account);
        }catch (Exception e){
            registerTextAlert.setText("This Username already exists !");
            e.printStackTrace();
        }


        if(jdbcDao.registerSuccess()==false){
            registerTextAlert.setFill(RED);
            registerTextAlert.setText("This Username already exists !");
        }else{
            try {

                registerTextAlert.setFill(GREEN);
                registerTextAlert.setText("Register Successful !");
            }catch (Exception e){
                e.printStackTrace();

            }

        }


    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
