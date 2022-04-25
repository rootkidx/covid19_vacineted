package com.example.covidapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    public Connection databaselink;

    public Connection getConnection()  {
        String databaseName ="covid";
        String databaseUser ="root";
        String databasePassword = "VwmCRG2nuWhGp9aA";
        //String databasePassword = "safireen456";
        String url = "jdbc:mysql://161.246.5.40:3777/"+databaseName;
        //String url = "jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaselink;
    }
}
