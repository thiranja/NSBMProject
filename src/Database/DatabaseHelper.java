package Database;

import Entity.Login;
import com.mysql.jdbc.ResultSetImpl;

import java.sql.*;

public class DatabaseHelper {

    protected Connection connection;
    protected Statement statement;

    // making connections within a constructor could be unsafe
    // so use private methods to open and close connection instead


    protected void openConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/nsbm_database", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    *
    * Methods about adding and validating logins to the system
    *
    * */

    public void addNewStudentLogin(Login login){
        String query = "INSERT INTO `student_login` (`id`, `name`, `password`) VALUES ('" + login.getId() + "', '" + login.getUname() + "', '"+ login.getPass() +"')";
        // Making the connection
        this.openConnection();
        try {
            statement.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    public int validateLogin(Login login){
        String query;
        if (login.isAdmin()){
            query = "SELECT * FROM `admin_login` WHERE `name` = '"+ login.getUname() +"' AND `password` = '"+login.getPass()+"' ";
        }else{
            query = "SELECT * FROM `student_login` WHERE `name` = '"+ login.getUname() +"' AND `password` = '"+login.getPass()+"' ";
        }
        ResultSet rs;
        int id = 0;

        this.openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            return id;
        }
    }

    public void dbInserter(String query){
        this.openConnection();
        try {
            statement.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConnection();
        }
    }

    /*public ResultSet dbGetter(String query){
        ResultSet rs;

        this.openConnection();
        try {
            rs = statement.executeQuery(query);
            this.closeConnection();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
