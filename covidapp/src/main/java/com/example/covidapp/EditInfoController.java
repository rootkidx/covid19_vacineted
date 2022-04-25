package com.example.covidapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditInfoController implements Initializable {
    @FXML private Button editFName;
    @FXML private Button editLName;
    @FXML private Button editProvince;
    @FXML private Button editDose1;
    @FXML private Button editDose2;
    @FXML private Button editDose3;
    @FXML private Button editDose4;
    @FXML private Button backInEditInfo;
    @FXML private TextField province_TextField;
    @FXML private TextField firstName_TextField;
    @FXML private TextField lastName_TextField;
    @FXML private ChoiceBox<String> dose1ChoiceBox;
    @FXML private ChoiceBox<String> dose2ChoiceBox;
    @FXML private ChoiceBox<String> dose3ChoiceBox;
    @FXML private ChoiceBox<String> dose4ChoiceBox;
    @FXML private DatePicker date_dose1,date_dose2,date_dose3,date_dose4;
    private String[] vaccine = {"Pfizer","Moderna","Johnson & Johnson","Novavax","AstraZeneca","Sputnik-V","Sinovac","Sinopharm","CanSino","Covishield","Covaxin"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dose1ChoiceBox.getItems().addAll(vaccine);
        dose2ChoiceBox.getItems().addAll(vaccine);
        dose3ChoiceBox.getItems().addAll(vaccine);
        dose4ChoiceBox.getItems().addAll(vaccine);
    }

    public void editFNameOnAction(ActionEvent event) throws SQLException{
        Window owner = editFName.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String firstName = firstName_TextField.getText();
        //int id_account = editMyInfo.getID();

        System.out.println(firstName);
        //System.out.println(id_account);
        try {
            editMyInfo.editFname(firstName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editLNameOnAction(ActionEvent event) throws SQLException{
        Window owner = editLName.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String lastName = lastName_TextField.getText();
       // int id_account = editMyInfo.getID();

        System.out.println(lastName);
        //System.out.println(id_account);
        try {
            editMyInfo.editLname(lastName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editProvinceOnAction(ActionEvent event) throws SQLException{
        Window owner = editProvince.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String province = province_TextField.getText();
        //int id_account = editMyInfo.getID();

        System.out.println(province);
        //System.out.println(id_account);
        try {
            editMyInfo.editProvince(province);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editDose1OnAction(ActionEvent event) throws SQLException {
        Window owner = editDose1.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String dose1 = dose1ChoiceBox.getValue();
        String date1 = String.valueOf(date_dose1.getValue());

        //int id_account = editMyInfo.getID();

//        System.out.println(dose1);
//        System.out.println(id_account);
        try {
            editMyInfo.editDose1(dose1,date1);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void editDose2OnAction(ActionEvent event)throws SQLException{
        Window owner = editDose2.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String dose2 = dose2ChoiceBox.getValue();
        String date2 = String.valueOf(date_dose2.getValue());
        //int id_account = editMyInfo.getID();

//        System.out.println(dose2);
//        System.out.println(id_account);
        try {
            editMyInfo.editDose2(dose2,date2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void editDose3OnAction(ActionEvent event) throws SQLException{
        Window owner = editDose3.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String dose3 = dose3ChoiceBox.getValue();
        String date3 = String.valueOf(date_dose3.getValue());
        //int id_account = editMyInfo.getID();

//        System.out.println(dose3);
//        System.out.println(id_account);
        try {
            editMyInfo.editDose3(dose3,date3);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void editDose4OnAction(ActionEvent event) throws SQLException{
        Window owner = editDose4.getScene().getWindow();
        DBconnect_edit_info editMyInfo = new DBconnect_edit_info();

        String dose4 = dose4ChoiceBox.getValue();
        String date4 = String.valueOf(date_dose4.getValue());
       // int id_account = editMyInfo.getID();

        //System.out.println(dose4);
        //System.out.println(id_account);
        try {
            editMyInfo.editDose4(dose4,date4);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void backInEditInfoOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==backInEditInfo){
            stage = (Stage) backInEditInfo.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
