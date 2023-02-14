import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GetAllStudentGui extends JFrame implements ActionListener {
    Container container;
    JButton updateButton, deleteButton, showStudentDetailsButton, backButton, chooseDateButton;
    JTextField searchTextField, nameTextField, phoneNumberTextField, registrationDateTextField;
    JLabel searchLabel, nameLabel, phoneNumberLabel, registrationDateLabel, titleLabel;
    MainGui prop;

    DefaultTableModel model;
    JTable studentsTable;
    JScrollPane scroll;




    public GetAllStudentGui(MainGui prop) {
        this.prop = prop;
        container = getContentPane();

        setTitle("Students Table");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(false);
        container.setBackground(Theme.lightPurpleColor);

        //JButton
        updateButton = new JButton("Update");
        updateButton.setBackground(Theme.darkPurpleColor);
        updateButton.setForeground(Theme.blackColor);
        updateButton.setFont(Theme.fontSmallBold);

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Theme.darkPurpleColor);
        deleteButton.setForeground(Theme.blackColor);
        deleteButton.setFont(Theme.fontSmallBold);

        backButton = new JButton("Back");
        backButton.setBackground(Theme.darkPurpleColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);

        showStudentDetailsButton = new JButton("Show Details");
        showStudentDetailsButton.setBackground(Theme.darkPurpleColor);
        showStudentDetailsButton.setForeground(Theme.blackColor);
        showStudentDetailsButton.setFont(Theme.fontSmallBold);

        chooseDateButton = new JButton("+");
        chooseDateButton.setBackground(Theme.darkPurpleColor);
        chooseDateButton.setForeground(Theme.blackColor);
        chooseDateButton.setFont(Theme.fontSmallBold);

        updateButton.setBounds(600,280,141,28);
        deleteButton.setBounds(800,280,141,28);
        backButton.setBounds(800,610,141,28);
        showStudentDetailsButton.setBounds(550,610,191,28);
        chooseDateButton.setBounds(894,183,50,28);

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

        searchLabel.setBounds(78,280,176,28);
        nameLabel.setBounds(78, 128, 176, 28);
        phoneNumberLabel.setBounds(78, 183, 176, 28);
        registrationDateLabel.setBounds(528,183,176,28);
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

        phoneNumberTextField= new JTextField();
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
        registrationDateTextField.setBounds(654,183,230,28);
        searchTextField.setBounds(150,280,230,28);

        container.add(nameTextField);
        container.add(phoneNumberTextField);
        container.add(registrationDateTextField);
        container.add(searchTextField);

        //JTable and JScroll
        model = new DefaultTableModel();
        studentsTable = new JTable(model);
        scroll = new JScrollPane(studentsTable);

        scroll.setBounds(78,350,872,220);

        container.add(scroll);

        model.addColumn("Full Name");
        model.addColumn("Phone Number");
        model.addColumn("Register Date");

        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});
        model.addRow(new Object[]{"Zaki Abu Raya","0595078069","15-12-2022"});




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
