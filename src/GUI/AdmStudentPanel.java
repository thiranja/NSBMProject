package GUI;

import Database.StudentHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmStudentPanel extends JPanel {

    StudentHelper studentHelper = new StudentHelper();

    private JTable studentTable;
    private JButton addStudent = new JButton("Add Student");

    public AdmStudentPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Creating the table of Student Data
        Object [] columnNames = {"ID","Name","Address","DOB","Faculty","Course"};
        studentTable = new JTable(studentHelper.GetStudentDetails(), columnNames);

        gc.weightx = 1;
        gc.weighty = 10;
        gc.gridx = 0;
        gc.gridy = 0;

        add(studentTable);

        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 0;

        add(addStudent);

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AddStudentFrame frame = new AddStudentFrame();
                        frame.setSize(600,800);
                        frame.setVisible(true);
                    }
                });
            }
        });
    }
}
