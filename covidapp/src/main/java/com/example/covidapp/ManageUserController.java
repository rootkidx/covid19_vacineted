package com.example.covidapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.*;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class ManageUserController implements Initializable {
    @FXML private TextField addUsernameTextField;
    @FXML private TextField addPasswordTextField;
    @FXML private TextField addFnameTextField;
    @FXML private TextField addLnameTextField;
    @FXML private TextField removeIdTextField;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private Button backButton;
    @FXML private Text alertText;
    @FXML private Text alertEditRoleText;
    @FXML private Text alertRemoveText;
    @FXML private Button editRoleButton;
    @FXML private TextField editRoleUsernameTextField;

    @FXML private ChoiceBox<String> roleChoicebox;
    private String[] arrRole = {"member","staff","admin"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChoicebox.getItems().addAll(arrRole);
        DBconnect_edit_info cRole = new DBconnect_edit_info();
        String role = null;
        try {
            role = cRole.getRole();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(Objects.equals(role, "admin")){
            addButton.setDisable(false);
            removeButton.setDisable(false);
            editRoleButton.setDisable(false);
        }
        else if(Objects.equals(role, "staff"))
        {
            addButton.setDisable(false);
            removeButton.setDisable(false);
            editRoleButton.setDisable(true);
        }
    }
    public void findUser(){
        DatabaseConnect connectnow = new DatabaseConnect();
        Connection connectDB = connectnow.getConnection();

        String findUser = "SELECT count(1) FROM covid.account_login WHERE Username = '" +editRoleUsernameTextField.getText()+ "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(findUser);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    alertEditRoleText.setFill(GREEN);
                    alertEditRoleText.setText("The role has been changed.");
                }
                else{
                    alertEditRoleText.setFill(RED);
                   alertEditRoleText.setText("Username not found.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void findID(){
        DatabaseConnect connectnow = new DatabaseConnect();
        Connection connectDB = connectnow.getConnection();

        String findID = "SELECT count(1) FROM covid.account_login WHERE id = '" +removeIdTextField.getText()+ "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(findID);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    alertRemoveText.setFill(GREEN);
                    alertRemoveText.setText("The account has been deleted.");
                }
                else{
                    alertRemoveText.setFill(RED);
                    alertRemoveText.setText("ID not found.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addButtonOnAction(ActionEvent event) throws SQLException {
        Window owner = addButton.getScene().getWindow();

        System.out.println(addFnameTextField.getText());
        System.out.println(addLnameTextField.getText());
        System.out.println(addUsernameTextField.getText());
        System.out.println(addPasswordTextField.getText());
        if (addFnameTextField.getText().isEmpty()||addLnameTextField.getText().isEmpty()||addUsernameTextField.getText().isEmpty()||addPasswordTextField.getText().isEmpty()) {
            alertText.setFill(RED);
            alertText.setText("Please fill out your information completely");
            return;
        }
        JDBCDao jdbcDao = new JDBCDao();

        String FirstName = addFnameTextField.getText();
        String Lastname = addLnameTextField.getText();
        String Username = addUsernameTextField.getText();
        String Password = addPasswordTextField.getText();


        try {
            jdbcDao.insertRecord(FirstName, Lastname, Username, Password);
            int id_account = jdbcDao.getID();
            jdbcDao.insertUserInfo(" "," "," "," ",id_account);
        }catch (Exception e){
            alertText.setText("This Username already exists !");
            e.printStackTrace();
        }


        if(jdbcDao.registerSuccess()==false){
            alertText.setFill(RED);
            alertText.setText("This Username already exists !");
        }else{
            try {

                alertText.setFill(GREEN);
                alertText.setText("Register Successful !");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
         addFnameTextField.setText("");
         addLnameTextField.setText("");
         addUsernameTextField.setText("");
         addPasswordTextField.setText("");
    }
    public void removeButtonOnAction(ActionEvent event){
        Window owner = removeButton.getScene().getWindow();
        DBconnect_edit_info remove = new DBconnect_edit_info();

        int id = Integer.parseInt(removeIdTextField.getText());
        System.out.println(id);
        findID();
        try {
            remove.delUser(id);
            remove.delInfo(id);

        }catch (Exception e){
            e.printStackTrace();
        }
        removeIdTextField.setText("");

    }
    public void editRoleButtonOnAction(ActionEvent event){

        Window owner = editRoleButton.getScene().getWindow();
        DBconnect_edit_info editRole = new DBconnect_edit_info();

        String username = editRoleUsernameTextField.getText();
        String role = roleChoicebox.getValue();

        System.out.println(username);
        System.out.println(role);
        try {
            editRole.editRole(username,role);
            findUser();
        }catch (Exception e){
            e.printStackTrace();
        }
        editRoleUsernameTextField.setText("");

    }
    public void setAddButton() throws SQLException {
        DBconnect_edit_info cRole = new DBconnect_edit_info();
        String role = cRole.getRole();
        System.out.println(role);

        if(Objects.equals(role, "admin")){

            editRoleButton.setDisable(false);
            addButton.setDisable(false);
            removeButton.setDisable(false);
        }
        if(Objects.equals(role, "staff")){

            editRoleButton.setDisable(true);
            addButton.setDisable(false);
            removeButton.setDisable(false);
        }


    }
    public void backButtonOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==backButton){
            stage = (Stage) backButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
