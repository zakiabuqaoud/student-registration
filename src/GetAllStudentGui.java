import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GetAllStudentGui extends JFrame implements ActionListener {
    Container container;
    JButton updateButton, deleteButton, showStudentDetailsButton, backButton, chooseDateButton;
    JTextField studentCountTextField, searchTextField, nameTextField, phoneNumberTextField, registrationDateTextField, feesTextField;
    JLabel studentCountLabel, searchLabel, nameLabel, phoneNumberLabel, registrationDateLabel, titleLabel, feesLabel;
    MainGui prop;

    DefaultTableModel model;
    JTable studentsTable;
    JScrollPane scroll;

    GetDetailsUser getDetailsUser;

    String oldName;


    public GetAllStudentGui(MainGui prop) {
        this.prop = prop;
        container = getContentPane();

        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);


        setTitle("Students Table");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        container.setBackground(Theme.lightBlueColor);

        //JButton
        updateButton = new JButton("Update");
        updateButton.setBackground(Theme.lightBrownColor);
        updateButton.setForeground(Theme.blackColor);
        updateButton.setFont(Theme.fontSmallBold);

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Theme.lightBrownColor);
        deleteButton.setForeground(Theme.blackColor);
        deleteButton.setFont(Theme.fontSmallBold);

        backButton = new JButton("Back");
        backButton.setBackground(Theme.lightBrownColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);

        showStudentDetailsButton = new JButton("Show Details");
        showStudentDetailsButton.setBackground(Theme.lightBrownColor);
        showStudentDetailsButton.setForeground(Theme.blackColor);
        showStudentDetailsButton.setFont(Theme.fontSmallBold);

        chooseDateButton = new JButton("+");
        chooseDateButton.setBackground(Theme.lightBrownColor);
        chooseDateButton.setForeground(Theme.blackColor);
        chooseDateButton.setFont(Theme.fontSmallBold);

        updateButton.setBounds(600, 290, 141, 28);
        deleteButton.setBounds(800, 290, 141, 28);
        backButton.setBounds(800, 610, 141, 28);
        showStudentDetailsButton.setBounds(550, 610, 191, 28);
        chooseDateButton.setBounds(894, 183, 50, 28);

        container.add(updateButton);
        container.add(deleteButton);
        container.add(backButton);
        container.add(showStudentDetailsButton);
        container.add(chooseDateButton);

        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        backButton.addActionListener(this);
        showStudentDetailsButton.addActionListener(this);
        chooseDateButton.addActionListener(this);

        //JLabel

        nameLabel = new JLabel("Full Name");
        nameLabel.setFont(Theme.smallFont);
        nameLabel.setForeground(Theme.blackColor);

        phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setFont(Theme.smallFont);
        phoneNumberLabel.setForeground(Theme.blackColor);

        registrationDateLabel = new JLabel("Register Date");
        registrationDateLabel.setFont(Theme.smallFont);
        registrationDateLabel.setForeground(Theme.blackColor);

        titleLabel = new JLabel("Students Table");
        titleLabel.setFont(Theme.bigFont);
        titleLabel.setForeground(Theme.blackColor);

        feesLabel = new JLabel("Fees");
        feesLabel.setFont(Theme.smallFont);
        feesLabel.setForeground(Theme.blackColor);

        searchLabel = new JLabel("Search");
        searchLabel.setFont(Theme.smallFont);
        searchLabel.setForeground(Theme.blackColor);

        studentCountLabel = new JLabel();
        studentCountLabel.setFont(Theme.smallFont);
        studentCountLabel.setForeground(Theme.blackColor);

        nameLabel.setBounds(78, 128, 176, 28);
        phoneNumberLabel.setBounds(78, 183, 176, 28);
        registrationDateLabel.setBounds(528, 183, 176, 28);
        feesLabel.setBounds(78, 232, 176, 28);
        titleLabel.setBounds(350, 25, 554, 52);
        searchLabel.setBounds(78, 290, 176, 28);
        studentCountLabel.setBounds(0, 0, 0, 0);


        container.add(nameLabel);
        container.add(phoneNumberLabel);
        container.add(registrationDateLabel);
        container.add(titleLabel);
        container.add(feesLabel);
        container.add(searchLabel);
        container.add(studentCountLabel);

        //JTextField
        nameTextField = new JTextField();
        nameTextField.setBackground(Theme.whiteColor);
        nameTextField.setForeground(Theme.blackColor);
        nameTextField.setFont(Theme.inputColor);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setBackground(Theme.whiteColor);
        phoneNumberTextField.setForeground(Theme.blackColor);
        phoneNumberTextField.setFont(Theme.inputColor);

        registrationDateTextField = new JTextField();
        registrationDateTextField.setBackground(Theme.whiteColor);
        registrationDateTextField.setForeground(Theme.blackColor);
        registrationDateTextField.setFont(Theme.inputColor);

        feesTextField = new JTextField();
        feesTextField.setBackground(Theme.whiteColor);
        feesTextField.setForeground(Theme.blackColor);
        feesTextField.setFont(Theme.inputColor);

        searchTextField = new JTextField();
        searchTextField.setBackground(Theme.whiteColor);
        searchTextField.setForeground(Theme.blackColor);
        searchTextField.setFont(Theme.inputColor);

        studentCountTextField = new JTextField();
        studentCountTextField.setBackground(Theme.whiteColor);
        studentCountTextField.setForeground(Theme.blackColor);
        studentCountTextField.setFont(Theme.inputColor);
        studentCountTextField.setEditable(false);

        nameTextField.setBounds(225, 128, 400, 28);
        phoneNumberTextField.setBounds(225, 183, 230, 28);
        registrationDateTextField.setBounds(654, 183, 230, 28);
        feesTextField.setBounds(225, 232, 230, 28);
        searchTextField.setBounds(225, 290, 230, 28);
        studentCountTextField.setBounds(0, 0, 0, 0);


        container.add(nameTextField);
        container.add(phoneNumberTextField);
        container.add(registrationDateTextField);
        container.add(feesTextField);
        container.add(searchTextField);
        container.add(studentCountTextField);

        getStudentsCount();

        //JTable and JScroll
        model = new DefaultTableModel();
        studentsTable = new JTable(model);
        scroll = new JScrollPane(studentsTable);

        scroll.setBounds(78, 350, 872, 220);

        container.add(scroll);

        model.addColumn("id");
        model.addColumn("Full Name");
        model.addColumn("Phone Number");
        model.addColumn("Register Date");
        model.addColumn("Fees");
        studentsTable.setFont(new Font("Cleaver's_Juvenia_Bloc...", Font.PLAIN, 18));
        studentsTable.setIntercellSpacing(new Dimension(3,0));


        ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
        displayStudentsTable(studentsArrayList);


        studentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                jTableMouseClicked(e);

            }
        });

        searchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                search();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == chooseDateButton) {
            registrationDateTextField.setText(new DatePicker(this).setPickedDate());
        }

        if (event.getSource() == backButton) {
            this.setVisible(false);
        }

        if (event.getSource() == showStudentDetailsButton) {
            if (studentsTable.getSelectedRowCount() == 1) {

                //get id for student
                ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
                String subRow[] = new String[4];
                for (String row : studentsArrayList) {
                    try {
                        if (row.contains(oldName)) {
                            subRow = row.split("#");
                            break;
                        }
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                try {
                    String[] subSubIDRow = subRow[0].split(":");
                    String[] subSubNameRow = subRow[1].split(":");
                    String[] subSubFeesRow = subRow[4].split(":");


                    //get Details for user
                    getDetailsUser = new GetDetailsUser(this, subSubIDRow[1], subSubNameRow[1], subSubFeesRow[1]);
                    getDetailsUser.setVisible(true);

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Display Student Details");
                }
            }
        }


        if (event.getSource() == updateButton) {
            DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

            if (studentsTable.getSelectedRowCount() == 1) {
                String name = nameTextField.getText().trim();
                String phone = phoneNumberTextField.getText().trim();
                String date = registrationDateTextField.getText().trim();
                String fees = feesTextField.getText().trim();

                if (Operation.isPhoneNumber(phone) && Operation.isDate(date) && !name.isEmpty() && !phone.isEmpty() && !date.isEmpty() && !fees.isEmpty() && Operation.checkIsNotHash(name) && Operation.checkIsNotHash(date) && Operation.checkIsNotHash(phone) && Operation.checkIsNotHash(fees) && Operation.isNumeric(fees)) {


                    studentDefaltTableModel.setValueAt(name, studentsTable.getSelectedRow(), 0);
                    studentDefaltTableModel.setValueAt(phone, studentsTable.getSelectedRow(), 1);
                    studentDefaltTableModel.setValueAt(date, studentsTable.getSelectedRow(), 2);
                    studentDefaltTableModel.setValueAt(fees, studentsTable.getSelectedRow(), 3);

                    JOptionPane.showMessageDialog(null, "Student Update Successfully");
                    nameTextField.setText("");
                    phoneNumberTextField.setText("");
                    registrationDateTextField.setText("");
                    feesTextField.setText("");

                    ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
                    int index = 0;
                    String subRow[] = new String[5];
                    for (String row : studentsArrayList) {
                        if (row.contains(oldName)) {
                            subRow = row.split("#");
                            index = studentsArrayList.indexOf(row);
                            break;
                        }
                    }
                    String[] subSubIDRow = subRow[0].split(":");
                    studentsArrayList.set(index, "id:" + subSubIDRow[1] + "#" + "name:" + name + "#" + "phone:" + phone + "#" + "date:" + date + "#" + "fees:" + fees);
                    FileOperation.writeToFile("students.txt", studentsArrayList);
                } else {
                    JOptionPane.showMessageDialog(null, "FullName Field Must Be a text, Phone Field Must Be a Number, Date Field Must Be a Date", "Invalid Entry", 0);
                }
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Update Student");
                }
            }
        }


        if (event.getSource() == deleteButton) {
            DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

            if (studentsTable.getSelectedRowCount() == 1) {
                int option = JOptionPane.showConfirmDialog(null, "Are You Sure To Delete This Student?", "Delete", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    studentDefaltTableModel.removeRow(studentsTable.getSelectedRow());
                    FileOperation.deletePaymentAndLevelForStudent(oldName);
                    ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
                    int index = 0;
                    for (String row : studentsArrayList) {
                        if (row.contains(oldName)) {
                            index = studentsArrayList.indexOf(row);
                            break;
                        }
                    }
                    studentsArrayList.remove(index);
                    FileOperation.writeToFile("students.txt", studentsArrayList);
                    JOptionPane.showMessageDialog(null, "Student Delete Successfully");
                    getStudentsCount();
                    nameTextField.setText("");
                    phoneNumberTextField.setText("");
                    registrationDateTextField.setText("");
                    feesTextField.setText("");
                }
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "The Table Is Empty");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Single Row For Delete Student");
                }
            }
        }

    }

    private void jTableMouseClicked(MouseEvent event) {

        DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

        String name = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 1).toString();
        oldName = name;
        String phone = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 2).toString();
        String date = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 3).toString();
        String fees = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 4).toString();

        //set to textField
        nameTextField.setText(name);
        phoneNumberTextField.setText(phone);
        registrationDateTextField.setText(date);
        feesTextField.setText(fees);

    }

    private void displayStudentsTable(ArrayList<String> studentsArrayList) {
        for (int i = studentsArrayList.size(), j = 0; j < studentsArrayList.size(); j++, i--) {
            String[] rowSub = studentsArrayList.get(i - 1).split("#");
            String[] rowSubSub0 = rowSub[0].split(":");
            String[] rowSubSub1 = rowSub[1].split(":");
            String[] rowSubSub2 = rowSub[2].split(":");
            String[] rowSubSub3 = rowSub[3].split(":");
            String[] rowSubSub4 = rowSub[4].split(":");

            model.addRow(new Object[]{j+1,rowSubSub1[1], rowSubSub2[1], rowSubSub3[1], rowSubSub4[1]});
        }
        DefaultTableCellRenderer cellRenderer;
        studentsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        studentsTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        studentsTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        studentsTable.getColumnModel().getColumn(3).setPreferredWidth(300);
        studentsTable.getColumnModel().getColumn(4).setPreferredWidth(300);
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        studentsTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        studentsTable.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        studentsTable.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

    }

    private void getStudentsCount(){
        ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
        studentCountTextField.setText(studentsArrayList.size()+"");
    }

    private void deleteALLStudentForSearch(ArrayList<String> studentsArrayList) {
        DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();
        studentDefaltTableModel.setRowCount(0);
    }

    private void search() {
        DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();
        String wordSearch = searchTextField.getText().trim();
        ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
        if (wordSearch.isEmpty()) {
            studentDefaltTableModel.setRowCount(0);
            displayStudentsTable(studentsArrayList);
        } else {
            ArrayList<String> rowsSearchTarget = new ArrayList<String>();
            //phone
            if (Operation.isNumeric(wordSearch)) {
                for (String row : studentsArrayList) {
                    String[] subRow = row.split("#");
                    String[] subSubNameRow = subRow[2].split(":");
                    if (subSubNameRow[1].contains(wordSearch)) {
                        rowsSearchTarget.add(row);
                    }
                }
                deleteALLStudentForSearch(studentsArrayList);
                displayStudentsTable(rowsSearchTarget);
            } else {

                for (String row : studentsArrayList) {
                    String[] subRow = row.split("#");
                    String[] subSubNameRow = subRow[1].split(":");
                    if (subSubNameRow[1].contains(wordSearch)) {
                        rowsSearchTarget.add(row);
                    }
                }
                deleteALLStudentForSearch(studentsArrayList);
                displayStudentsTable(rowsSearchTarget);
            }
        }

    }
}