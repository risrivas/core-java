package jtable.demo;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Enumeration;
import java.util.HashMap;

public class TableSortDemoWithSerialization extends JPanel {
    private JTable table;
    private String username = System.getProperty("user.name");

    public TableSortDemoWithSerialization() {
        super(new GridLayout(1, 0));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Before exiting, save the table columns index to file");
            try {
                saveTableModelToFile(new File(username + ".ser"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        MyTableModel tableModel = null;
        try {
            tableModel = loadTableModelFromFile(new File(username + ".ser"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (tableModel == null) {
            tableModel = new MyTableModel();
        }
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        // set color and fonts
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.YELLOW);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setShowGrid(true);
        table.setGridColor(Color.WHITE);

        // this line creates sorting of columns
        table.setAutoCreateRowSorter(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TableSortDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TableSortDemoWithSerialization newContentPane = new TableSortDemoWithSerialization();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    private MyTableModel loadTableModelFromFile(File file) throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            System.out.println("file does not exists, return null");
            return null;
        }

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

        MyTableModel tableModel = new MyTableModel();
        HashMap<String, Integer> mapSaved = (HashMap) input.readObject();
        if (mapSaved == null || mapSaved.size() == 0) return null;

        String[] headersArray = new String[mapSaved.size()];
        for (String header : mapSaved.keySet()) {
            int idx = mapSaved.get(header);
            headersArray[idx] = header;
        }

        tableModel.setColumnNames(headersArray);
        tableModel.fireTableStructureChanged();
        tableModel.clearData();
        tableModel.fireTableDataChanged();
        return tableModel;
    }

    private void saveTableModelToFile(File file) throws IOException {
        TableColumnModel columnModel = table.getColumnModel();
        HashMap<String, Integer> mapToSave = new HashMap<>();

        Enumeration<TableColumn> columns = columnModel.getColumns();
        int idx = 0;
        while (columns.hasMoreElements()) {
            TableColumn column = columns.nextElement();
            String colHeader = String.valueOf(column.getHeaderValue());
            mapToSave.put(colHeader, idx);
            idx++;
        }

        ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(file));
        fileOut.writeObject(mapToSave);
        fileOut.close();
        System.out.println("Write done");
    }

    class MyTableModel extends AbstractTableModel {
        public MyTableModel() {
        }

        private String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian",
                "DOB"};
        private Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false), LocalDate.of(1983, Month.APRIL, 21)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true), LocalDate.of(1987, Month.JANUARY, 2)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false), LocalDate.of(1982, Month.JUNE, 14)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true), LocalDate.of(1990, Month.NOVEMBER, 19)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false), LocalDate.of(1995, Month.AUGUST, 8)}
        };

        public void clearData() {
            data = new Object[0][columnNames.length];
        }

        public void setColumnNames(String[] columnNames) {
            this.columnNames = columnNames;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            /*if (col < 2) {
                return false;
            } else {
                return true;
            }*/
            return false;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
        }

    }
}
