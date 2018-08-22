package GUI;

import Database.FacultyHelper;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class AddCourseFrame extends JFrame {

    FacultyHelper facultyHelper = new FacultyHelper();

    // Components of the add Course frame

    private JLabel name = new JLabel("Course Name");
    private JTextField nameTextFeild = new JTextField(20);
    private JLabel years = new JLabel("No. of Years");
    private JFormattedTextField yearsTextFeild;
    private JLabel totalCredit = new JLabel("Total Credits");
    private JFormattedTextField totalCreditTextField;
    private JComboBox type = new JComboBox(new String[] {"Bachular", "Master"});
    private JComboBox faculty = new JComboBox(facultyHelper.getFacultyList());
    private JButton submit = new JButton("Submit");

    public AddCourseFrame(){
        // Setting the year and total credit text fields only acsept integers
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(4);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        yearsTextFeild = new JFormattedTextField(formatter);
        yearsTextFeild.setColumns(20);
        formatter.setMaximum(400);
        totalCreditTextField = new JFormattedTextField(formatter);
        totalCreditTextField.setColumns(20);

        // Setting the border and the layout of the frame
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Adding components to the frame
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 0;
        gc.gridy = 0;
        add(name,gc);
        gc.gridx = 1;
        add(nameTextFeild,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(years, gc);
        gc.gridx = 1;
        add(yearsTextFeild,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(totalCredit,gc);
        gc.gridx = 1;
        add(totalCreditTextField,gc);

        gc.gridy = 3;
        add(type,gc);
        gc.gridy = 4;
        add(faculty,gc);
        gc.gridy = 5;
        add(submit,gc);

        // Setting the action for the Submit button
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
