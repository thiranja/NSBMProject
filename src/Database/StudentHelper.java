package Database;

import Entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentHelper extends DatabaseHelper {

    public void addNewStudent(Student student){
        String query = "INSERT INTO `student` (`name`, `address`, 'dob', 'facId', 'courseId') VALUES ('" + student.getName() + "', '" + student.getAddress() + "', '" + student.getDob() +"','" + student.getFacId()+ "','"+ student.getCourseId() +"')";
        dbInserter(query);
        // Making the connection
    }

    private int getStudentCount(){
        String query = "SELECT * FROM `student` ";
        int i = 0;
        ResultSet rs;
        openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()){
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
            return i;
        }

    }

    public Object [][] GetStudentDetails(){
        String query = "SELECT * FROM `student` ";
        Object [][] stuData = new String [this.getStudentCount()][6];
        int i = 0;
        ResultSet rs;
        openConnection();
        try {
            rs = statement.executeQuery(query);
            while (rs.next()){
                stuData[i][0] = rs.getString("stdId");
                stuData[i][1] = rs.getString("name");
                stuData[i][2] = rs.getString("address");
                stuData[i][3] = rs.getString("dob");
                stuData[i][4] = rs.getString("facId");
                stuData[i][5] = rs.getString("courseId");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
            return stuData;
        }
    }
}
