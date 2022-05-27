package com.example.covidapp;
        

import java.sql.SQLException;
        import java.util.Objects;
        import java.util.ResourceBundle;

        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;
        import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.net.URL;

public class NewsController implements Initializable
{
    @FXML
    Label new_case ;
    @FXML
    Label new_death;
    @FXML
    Label new_recovered;
    @FXML
    Label total_recovered;
    @FXML
    Label total_death;
    @FXML
    Label total_case;
    @FXML
    Label title;
    @FXML
    Label day;
    @FXML
    Label newcase ;
    @FXML
    Label newdeath;
    @FXML
    Label newrecovered;
    @FXML
    Label totalrecovered;
    @FXML
    Label totaldeath;
    @FXML
    Label totalcase;
    @FXML
    Label languagee;
    @FXML
    ChoiceBox<String> Choice ;
    @FXML
    ChoiceBox<String> dayChoice ;
    @FXML Label person1,person2,person3,person4,person5,person6;
    @FXML Button logOutButton,userInfoButton,manageButton;
    String[] language = {"Thai","English"};
    String[] dayCh = {"ตั้งเเต่เริ่มระบาด","ตั้งแต่ 1 เม.ย. 2564","ตั้งแต่ 1 ม.ค. 2565",};


    API api = new API("https://covid19.ddc.moph.go.th/api/Cases/today-cases-all");

    JSONObject data = api.getJsonObject(0);


    @Override
    public void initialize(URL arg0,ResourceBundle arg1)
    {
        DBconnect_edit_info cRole = new DBconnect_edit_info();
        String role = null;
        try {
            role = cRole.getRole();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Choice.getItems().addAll(language);
        Choice.setOnAction(this::changelang);

        day.setText("ข้อมูลวันที่ "+data.get("txn_date"));
        new_case.setText(""+data.get("new_case"));
        new_death.setText(""+data.get("new_death"));
        new_recovered.setText(""+data.get("new_recovered"));
        total_recovered.setText(""+data.get("total_recovered"));
        total_death.setText(""+data.get("total_death"));
        total_case.setText(""+data.get("total_case"));
        if(Objects.equals(role, "admin")||Objects.equals(role, "staff")){
            manageButton.setVisible(true);
        }
        else
        {
            manageButton.setVisible(false);
        }
    }


    public void changelang(ActionEvent e)
    {
        if(!(Choice.getValue()=="Thai"))
        {
            title.setText("COVID-19 IN THAILAND UPDATE");
            day.setText("DATE :  "+data.get("txn_date"));
            newcase.setText("New Case");
            newdeath.setText("New Death");
            newrecovered.setText("New Recovered");
            totalrecovered.setText("Total Recovered");
            totaldeath.setText("Total Death");
            totalcase.setText("Total Case");
            languagee.setText("Language");
            person1.setText("Person");
            person2.setText("Person");
            person3.setText("Person");
            person4.setText("Person");
            person5.setText("Person");
            person6.setText("Person");

        }
        else
        {
            title.setText("สถานการณ์ COVID-19 ในประเทศไทย");
            day.setText("ข้อมูลวันที่ "+data.get("txn_date"));
            newcase.setText("ผู้ป่วยรายใหม่ในวันนี้");
            newdeath.setText("เสียชีวิตวันนี้");
            newrecovered.setText("หายป่วยวันนี้");
            totalrecovered.setText("หายป่วยสะสม");
            totaldeath.setText("เสียชีวิตสะสม");
            totalcase.setText("ผู้ป่วยสะสม");
            languagee.setText("ภาษา");
            person1.setText("คน");
            person2.setText("คน");
            person3.setText("คน");
            person4.setText("คน");
            person5.setText("คน");
            person6.setText("คน");
        }
    }
    public void logOut(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==logOutButton){
            stage = (Stage) logOutButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void userInfoButtonOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        //System.out.println(UserData.id);
        if(event.getSource()==userInfoButton){
            stage = (Stage) userInfoButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));

        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void manageButtonOnAction(ActionEvent event) throws Exception{
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==manageButton){
            stage = (Stage) manageButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ManageUser.fxml"));

        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
