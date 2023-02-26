import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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

    JButton addLevelButton, deleteLevelButton, addPaymentButton, updatePaymentButton, deletePaymentButton, backButton, choosePaymentDateButton;
    JLabel titleLabel, levelLabel, paymentLabel, paymentDateLabel, feesLabel, totalPaymentLabel;

    JTextField paymentTextField, paymentDateTextField, feesTextField, totalPaymentTextField;

    JComboBox levelsCompoBox;

    String studentName;
    String studentID;
    String studentFees;
    String levelName;
    GetAllStudentGui prop;
    String paymentRowID;

    public GetDetailsUser(GetAllStudentGui prop, String id, String name, String studentFees) {
        this.prop = prop;
        container = getContentPane();

        this.studentID = id;
        this.studentName = name;
        this.studentFees = studentFees;


        setTitle("Students Details");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        container.setBackground(Theme.lightBlueColor);

        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);


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

        levelsTable.setFont(new Font("Cleaver's_Juvenia_Bloc...", Font.PLAIN, 18));
        paymentsTable.setFont(new Font("Cleaver's_Juvenia_Bloc...", Font.PLAIN, 18));


        levelModel.addColumn("Level");
        ArrayList<String> levelsForStudent = FileOperation.displayLevels(studentID);
        for (String string : levelsForStudent) {
            levelModel.addRow(new Object[]{string});
        }

        paymentModel.addColumn("id");
        paymentModel.addColumn("Payment");
        paymentModel.addColumn("Payment Date");
        ArrayList<String> paymentsForStudent = FileOperation.displayPayments(studentID);
        for (String row : paymentsForStudent) {
            String[] subRow = row.split("#");
            String[] subSubPaymentIDRow = subRow[0].split(":");
            String[] subSubPaymentRow = subRow[1].split(":");
            String[] subSubPaymentDateRow = subRow[2].split(":");
            paymentModel.addRow(new Object[]{subSubPaymentIDRow[1], subSubPaymentRow[1], subSubPaymentDateRow[1]});
        }
        DefaultTableCellRenderer cellRenderer;
        paymentsTable.setIntercellSpacing(new Dimension(3,0));
        paymentsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        paymentsTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        paymentsTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        paymentsTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        paymentsTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        levelsTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);


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

        feesLabel = new JLabel("Fees");
        feesLabel.setFont(Theme.smallFont);
        feesLabel.setForeground(Theme.blackColor);

        totalPaymentLabel = new JLabel("Total Payment");
        totalPaymentLabel.setFont(Theme.smallFont);
        totalPaymentLabel.setForeground(Theme.blackColor);

        titleLabel.setBounds(350, 25, 554, 52);
        levelLabel.setBounds(30, 140, 150, 28);
        paymentLabel.setBounds(400, 155, 91, 28);
        paymentDateLabel.setBounds(677, 155, 141, 28);
        feesLabel.setBounds(400, 105, 141, 28);
        totalPaymentLabel.setBounds(677, 105, 141, 28);

        container.add(titleLabel);
        container.add(levelLabel);
        container.add(paymentLabel);
        container.add(paymentDateLabel);
        container.add(feesLabel);
        container.add(totalPaymentLabel);

        //JTextField

        paymentTextField = new JTextField();
        paymentTextField.setBackground(Theme.whiteColor);
        paymentTextField.setForeground(Theme.blackColor);
        paymentTextField.setFont(Theme.inputColor);

        paymentDateTextField = new JTextField();
        paymentDateTextField.setBackground(Theme.whiteColor);
        paymentDateTextField.setForeground(Theme.blackColor);
        paymentDateTextField.setFont(Theme.inputColor);

        feesTextField = new JTextField();
        feesTextField.setEditable(false);
        feesTextField.setBackground(Theme.whiteColor);
        feesTextField.setForeground(Theme.blackColor);
        feesTextField.setFont(Theme.inputColor);
        feesTextField.setText(this.studentFees);

        totalPaymentTextField = new JTextField();
        totalPaymentTextField.setEditable(false);
        totalPaymentTextField.setBackground(Theme.whiteColor);
        totalPaymentTextField.setForeground(Theme.blackColor);
        totalPaymentTextField.setFont(Theme.inputColor);
        totalPaymentTextField.setText(getTotalPayment());

        paymentTextField.setBounds(497, 155, 165, 28);
        paymentDateTextField.setBounds(810, 155, 115, 28);
        feesTextField.setBounds(497, 105, 115, 28);
        totalPaymentTextField.setBounds(810, 105, 115, 28);

        container.add(paymentTextField);
        container.add(paymentDateTextField);
        container.add(feesTextField);
        container.add(totalPaymentTextField);

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
        choosePaymentDateButton.setFont(Theme.fontSmallBold);

        addLevelButton.setBounds(30, 216, 150, 28);
        deleteLevelButton.setBounds(200, 216, 150, 28);
        addPaymentButton.setBounds(400, 216, 190, 28);
        updatePaymentButton.setBounds(600, 216, 190, 28);
        deletePaymentButton.setBounds(800, 216, 170, 28);
        backButton.setBounds(815, 580, 150, 28);
        choosePaymentDateButton.setBounds(925, 155, 47, 28);

        container.add(addLevelButton);
        container.add(deleteLevelButton);
        container.add(addPaymentButton);
        container.add(updatePaymentButton);
        container.add(deletePaymentButton);
        container.add(backButton);
        container.add(choosePaymentDateButton);

        addLevelButton.addActionListener(this);
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
                DefaultTableModel paymentDefaltTableModel = (DefaultTableModel) paymentsTable.getModel();

                paymentRowID = paymentDefaltTableModel.getValueAt(paymentsTable.getSelectedRow(), 0).toString();
                String payment = paymentDefaltTableModel.getValueAt(paymentsTable.getSelectedRow(), 1).toString();
                String paymentDate = paymentDefaltTableModel.getValueAt(paymentsTable.getSelectedRow(), 2).toString();

                //set to textField
                paymentTextField.setText(payment);
                paymentDateTextField.setText(paymentDate);
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
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"A1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "1", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "A2") {
                if (FileOperation.levelIsExist("2", studentID)) {
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"A2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "2", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "B1") {
                if (FileOperation.levelIsExist("3", studentID)) {
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"B1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "3", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }

            } else if (levelsCompoBox.getSelectedItem().toString() == "B2") {
                if (FileOperation.levelIsExist("4", studentID)) {
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"B2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "4", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "C1") {
                if (FileOperation.levelIsExist("5", studentID)) {
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"C1"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "5", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }
            } else if (levelsCompoBox.getSelectedItem().toString() == "C2") {
                if (FileOperation.levelIsExist("6", studentID)) {
                    JOptionPane.showMessageDialog(null, "This Level Already Exists", "Invalid Entry", 0);
                } else {
                    DefaultTableModel levelModel = (DefaultTableModel) levelsTable.getModel();
                    levelModel.addRow(new Object[]{"C2"});
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2), "6", studentID);
                    level.addLevelInFile(level);
                    JOptionPane.showMessageDialog(null, "The Level Is Saved");
                }

            }

        }
        if (event.getSource() == deleteLevelButton) {
            DefaultTableModel levelDefaltTableModel = (DefaultTableModel) levelsTable.getModel();

            if (levelsTable.getSelectedRowCount() == 1) {
                int option = JOptionPane.showConfirmDialog(null,"Are You Sure To Delete This Level?","Delete",JOptionPane.YES_NO_OPTION);
                if(option == 0) {
                    levelDefaltTableModel.removeRow(levelsTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Level Delete Successfully");
                    FileOperation.deleteLevel(getLevelId(levelName), studentID);
                }
            } else {
                if (levelsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Delete This Level");
                }
            }
        }
        if (event.getSource() == addPaymentButton) {
            String paymentString = paymentTextField.getText().trim();
            String datePayment = paymentDateTextField.getText().trim();
            if (!paymentString.isEmpty() && !datePayment.isEmpty() && Operation.isDate(datePayment) && Operation.checkIsNotHash(paymentString) && Operation.checkIsNotHash(datePayment) && Operation.isNumeric(paymentString)) {
                String index = FileOperation.getID(1);
                DefaultTableModel levelModel = (DefaultTableModel) paymentsTable.getModel();
                levelModel.addRow(new Object[]{index, paymentString, datePayment});
                Payment payment = new Payment(index, paymentString, datePayment, studentID);
                payment.addPaymentInFile(payment);
                JOptionPane.showMessageDialog(null, "The Payment Is Saved");
                paymentTextField.setText("");
                paymentDateTextField.setText("");
                totalPaymentTextField.setText(getTotalPayment());
            } else {
                JOptionPane.showMessageDialog(null, "Payment Field Must Be a Text, Payment Date Must Be a Date", "Invalid Entry", 0);
            }
        }
        if (event.getSource() == updatePaymentButton) {
            DefaultTableModel paymentDefaltTableModel = (DefaultTableModel) paymentsTable.getModel();
            if (paymentsTable.getSelectedRowCount() == 1) {
                String payment = paymentTextField.getText().trim();
                String paymentDate = paymentDateTextField.getText().trim();
                if (!payment.isEmpty() && !paymentDate.isEmpty() && Operation.isDate(paymentDate) && Operation.checkIsNotHash(payment) && Operation.checkIsNotHash(paymentDate) && Operation.isNumeric(payment)) {
                    String id = paymentDefaltTableModel.getValueAt(paymentsTable.getSelectedRow(), 0).toString();
                    paymentDefaltTableModel.setValueAt(payment, paymentsTable.getSelectedRow(), 1);
                    paymentDefaltTableModel.setValueAt(paymentDate, paymentsTable.getSelectedRow(), 2);

                    JOptionPane.showMessageDialog(null, "Payment Update Successfully");
                    paymentTextField.setText("");
                    paymentDateTextField.setText("");
                    FileOperation.updatePayment(id, payment, paymentDate, studentID);
                    totalPaymentTextField.setText(getTotalPayment());
                } else {
                    JOptionPane.showMessageDialog(null, "Payment Field Must Be a Text, Payment Date Must Be a Date", "Invalid entry", 0);
                }
            } else {
                if (paymentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Update Payment");
                }
            }
        }
        if (event.getSource() == deletePaymentButton) {
            DefaultTableModel paymentDefaltTableModel = (DefaultTableModel) paymentsTable.getModel();
            if (paymentsTable.getSelectedRowCount() == 1) {
                int option = JOptionPane.showConfirmDialog(null,"Are You Sure To Delete This Payment?","Delete",JOptionPane.YES_NO_OPTION);
                if(option == 0) {
                    paymentDefaltTableModel.removeRow(paymentsTable.getSelectedRow());
                    FileOperation.deleteItem("payments.txt", paymentRowID);
                    JOptionPane.showMessageDialog(null, "Payment Delete Successful");
                    totalPaymentTextField.setText(getTotalPayment());
                }
            } else {
                if (paymentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Delete Payment");
                }
            }

        }


        if (event.getSource() == backButton) {
            this.setVisible(false);
        }

    }

    String getLevelId(String levelNameParameter) {
        if (levelNameParameter.equals("A1")) {
            return "1";
        } else if (levelNameParameter.equals("A2")) {
            return "2";

        } else if (levelNameParameter.equals("B1")) {
            return "3";

        } else if (levelNameParameter.equals("B2")) {
            return "4";

        } else if (levelNameParameter.equals("C1")) {
            return "5";

        } else if (levelNameParameter.equals("C2")) {
            return "6";
        }
        return "";
    }

    public String getTotalPayment() {
        String totalPayment = "";
        int totalPaymentInt = 0;
        for (int i = 0; i < paymentsTable.getRowCount(); i++) {
            DefaultTableModel paymentDefaltTableModel = (DefaultTableModel) paymentsTable.getModel();
            String payment = paymentDefaltTableModel.getValueAt(i, 1).toString();
            totalPaymentInt += Integer.parseInt(payment);
        }
        totalPayment = totalPaymentInt + "";
        return totalPayment;
    }
}