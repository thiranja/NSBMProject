package Entity;

public class Student {

    // Attributes of Student class
    private int stdId;
    private String name;
    private String address;
    private String dob;
    private int facId;
    private int courseId;
    private String finalGrade;

    public Student() {
    }

    public Student(int stdId, String name, String address, String dob, int facId, int courseId) {
        this.stdId = stdId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.facId = facId;
        this.courseId = courseId;
    }

    public Student(int stdId, String name, String address, String dob, int facId, int courseId, String finalGrade) {
        this.stdId = stdId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.facId = facId;
        this.courseId = courseId;
        this.finalGrade = finalGrade;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }
}
