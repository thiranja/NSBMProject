package Entity;

public class Course {

    private int courseId;
    private String name;
    private int years;
    private String type;
    private int totalCredits;
    private int facId;

    public Course() {
    }

    public Course(int courseId, String name, int years, String type, int totalCredits, int facId) {
        this.courseId = courseId;
        this.name = name;
        this.years = years;
        this.type = type;
        this.totalCredits = totalCredits;
        this.facId = facId;
    }

    // Getters and setters


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }
}
