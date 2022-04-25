package com.example.covidapp;

import java.sql.*;

public class DBconnect_edit_info {

    // Replace below database url, username and password with your actual database credentials
    String databaseName ="covid";
    String DATABASE_USERNAME ="root";
    String DATABASE_PASSWORD = "VwmCRG2nuWhGp9aA";
    //String DATABASE_PASSWORD = "safireen456";
    String DATABASE_URL = "jdbc:mysql://161.246.5.40:3777/"+databaseName;
    //String DATABASE_URL = "jdbc:mysql://localhost/"+databaseName;
    String UPDATE_DOSE1 = "UPDATE user_info SET dose1 = ? ,date_dose1 = ? WHERE id_account = "+UserData.id+";";
    String UPDATE_DOSE2 = "UPDATE user_info SET dose2 = ? ,date_dose2 = ? WHERE id_account = "+UserData.id+";";
    String UPDATE_DOSE3 = "UPDATE user_info SET dose3 = ? ,date_dose3 = ? WHERE id_account = "+UserData.id+";";
    String UPDATE_DOSE4 = "UPDATE user_info SET dose4 = ? ,date_dose4 = ? WHERE id_account = "+UserData.id+";";
    String UPDATE_FNAME = "UPDATE account_login SET FirstName = ? WHERE id = "+UserData.id+";";
    String UPDATE_LNAME = "UPDATE account_login SET LastName = ? WHERE id = "+UserData.id+";";
    String UPDATE_PV = "UPDATE user_info SET province = ? WHERE id_account = "+UserData.id+";";
    String UPDATE_ROLE = "UPDATE account_login SET Role = ? WHERE Username = ? ;";
    String DELETE_USER = "DELETE FROM account_login WHERE id = ?";
    String DELETE_INFO = "DELETE FROM user_info WHERE id_account = ?";

    ///////////////////////
    public void editDose1(String dose1,String date1 ) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOSE1)) {
            preparedStatement.setString(1, dose1);
            preparedStatement.setString(2, date1);
           // preparedStatement.setInt(3, id_account);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }
    public void editDose2(String dose2,String date2) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOSE2)) {
            preparedStatement.setString(1, dose2);
            preparedStatement.setString(2, date2);
            //preparedStatement.setInt(3, id_account);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }
    public void editDose3(String dose3,String date3) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOSE3)) {
            preparedStatement.setString(1, dose3);
            preparedStatement.setString(2, date3);
            //preparedStatement.setInt(3, id_account);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }
    public void editDose4(String dose4,String date4) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOSE4)) {
            preparedStatement.setString(1, dose4);
            preparedStatement.setString(2, date4);
            //preparedStatement.setInt(3, id_account);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }
    //////////////////////////////
    public void editFname(String FirstName ) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FNAME)) {
            preparedStatement.setString(1, FirstName);
            //preparedStatement.setInt(2, id);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }
    public void editLname(String LastName ) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LNAME)) {
            preparedStatement.setString(1, LastName);
            //preparedStatement.setInt(2, id);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }
    public void editProvince(String province ) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PV)) {
            preparedStatement.setString(1, province);
            //preparedStatement.setInt(2, id);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }
    public void editRole(String username, String role) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE)) {
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, username);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

    }
    public void delUser(int id) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    public void delInfo(int id) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_INFO)) {
            preparedStatement.setInt(1, id);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();


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
//    public int getID() throws SQLException{
//        Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "safireen456");
//        int return_id = -1;
//        String username = getUsername();
//        System.out.println(username);
//        try
//        {
//            String query = "SELECT * FROM account_login WHERE Username = '"+username+"'";
//
//
//
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//            // iterate through the java resultset
//            while (rs.next())
//            {
//                return_id = rs.getInt("id");
//            }
//            st.close();
//        }
//        catch (Exception e)
//        {
//            System.err.println("Got an exception! ");
//            System.err.println(e.getMessage());
//        }
//        return return_id;
//    }
    public String getDose1() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_dose1 ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_dose1 = rs.getString("dose1");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_dose1;
    }
    public String getDose2() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_dose2 ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_dose2 = rs.getString("dose2");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_dose2;
    }
    public String getDose3() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_dose3 ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_dose3 = rs.getString("dose3");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_dose3;
    }
    public String getDose4() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_dose4 ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_dose4 = rs.getString("dose4");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_dose4;
    }

    public String getFName() throws  SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_fname ="";
        try
        {
            String query = "SELECT * FROM account_login WHERE id = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_fname = rs.getString("FirstName");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_fname;

    }
    public String getLName() throws  SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_lname ="";
        try
        {
            String query = "SELECT * FROM account_login WHERE id = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_lname = rs.getString("LastName");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_lname;

    }
    public String getProvince() throws SQLException{

            Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            String return_pv ="";
            try
            {
                String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.next())
                {
                    return_pv = rs.getString("province");
                }
                st.close();
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
            return return_pv;

        }

    public String getUsername() throws SQLException{

        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_user ="";
        try
        {
            String query = "SELECT * FROM account_login WHERE id = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_user = rs.getString("Username");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_user;

    }
    public String getRole() throws SQLException{
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_role ="";
        try
        {
            String query = "SELECT * FROM account_login WHERE id = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_role = rs.getString("Role");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_role;
    }
    public String getDate1() throws SQLException {
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_date ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_date = rs.getString("date_dose1");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_date;
    }
    public String getDate2() throws SQLException {
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_date ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_date = rs.getString("date_dose2");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_date;
    }
    public String getDate3() throws SQLException {
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_date ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_date = rs.getString("date_dose3");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_date;
    }
    public String getDate4() throws SQLException {
        Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        String return_date ="";
        try
        {
            String query = "SELECT * FROM user_info WHERE id_account = "+UserData.id+";";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                return_date = rs.getString("date_dose4");
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return return_date;
    }





}