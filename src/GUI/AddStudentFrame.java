package GUI;

import Database.CourseHelper;
import Database.DatabaseHelper;
import Database.FacultyHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentFrame extends JFrame {

    FacultyHelper facultyHelper = new FacultyHelper();
    CourseHelper courseHelper = new CourseHelper();

    // panels needed for the add Student frame

    private JPanel basic = new JPanel();
    private JPanel undergraduate = new JPanel();
    private JPanel postGraduate = new JPanel();

    // components of the basic panel

    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameField = new JTextField(20);
    private JLabel addressLabel = new JLabel("Address");
    private JTextField addressField = new JTextField(20);
    private JLabel dobLabel = new JLabel("Date of Birth");
    private JTextField dobField = new JTextField(20);
    private JComboBox facultyList = new JComboBox(facultyHelper.getFacultyList());
    private JComboBox courseList = new JComboBox();
    private JComboBox graguate = new JComboBox(new String [] {"UnderGraguate", "PostGraduate"});
    private JButton basicNentBtn = new JButton("Next");

    public AddStudentFrame(){
        //setSize(new Dimension(600,900));
        setBasicPanel();
        setLayout(new CardLayout());

        undergraduate.setVisible(false);
        postGraduate.setVisible(false);

        add(basic);
        add(undergraduate);
        add(postGraduate);
        facultyList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseList.removeAllItems();
                int facId = facultyList.getSelectedIndex() + 1;
                for (String course : courseHelper.getCourseList(facId)){
                    courseList.addItem(course);
                }
                revalidate();
                repaint();
            }
        });
        basicNentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int graId = graguate.getSelectedIndex();
                if (graId == 0){
                    setUnderGraduatePanel();
                    undergraduate.setVisible(true);
                    basic.setVisible(false);
                }else{
                    setPostGraduatePanel();
                    postGraduate.setVisible(true);
                    basic.setVisible(false);
                }
                revalidate();
                repaint();
            }
        });
    }

    private void setBasicPanel(){
        // Setting the Border
        basic.setBorder(BorderFactory.createTitledBorder("Basic Info..."));
        // Seting the layout
        basic.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        // Adding the components to the panel
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        basic.add(nameLabel, gc);
        gc.gridx = 1;
        basic.add(nameField, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        basic.add(addressLabel, gc);
        gc.gridx = 1;
        basic.add(addressField, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        basic.add(dobLabel, gc);
        gc.gridx = 1;
        basic.add(dobField, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        basic.add(facultyList, gc);
        gc.gridy = 4;
        basic.add(courseList, gc);
        gc.gridy = 5;
        basic.add(graguate, gc);
        gc.gridy = 6;
        basic.add(basicNentBtn, gc);
    }

    private void setUnderGraduatePanel(){
        // Setting the border
        undergraduate.setBorder(BorderFactory.createTitledBorder("UnderGraguate Details..."));
    }

    private void setPostGraduatePanel(){
        // Setting the border
        postGraduate.setBorder(BorderFactory.createTitledBorder("PostGraduguate Details..."));
    }
}
