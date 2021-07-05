package jtable.demo;

import javax.swing.*;

public class ManagerInterface {
    public JFrame frame;

    private ShowEmployee showEmployee;
    private JDesktopPane desktop;

    public ManagerInterface() {
        showEmployee = new ShowEmployee();
        desktop = new JDesktopPane();
        desktop.add(showEmployee);

        frame = new JFrame("Manager Interface");
        frame.setContentPane(desktop);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManagerInterface());
    }

}

class ShowEmployee extends JInternalFrame {

    String[][] data = {{"Hello", "Hello", "Hello"},
            {"Hello", "Hello", "Hello"}};
    String[] cols = {"Col 1", "Col 2", "Col 3"};

    public JTable table = new JTable(data, cols);

    public ShowEmployee() {

        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll);
        setTitle("Employees");
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        pack();
        setVisible(true);

    }
}
