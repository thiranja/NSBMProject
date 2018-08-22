package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmStaffPanel extends JPanel {

    // Attributes of the staff panel

    private JButton addStaff = new JButton("Add Staff Member");

    public AdmStaffPanel(){
        // Setting the layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Adding the components
        gc.gridy = 0;
        gc.gridx = 0;

        add(addStaff,gc);

        // Setting the action for the button

        addStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AddStaffFrame frame = new AddStaffFrame();
                        frame.setSize(600,800);
                        frame.setVisible(true);
                    }
                });
            }
        });

    }
}
