package Entity;

public class Subject {

    private int subId;
    private String name;
    private int isPractical;
    private int isTheory;
    private int price;
    private int courseId;
    private int facId;

    public Subject() {
    }

    public Subject(int subId, String name, int isPractical, int isTheory, int price, int courseId, int facId) {
        this.subId = subId;
        this.name = name;
        this.isPractical = isPractical;
        this.isTheory = isTheory;
        this.price = price;
        this.courseId = courseId;
        this.facId = facId;
    }

    // Getter and Setters


    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsPractical() {
        return isPractical;
    }

    public void setIsPractical(int isPractical) {
        this.isPractical = isPractical;
    }

    public int getIsTheory() {
        return isTheory;
    }

    public void setIsTheory(int isTheory) {
        this.isTheory = isTheory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }
}
