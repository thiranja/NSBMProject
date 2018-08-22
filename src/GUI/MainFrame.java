package GUI;

import Database.DatabaseHelper;
import Entity.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    DatabaseHelper helper = new DatabaseHelper();

    // GUI objects of the Class

    private JPanel login = new JPanel();
    private JPanel studentHome = new JPanel();
    private JPanel adminHome = new JPanel();

    // components of the login panel

    // Adding the Labels of the fields
    JLabel uname = new JLabel("Username: ");
    JLabel pass = new JLabel("Password: ");
    // Adding the fields
    JTextField unameFeild = new JTextField(20);
    JPasswordField passField = new JPasswordField(20);
    JLabel incLogin = new JLabel();
    JComboBox isAdmin = new JComboBox(new String [] {"Student", "Admin"});

    // Adding the button
    JButton logBtn = new JButton("Log In");


    // Components of the student home

    private StuSubjectPanel stuSubjectPanel = new StuSubjectPanel();
    private StuLecturePanel stuLecturePanel = new StuLecturePanel();
    private StuResultPanel stuResultPanel = new StuResultPanel();

    // Components of the admin home

    private AdmStudentPanel admStudentPanel = new AdmStudentPanel();
    private AdmCoursePanel admCoursePanel = new AdmCoursePanel();
    private AdmStaffPanel admStaffPanel = new AdmStaffPanel();

    // Constructor of the class

    public MainFrame(){
        super("NSBM System");

        // Calling setUp methods for Panels
        this.setUpLoginPanel();
        this.setUpAdminHomePanel();
        this.setUpStudentHomePanel();

        // Adding funtionality to logbtn

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //incLogin.setVisible(true);
                int selectedIndex = isAdmin.getSelectedIndex();
                String uname = unameFeild.getText();
                String pass = passField.getText();
                Login log = new Login(uname,pass,(selectedIndex == 1) );
                if (selectedIndex == 0){
                    int stdentId = helper.validateLogin(log);
                    if (stdentId == 0){
                        incLogin.setVisible(true);
                    } else{
                        remove(login);
                        add(studentHome);
                    }
                }else if(selectedIndex == 1){
                    int adminId = helper.validateLogin(log);
                    if (adminId == 0){
                        incLogin.setVisible(true);
                    }else{
                        remove(login);
                        add(adminHome);
                    }
                }
                revalidate();
                repaint();
            }
        });
        // Adding pannels to the MainFrame

        login.setVisible(true);
        studentHome.setVisible(true);
        adminHome.setVisible(true);

        this.setLayout(new BorderLayout());
        this.add(adminHome);
        this.add(studentHome);
        this.add(login);
    }

    private void setUpLoginPanel(){
        login.setPreferredSize(new Dimension(800,600));

        // Set the border with the login option
        login.setBorder(BorderFactory.createTitledBorder("Please Login to Continue..."));

        incLogin.setText("Incorrect Login!!!");
        incLogin.setVisible(false);
        //Setting the layout
        login.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        // Adding the first collumn

        gc.anchor = GridBagConstraints.LINE_END;

        login.add(uname, gc);
        gc.gridy= 1;
        login.add(pass,gc);

        //adding the second column

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        login.add(unameFeild,gc);
        gc.gridy = 1;
        login.add(passField, gc);

        // Add the Text view which is inisially hidden but display if incorrect login
        gc.gridy = 2;
        login.add(isAdmin, gc);
        gc.gridy = 3;
        login.add(incLogin,gc);

        // Final row with Log in Button
        gc.weighty = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 4;
        login.add(logBtn, gc);
    }

    private void setUpStudentHomePanel(){
        studentHome.setPreferredSize(new Dimension(800,600));
        studentHome.setBorder(BorderFactory.createTitledBorder("Student Home..."));
        //Setting the layout
        studentHome.setLayout(new BorderLayout());
        // Adding the Tabbed view
        JTabbedPane tp = new JTabbedPane();
        tp.add("Subjects", stuSubjectPanel);
        tp.add("Lecture", stuLecturePanel);
        tp.add("Result", stuResultPanel);
        studentHome.add(tp);
    }

    private void setUpAdminHomePanel(){
        // Setting up the Panel
        adminHome.setPreferredSize(new Dimension(800,600));
        adminHome.setBorder(BorderFactory.createTitledBorder("Admin Home..."));
        adminHome.setLayout(new BorderLayout());
        // Adding the tabbed view of panels
        JTabbedPane tp = new JTabbedPane();
        tp.add("Student", admStudentPanel);
        tp.add("Course", admCoursePanel);
        tp.add("Staff", admStaffPanel);
        adminHome.add(tp);
    }

}
