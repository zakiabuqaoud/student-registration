import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GetDetailsUser extends JFrame implements ActionListener {

    Container container;

    String[] levels = {"A1", "A2", "B1", "B2", "C1", "C2"};

    DefaultTableModel levelModel, paymentModel;
    JTable levelsTable, paymentsTable;
    JScrollPane levelScroll, paymentScroll;

    JButton addLevelButton, updateLevelButton, deleteLevelButton, addPaymentButton, updatePaymentButton, deletePaymentButton, backButton, choosePaymentDateButton;
    JLabel titleLabel, levelLabel, paymentLabel, paymentDateLabel;

    JTextField paymentTextField, paymentDateTextField;

    JComboBox levelsCompoBox;

    String studentName;
    String studentID;
    String levelName;
    GetAllStudentGui prop;

    public GetDetailsUser(GetAllStudentGui prop, String id, String name) {
        this.prop = prop;
        container = getContentPane();

        this.studentID = id;
        this.studentName = name;

        setTitle("Students Details");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(true);
        container.setBackground(Theme.lightBlueColor);


        // JTable
        levelModel = new DefaultTableModel();
        levelsTable = new JTable(levelModel);
        levelScroll = new JScrollPane(levelsTable);

        paymentModel = new DefaultTableModel();
        paymentsTable = new JTable(paymentModel);
        paymentScroll = new JScrollPane(paymentsTable);

        levelScroll.setBounds(30, 274, 320, 250);
        paymentScroll.setBounds(400, 274, 570, 250);

        container.add(levelScroll);
        container.add(paymentScroll);

        levelModel.addColumn("Level");
        ArrayList<String> levelsForStudent = FileOperation.displayLevels(studentID);
        for (String string : levelsForStudent) {
            levelModel.addRow(new Object[]{string});
        }


        paymentModel.addColumn("Payment");
        paymentModel.addColumn("Payment Date");

        //JLabel
        titleLabel = new JLabel(studentName);
        titleLabel.setFont(Theme.bigFont);
        titleLabel.setForeground(Theme.blackColor);

        levelLabel = new JLabel("Level");
        levelLabel.setFont(Theme.smallFont);
        levelLabel.setForeground(Theme.blackColor);

        paymentLabel = new JLabel("Payment");
        paymentLabel.setFont(Theme.smallFont);
        paymentLabel.setForeground(Theme.blackColor);

        paymentDateLabel = new JLabel("Payment Date");
        paymentDateLabel.setFont(Theme.smallFont);
        paymentDateLabel.setForeground(Theme.blackColor);

        titleLabel.setBounds(350, 25, 554, 52);
        levelLabel.setBounds(30, 140, 150, 28);
        paymentLabel.setBounds(400, 140, 91, 28);
        paymentDateLabel.setBounds(677, 140, 141, 28);

        container.add(titleLabel);
        container.add(levelLabel);
        container.add(paymentLabel);
        container.add(paymentDateLabel);

        //JTextField

        paymentTextField = new JTextField();
        paymentTextField.setBackground(Theme.whiteColor);
        paymentTextField.setForeground(Theme.blackColor);
        paymentTextField.setFont(Theme.inputColor);

        paymentDateTextField = new JTextField();
        paymentDateTextField.setBackground(Theme.whiteColor);
        paymentDateTextField.setForeground(Theme.blackColor);
        paymentDateTextField.setFont(Theme.inputColor);

        paymentTextField.setBounds(497, 140, 165, 28);
        paymentDateTextField.setBounds(810, 140, 115, 28);

        container.add(paymentTextField);
        container.add(paymentDateTextField);

        //JCompoBox
        levelsCompoBox = new JComboBox<String>();
        levelsCompoBox.setModel(new DefaultComboBoxModel(levels));
        levelsCompoBox.setBounds(140, 140, 140, 28);
        container.add(levelsCompoBox);

        //JButton
        addLevelButton = new JButton("Add");
        addLevelButton.setBackground(Theme.lightBrownColor);
        addLevelButton.setForeground(Theme.blackColor);
        addLevelButton.setFont(Theme.smallFont);

        updateLevelButton = new JButton("Update");
        updateLevelButton.setBackground(Theme.lightBrownColor);
        updateLevelButton.setForeground(Theme.blackColor);
        updateLevelButton.setFont(Theme.smallFont);

        deleteLevelButton = new JButton("Delete");
        deleteLevelButton.setBackground(Theme.lightBrownColor);
        deleteLevelButton.setForeground(Theme.blackColor);
        deleteLevelButton.setFont(Theme.smallFont);

        addPaymentButton = new JButton("Add Payment");
        addPaymentButton.setBackground(Theme.lightBrownColor);
        addPaymentButton.setForeground(Theme.blackColor);
        addPaymentButton.setFont(Theme.smallFont);

        updatePaymentButton = new JButton("Update Payment");
        updatePaymentButton.setBackground(Theme.lightBrownColor);
        updatePaymentButton.setForeground(Theme.blackColor);
        updatePaymentButton.setFont(Theme.smallFont);

        deletePaymentButton = new JButton("Delete Payment");
        deletePaymentButton.setBackground(Theme.lightBrownColor);
        deletePaymentButton.setForeground(Theme.blackColor);
        deletePaymentButton.setFont(Theme.smallFont);

        backButton = new JButton("Back");
        backButton.setBackground(Theme.lightBrownColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);

        choosePaymentDateButton = new JButton("+");
        choosePaymentDateButton.setBackground(Theme.lightBrownColor);
        choosePaymentDateButton.setForeground(Theme.blackColor);

        addLevelButton.setBounds(30, 216, 100, 28);
        updateLevelButton.setBounds(140, 216, 100, 28);
        deleteLevelButton.setBounds(250, 216, 100, 28);
        addPaymentButton.setBounds(400, 216, 190, 28);
        updatePaymentButton.setBounds(600, 216, 190, 28);
        deletePaymentButton.setBounds(800, 216, 170, 28);
        backButton.setBounds(815, 580, 150, 28);
        choosePaymentDateButton.setBounds(925, 140, 45, 28);

        container.add(addLevelButton);
        container.add(updateLevelButton);
        container.add(deleteLevelButton);
        container.add(addPaymentButton);
        container.add(updatePaymentButton);
        container.add(deletePaymentButton);
        container.add(backButton);
        container.add(choosePaymentDateButton);

        addLevelButton.addActionListener(this);
        updateLevelButton.addActionListener(this);
        deleteLevelButton.addActionListener(this);
        addPaymentButton.addActionListener(this);
        updatePaymentButton.addActionListener(this);
        deletePaymentButton.addActionListener(this);
        backButton.addActionListener(this);
        choosePaymentDateButton.addActionListener(this);

        levelsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String name = levelModel.getValueAt(levelsTable.getSelectedRow(), 0).toString();
                levelName = name;
            }
        });

        paymentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == choosePaymentDateButton) {
            paymentDateTextField.setText(new DatePicker(this).setPickedDate());
        }
        //add, delete for Level
        if (event.getSource() == addLevelButton) {
            if (levelsCompoBox.getSelectedItem().toString() == "A1") {
                if (FileOperation.levelIsExist("1", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"A1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "1", studentID);
                    level.addLevelInFile(level);
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "A2") {
                if (FileOperation.levelIsExist("2", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"A2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "2", studentID);
                    level.addLevelInFile(level);
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "B1") {
                if (FileOperation.levelIsExist("3", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"B1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "3", studentID);
                    level.addLevelInFile(level);
                }

            } else if (levelsCompoBox.getSelectedItem().toString() == "B2") {
                if (FileOperation.levelIsExist("4", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"B2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "4", studentID);
                    level.addLevelInFile(level);
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "C1") {
                if (FileOperation.levelIsExist("5", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"C1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "5", studentID);
                    level.addLevelInFile(level);
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "C2") {
                if (FileOperation.levelIsExist("6", studentID)) {
                    JOptionPane.showMessageDialog(null, "error", "level exist", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"C2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "6", studentID);
                    level.addLevelInFile(level);
                }

            }

        }
        if (event.getSource() == deleteLevelButton) {
            DefaultTableModel levelDefaltTableModel = (DefaultTableModel) levelsTable.getModel();

            if (levelsTable.getSelectedRowCount() == 1) {
                levelDefaltTableModel.removeRow(levelsTable.getSelectedRow());
                FileOperation.deleteLevel(getLevelId(levelName),studentID);
            } else {
                if (levelsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Table is Empty..");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select single row for delete..");
                }
            }
        }
        if (event.getSource() == backButton) {
            this.setVisible(false);
        }

    }

    String getLevelId(String levelNameParameter){
        if(levelNameParameter.equals("A1")){
            return "1";
        }else if(levelNameParameter.equals("A2")){
            return "2";

        }else if(levelNameParameter.equals("B1")){
            return "3";

        }else if(levelNameParameter.equals("B2")){
            return "4";

        }else if(levelNameParameter.equals("C1")){
            return "5";

        }else if(levelNameParameter.equals("C2")){
            return "6";
        }
        return "";
    }
}
