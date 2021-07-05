package jtable.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayMultipleTables {

    // JTable table1 = makeTable(1);
    //JTable table2 = makeTable(2);
    //JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Container c = frame.getContentPane();
    //c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
    //c.add(table1.getTableHeader());
    //c.add(table1);
    //c.add(table2.getTableHeader());
    //c.add(table2);
    //frame.pack();
    //frame.setVisible(true);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MultipleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table1 = makeTableOne();
        JTable table2 = makeTableOne();

        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.add(table1.getTableHeader());
        c.add(table1);
        c.add(table2.getTableHeader());
        c.add(table2);

        frame.pack();
        frame.setVisible(true);
    }

    private static JTable makeTableOne() {
        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        //Add the scroll pane to this panel.
//        add(scrollPane);

        return table;
    }


}
