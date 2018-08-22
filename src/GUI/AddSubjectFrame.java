package GUI;

import Database.CourseHelper;
import Database.FacultyHelper;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class AddSubjectFrame extends JFrame {

    FacultyHelper facultyHelper = new FacultyHelper();
    CourseHelper courseHelper = new CourseHelper();

    // Components of the add Student frame

    private JLabel name = new JLabel("Name");
    private JTextField nameTF = new JTextField(20);
    private JLabel price = new JLabel("Price");
    private JFormattedTextField priceTF;
    private JComboBox pracOrTheory = new JComboBox(new String[]{"Theory","Practical"});
    private JComboBox facultyList = new JComboBox(facultyHelper.getFacultyList());
    private JComboBox courseList = new JComboBox();
    private JButton submitBtn = new JButton("Submit");

    public AddSubjectFrame(){

        // Making the price text field only acsept numbers
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        //formatter.setMinimum(0);
        formatter.setMaximum(5000);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        priceTF = new JFormattedTextField(formatter);
        priceTF.setColumns(20);

        // Setting the layout of the frame
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Adding components to the frame
        gc.weighty = 2;
        gc.weightx = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(name,gc);
        gc.gridx = 1;
        add(nameTF,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(price,gc);
        gc.gridx = 1;
        add(priceTF,gc);

        gc.gridy = 2;
        add(pracOrTheory,gc);
        gc.gridy = 3;
        add(facultyList,gc);
        gc.gridy = 4;
        add(courseList,gc);
        gc.gridy = 5;
        add(submitBtn, gc);

        // Making couselist update according to the faculty
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

        // Adding action for the submit button
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
