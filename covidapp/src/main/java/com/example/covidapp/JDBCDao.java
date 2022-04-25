package com.example.covidapp;

import java.sql.*;

public class JDBCDao {

    // Replace below database url, username and password with your actual database credentials
    String databaseName ="covid";
    String DATABASE_USERNAME ="root";
    String DATABASE_PASSWORD = "VwmCRG2nuWhGp9aA";
    //String DATABASE_PASSWORD = "safireen456";
    String DATABASE_URL = "jdbc:mysql://161.246.5.40:3777/"+databaseName;
    //String DATABASE_URL = "jdbc:mysql://localhost/"+databaseName;
    String INSERT_QUERY = "INSERT INTO account_login (FirstName,Lastname,Username,Password) VALUES (?, ?, ? , ?);";
    String INSERT_INFO = "INSERT INTO user_info (dose1,dose2,dose3,dose4,id_account) VALUES (?, ?, ? , ?, ?);";
    boolean register=true;

    //==== create account in account_login table ====//
    public void insertRecord(String FirstName, String Lastname, String Username,String Password) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, Lastname);
            preparedStatement.setString(3, Username);
            preparedStatement.setString(4, Password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            register = true;

        } catch (SQLException e) {
            // print SQL exception information
            register = false;
            printSQLException(e);
        }
    }

    // ===== create blank data in user_info table =====//
    public void insertUserInfo(String dose1, String dose2, String dose3,String dose4,int id_account) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INFO)) {
            preparedStatement.setString(1, dose1);
            preparedStatement.setString(2, dose2);
            preparedStatement.setString(3, dose3);
            preparedStatement.setString(4, dose4);
            preparedStatement.setInt(5, id_account);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information

            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public boolean registerSuccess(){
        return register;
    }

    public int getID() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, "root", DATABASE_PASSWORD);
        int return_id = -1;

        try
        {
            String query = "SELECT * FROM account_login ";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_id = rs.getInt("id");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_id;
    }
}