package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyHelper extends DatabaseHelper {

    public FacultyHelper(){}

    private int getFacultyCount(){
        int i = 0;
        String query = "SELECT * FROM `faculty` ";
        ResultSet rs;
        this.openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                //System.out.println("Get there");
                i++;
            }
            //System.out.println(id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            return i;
        }

    }

    public String [] getFacultyList(){
        String [] facList = new String[this.getFacultyCount()];
        String query = "SELECT * FROM `faculty` ";
        ResultSet rs;
        this.openConnection();
        int i = 0;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                facList[i] = rs.getString("facName");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            return facList;
        }
    }
}
