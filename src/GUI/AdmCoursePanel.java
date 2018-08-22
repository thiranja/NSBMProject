package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmCoursePanel extends JPanel {

    private JButton addSubject = new JButton("Add Subject");
    private JButton addCourse = new JButton("Add Course");

    public AdmCoursePanel(){

        // Setting the Layout and adding components
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.gridx = 0;

        add(addSubject, gc);
        gc.gridy = 1;

        add(addCourse, gc);

        // Adding action listners
        addSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AddSubjectFrame frame = new AddSubjectFrame();
                        frame.setSize(600,800);
                        frame.setVisible(true);
                    }
                });
            }
        });

        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AddCourseFrame frame = new AddCourseFrame();
                        frame.setSize(600,800);
                        frame.setVisible(true);
                    }
                });
            }
        });
    }
}
