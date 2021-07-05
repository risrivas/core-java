package jtable.demo;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CheckInInformationFrame {
    public JFrame makeGUI() throws IOException {


        JFrame frame = new JFrame();

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        /*
        KeyStroke keystroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        frame.getRootPane().registerKeyboardAction(actionListener, keystroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        */
        String[] columnNames = {"Aircompany", "Flight", "Time", "Destination", "Desc", "Status"};

        Object[][] data = {
                {"Mary", "Campione", "Snowboarding", new Integer(5), new Boolean(false), "Check-in"},
                {"Kathy", "Walrath", "Knitting", new Integer(2), new Boolean(false), "Check-in"},
                {"Sharon", "Zakhour", "Speed reading", new Integer(20), new Boolean(true), "Check-in"},
                {"Philip", "Milne", "Pool", new Integer(10), new Boolean(false), "Check-in"},
                {"Philip", "Milne", "Pool", new Integer(10), new Boolean(false), "Check-in"},
                {"Philip", "Milne", "Pool", new Integer(10), new Boolean(false), "Check-in"}
        };

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        //scrollPane.add(table);
        frame.add(scrollPane);

        return frame;
    }

    public CheckInInformationFrame() {

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CheckInInformationFrame app = new CheckInInformationFrame();

            JFrame f = null;
            try {
                f = app.makeGUI();
            } catch (IOException e5) {
                // TODO Auto-generated catch block
                e5.printStackTrace();
            }
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            File file = new File("frame.ser");
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e4) {
                // TODO Auto-generated catch block
                e4.printStackTrace();
            }
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(fos);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }
            try {
                oos.writeObject(f);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });


    }
}
