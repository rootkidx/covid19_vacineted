package com.example.covidapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button loginInLoginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passField;
    @FXML
    private Text errorLoginText;
    @FXML
    private Button registerInLoginButton;



    public void loginButtonOnAction(ActionEvent event) throws SQLException {

        if (usernameField.getText().isBlank()==true && passField.getText().isBlank()==true){
            errorLoginText.setVisible(true);
            errorLoginText.setText("Please Enter Username and Password!");
        }
        else{
            //saveUser();
            //String GET_USERNAME = "SELECT * FROM covid.account_login WHERE Username = "+usernameField.getText()+";";

            validateLogin(event);



        }

    }
    public void loginSuccess(ActionEvent event)throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==loginInLoginButton){

            stage = (Stage) loginInLoginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("main.fxml"));


        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void validateLogin(ActionEvent event)  {
        DatabaseConnect connectnow = new DatabaseConnect();
        Connection connectDB = connectnow.getConnection();

        String verifyLogin = "SELECT * FROM covid.account_login WHERE Username = '" +usernameField.getText()+ "' AND Password = '" +passField.getText()+ "'";
        System.out.println(verifyLogin);
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            boolean isSuccess = queryResult.next();
            if(!isSuccess){
                errorLoginText.setText("Username or Password is wrong!");
            }
            else {
                UserData.id = queryResult.getInt("id");
                //System.out.println(UserData.id);
                loginSuccess(event);
            }
//                if(queryResult.getInt(1)==1){
//                    loginSuccess(event);
//                }
//                else{
//                    errorLoginText.setText("Username or Password is wrong!");
//                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void registerButtonOnAction(ActionEvent event) throws Exception  {
        //System.out.println("register click");
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==registerInLoginButton){
            stage = (Stage) registerInLoginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
//    public void saveUser() throws SQLException{
//        String databaseName ="covid";
//        String DATABASE_USERNAME ="root";
//        String DATABASE_PASSWORD = "safireen456";
//        String DATABASE_URL = "jdbc:mysql://localhost/"+databaseName;
//        String SAVE_USER = "UPDATE save SET save_user = ? WHERE id = 1;";
//
//        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {
//            preparedStatement.setString(1, usernameField.getText());
//
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            preparedStatement.executeUpdate();
//
//
//        } catch (SQLException e) {
//            // print SQL exception information
//            e.printStackTrace();
//        }
//    }
    }


