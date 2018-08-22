package Entity;

public class Login {

    // Attributes of the class
    private int id;
    private String uname;
    private String pass;
    private boolean isAdmin;


    // Constructors of the class
    public Login(String uname, String pass, boolean isAdmin) {
        this.uname = uname;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public Login(int id, String uname, String pass, boolean isAdmin) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public Login(){}

    // getters and setters of the class

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {

        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
