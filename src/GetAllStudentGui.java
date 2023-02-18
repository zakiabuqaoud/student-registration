import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GetAllStudentGui extends JFrame implements ActionListener {
    Container container;
    JButton updateButton, deleteButton, showStudentDetailsButton, backButton, chooseDateButton;
    JTextField searchTextField, nameTextField, phoneNumberTextField, registrationDateTextField;
    JLabel searchLabel, nameLabel, phoneNumberLabel, registrationDateLabel, titleLabel;
    MainGui prop;

    DefaultTableModel model;
    JTable studentsTable;
    JScrollPane scroll;

    GetDetailsUser getDetailsUser;

    String oldName;


    public GetAllStudentGui(MainGui prop) {
        this.prop = prop;
        container = getContentPane();


        setTitle("Students Table");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(true);
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

        updateButton.setBounds(600, 280, 141, 28);
        deleteButton.setBounds(800, 280, 141, 28);
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
        searchLabel = new JLabel("Search");
        searchLabel.setFont(Theme.smallFont);
        searchLabel.setForeground(Theme.blackColor);

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

        searchLabel.setBounds(78, 280, 176, 28);
        nameLabel.setBounds(78, 128, 176, 28);
        phoneNumberLabel.setBounds(78, 183, 176, 28);
        registrationDateLabel.setBounds(528, 183, 176, 28);
        titleLabel.setBounds(350, 25, 554, 52);

        container.add(searchLabel);
        container.add(nameLabel);
        container.add(phoneNumberLabel);
        container.add(registrationDateLabel);
        container.add(titleLabel);

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

        searchTextField = new JTextField();
        searchTextField.setBackground(Theme.whiteColor);
        searchTextField.setForeground(Theme.blackColor);
        searchTextField.setFont(Theme.inputColor);

        nameTextField.setBounds(225, 128, 400, 28);
        phoneNumberTextField.setBounds(225, 183, 230, 28);
        registrationDateTextField.setBounds(654, 183, 230, 28);
        searchTextField.setBounds(150, 280, 230, 28);

        container.add(nameTextField);
        container.add(phoneNumberTextField);
        container.add(registrationDateTextField);
        container.add(searchTextField);

        //JTable and JScroll
        model = new DefaultTableModel();
        studentsTable = new JTable(model);
        scroll = new JScrollPane(studentsTable);

        scroll.setBounds(78, 350, 872, 220);

        container.add(scroll);

        model.addColumn("Full Name");
        model.addColumn("Phone Number");
        model.addColumn("Register Date");

        ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");

        for (String row : studentsArrayList) {
            String[] rowSub = row.split("#");
            String[] rowSubSub0 = rowSub[0].split(":");
            String[] rowSubSub1 = rowSub[1].split(":");
            String[] rowSubSub2 = rowSub[2].split(":");
            String[] rowSubSub3 = rowSub[3].split(":");

            model.addRow(new Object[]{rowSubSub1[1], rowSubSub2[1], rowSubSub3[1]});
        }
        studentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                jTableMouseClicked(e);

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
                    try{
                    if (row.contains(oldName)) {
                        subRow = row.split("#");
                        break;
                    }}catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
                }
                try {
                    String[] subSubIDRow = subRow[0].split(":");
                    String[] subSubNameRow = subRow[1].split(":");


                    //get Details for user
                    getDetailsUser = new GetDetailsUser(this,subSubIDRow[1], subSubNameRow[1]);
                    getDetailsUser.setVisible(true);

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Table is Empty..");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select single row for display details..");
                }
            }
        }


        if (event.getSource() == updateButton) {
            DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

            if (studentsTable.getSelectedRowCount() == 1) {
                String name = nameTextField.getText().trim();
                String phone = phoneNumberTextField.getText().trim();
                String date = registrationDateTextField.getText().trim();

                if (Operation.isPhoneNumber(phone) && Operation.isDate(date) && !name.isEmpty() && !phone.isEmpty() && !date.isEmpty()) {


                    studentDefaltTableModel.setValueAt(name, studentsTable.getSelectedRow(), 0);
                    studentDefaltTableModel.setValueAt(phone, studentsTable.getSelectedRow(), 1);
                    studentDefaltTableModel.setValueAt(date, studentsTable.getSelectedRow(), 2);

                    JOptionPane.showMessageDialog(null, "Update Successfully..");
                    nameTextField.setText("");
                    phoneNumberTextField.setText("");
                    registrationDateTextField.setText("");

                    ArrayList<String> studentsArrayList = FileOperation.storage("students.txt");
                    int index = 0;
                    String subRow[] = new String[4];
                    for (String row : studentsArrayList) {
                        if (row.contains(oldName)) {
                            subRow = row.split("#");
                            index = studentsArrayList.indexOf(row);
                            break;
                        }
                    }
                    String[] subSubIDRow = subRow[0].split(":");
                    studentsArrayList.set(index, "id:" + subSubIDRow[1] + "#" + "name:" + name + "#" + "phone:" + phone + "#" + "date:" + date);
                    FileOperation.writeToFile("students.txt", studentsArrayList);
                } else {
                    JOptionPane.showMessageDialog(null, "enter phone number in phone field, date in date field and text in name field");
                }
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Table is Empty..");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select single row for update..");
                }
            }
        }


        if (event.getSource() == deleteButton) {
            DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

            if (studentsTable.getSelectedRowCount() == 1) {
                studentDefaltTableModel.removeRow(studentsTable.getSelectedRow());

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
                JOptionPane.showMessageDialog(null,"student id deleted");
                nameTextField.setText("");
                phoneNumberTextField.setText("");
                registrationDateTextField.setText("");
            } else {
                if (studentsTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Table is Empty..");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select single row for delete..");
                }
            }
        }

    }

    private void jTableMouseClicked(MouseEvent event) {

        DefaultTableModel studentDefaltTableModel = (DefaultTableModel) studentsTable.getModel();

        String name = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 0).toString();
        oldName = name;
        String phone = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 1).toString();
        String date = studentDefaltTableModel.getValueAt(studentsTable.getSelectedRow(), 2).toString();

        //set to textField
        nameTextField.setText(name);
        phoneNumberTextField.setText(phone);
        registrationDateTextField.setText(date);

    }
}
