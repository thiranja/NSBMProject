package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuSubjectPanel extends JPanel {

    // Components of  the Student Subject Panel

    private JButton selectSub = new JButton("Select Subjects");

    public StuSubjectPanel(){

        // Setting the layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;

        add(selectSub,gc);

        // Adding action for the buttons
        selectSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StuSelectSubFrame frame = new StuSelectSubFrame();
                frame.setSize(600,800);
                frame.setVisible(true);
            }
        });
    }
}
