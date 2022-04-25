package com.example.covidapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    @FXML private Button goBack_info;
    @FXML private Button editUserInfo;
    @FXML public  Text dose1Text;
    @FXML public  Text dose2Text;
    @FXML public  Text dose3Text;
    @FXML public  Text dose4Text;
    @FXML public  Text usernameText;
    @FXML public  Text nameText;
    @FXML public  Text provinceText;
    @FXML public Button showButton;
    @FXML public Button hideButton;


    public void backButtonOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==goBack_info){
            stage = (Stage) goBack_info.getScene().getWindow();

            DBconnect_edit_info cRole = new DBconnect_edit_info();
            String role = cRole.getRole();
            root = FXMLLoader.load(getClass().getResource("main.fxml"));

        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void editUserInfoOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==editUserInfo){
            stage = (Stage) editUserInfo.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("EditInfo.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBconnect_edit_info show = new DBconnect_edit_info();
        String dose1 = null;
        String dose2 = null;
        String dose3 = null;
        String dose4 = null;
        String fname = null;
        String lname = null;
        String username = null;
        String province = null;
        String date1 = null;
        String date2 = null;
        String date3 = null;
        String date4 = null;
        try {
            dose1 = show.getDose1();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            dose2 = show.getDose2();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            dose3 = show.getDose3();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            dose4 = show.getDose4();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            fname = show.getFName();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            lname = show.getLName();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            username = show.getUsername();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            province = show.getProvince();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            date1 = show.getDate1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            date2 = show.getDate2();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            date3 = show.getDate3();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            date4 = show.getDate4();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nameText.setText("Name : "+fname+" "+lname);
        usernameText.setText("Username : "+username);
        provinceText.setText("Province : "+province);

        dose1Text.setText("1st Dose : "+date1+" "+dose1);
        dose2Text.setText("2nd Dose : "+date2+" "+dose2);
        dose3Text.setText("3rd Dose : "+date3+" "+dose3);
        dose4Text.setText("4th Dose : "+date4+" "+dose4);

    }


}
