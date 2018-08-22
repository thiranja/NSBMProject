package Driver;

import Entity.Login;
import GUI.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String args[]){

        // Registering the mysql driver to run the sql queries
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Running the MainFrame GUI in another Tread

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
