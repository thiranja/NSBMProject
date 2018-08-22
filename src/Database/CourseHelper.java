package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseHelper extends DatabaseHelper {

    private int getCourseCount(int facId){
        int i = 0;
        String query = "SELECT * FROM `course` WHERE `facId` = '"+ facId +"'";
        ResultSet rs;
        this.openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            return i;
        }
    }

    public String [] getCourseList(int facId){
        String [] courseList = new String[this.getCourseCount(facId)];
        int i = 0;
        String query = "SELECT * FROM `course` WHERE `facId` = '"+ facId +"'";
        ResultSet rs;
        this.openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                courseList[i] = rs.getString("courseName");
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            return courseList;
        }
    }
}
