
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

public class CreateStudentGui extends JFrame implements ActionListener {
    Container container;
    String[] levels = {"A1", "A2", "B1", "B2", "C1", "C2"};
    JLabel titleLabel, nameLabel, phoneLabel, levelLabel, paymentLabel, paymentDateLabel, feesLabel;
    JButton createButton, resetButton, backButton, addDate;
    JTextField nameTextField, phoneTextField, paymentTextField, paymentDateTextField, feesTextField;
    JComboBox levelsCompoBox;

    MainGui prop;

    public CreateStudentGui(MainGui prop) {
        this.prop = prop;

        container = getContentPane();
        setTitle("Create a new student");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        container.setBackground(Theme.lightBlueColor);

        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        /////////////////////////////////////////////////////
        //TextFiled
        nameTextField = new JTextField();
        nameTextField.setBackground(Theme.whiteColor);
        nameTextField.setForeground(Theme.blackColor);
        nameTextField.setFont(Theme.inputColor);

        phoneTextField = new JTextField();
        phoneTextField.setBackground(Theme.whiteColor);
        phoneTextField.setForeground(Theme.blackColor);
        phoneTextField.setFont(Theme.inputColor);

        paymentTextField = new JTextField();
        paymentTextField.setBackground(Theme.whiteColor);
        paymentTextField.setForeground(Theme.blackColor);
        paymentTextField.setFont(Theme.inputColor);

        paymentDateTextField = new JTextField();
        paymentDateTextField.setBackground(Theme.whiteColor);
        paymentDateTextField.setForeground(Theme.blackColor);
        paymentDateTextField.setFont(Theme.inputColor);

        feesTextField =new JTextField();
        feesTextField.setBackground(Theme.whiteColor);
        feesTextField.setForeground(Theme.blackColor);
        feesTextField.setFont(Theme.inputColor);


        nameTextField.setBounds(292, 128, 400, 28);
        phoneTextField.setBounds(292, 183, 400, 28);
        paymentTextField.setBounds(292, 293, 141, 28);
        paymentDateTextField.setBounds(292, 348, 141, 28);
        feesTextField.setBounds(292, 403, 141, 28);

        container.add(nameTextField);
        container.add(phoneTextField);
        container.add(paymentTextField);
        container.add(paymentDateTextField);
        container.add(feesTextField);


        //Button
        createButton = new JButton("Create");
        createButton.setBackground(Theme.lightBrownColor);
        createButton.setForeground(Theme.blackColor);
        createButton.setFont(Theme.fontSmallBold);


        resetButton = new JButton("Reset");
        resetButton.setBackground(Theme.lightBrownColor);
        resetButton.setForeground(Theme.blackColor);
        resetButton.setFont(Theme.fontSmallBold);

        backButton = new JButton("Back");
        backButton.setBackground(Theme.lightBrownColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);

        addDate = new JButton("+");
        addDate.setBackground(Theme.lightBrownColor);
        addDate.setForeground(Theme.blackColor);
        addDate.setFont(Theme.fontSmallBold);


        createButton.setBounds(292, 525, 141, 28);
        resetButton.setBounds(533, 525, 141, 28);
        backButton.setBounds(774, 525, 141, 28);
        addDate.setBounds(435, 348, 60, 28);
        container.add(createButton);
        container.add(resetButton);
        container.add(backButton);
        container.add(addDate);
        createButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
        addDate.addActionListener(this);
        //Label
        titleLabel = new JLabel("Create a new student");
        titleLabel.setFont(Theme.bigFont);
        titleLabel.setForeground(Theme.blackColor);

        nameLabel = new JLabel("Full Name");
        nameLabel.setFont(Theme.smallFont);
        nameLabel.setForeground(Theme.blackColor);

        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setFont(Theme.smallFont);
        phoneLabel.setForeground(Theme.blackColor);

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


        titleLabel.setBounds(350, 25, 554, 52);
        nameLabel.setBounds(78, 128, 176, 28);
        phoneLabel.setBounds(78, 183, 176, 28);
        levelLabel.setBounds(78, 238, 176, 28);
        paymentLabel.setBounds(78, 293, 176, 28);
        paymentDateLabel.setBounds(78, 348, 176, 28);
        feesLabel.setBounds(78, 403, 176, 28);

        container.add(titleLabel);
        container.add(nameLabel);
        container.add(phoneLabel);
        container.add(levelLabel);
        container.add(paymentLabel);
        container.add(paymentDateLabel);
        container.add(feesLabel);


        //ComboBox
        levelsCompoBox = new JComboBox();
        levelsCompoBox.setBackground(Color.white);
        levelsCompoBox.setForeground(Color.black);


        levelsCompoBox.setModel(new DefaultComboBoxModel(levels));


        levelsCompoBox.setBounds(292, 238, 141, 28);

        container.add(levelsCompoBox);


        ////////////////////////////////////////////////////////////
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addDate) {
            paymentDateTextField.setText(new DatePicker(this).setPickedDate());
        }

        if (event.getSource() == resetButton) {
            nameTextField.setText("");
            phoneTextField.setText("");
            paymentTextField.setText("");
            paymentDateTextField.setText("");
            feesTextField.setText("");
        }

        if (event.getSource() == createButton) {
            int validation1 = -1;
            int validation2 = -1;
            int validation3 = -1;
            int validation4 = -1;
            int validation5 =-1;
            int validation6 =-1;


            if (nameTextField.getText().trim().isEmpty() || phoneTextField.getText().trim().isEmpty() || paymentTextField.getText().trim().isEmpty() || paymentDateTextField.getText().trim().isEmpty() || feesTextField.getText().trim().isEmpty())
                JOptionPane.showMessageDialog(null, "Complete All Information", "Invalid Entry", 0);
            else {
                validation1 = 1;
            }


            if (Operation.isDate(paymentDateTextField.getText().trim())) {
                validation2 = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Payment Date Is Incorrect", "Invalid Entry", 0);
            }

            if (Operation.checkIsNotHash(nameTextField.getText().trim()) && Operation.checkIsNotHash(phoneTextField.getText().trim()) && Operation.checkIsNotHash(paymentTextField.getText().trim() )&& Operation.checkIsNotHash(feesTextField.getText().trim())) {
                validation3 = 1;
            } else {
                JOptionPane.showMessageDialog(null, "The Fields Must Not Contain # and :", "Invalid Entry", 0);
            }

            if (Operation.isPhoneNumber(phoneTextField.getText().trim())) {
                validation4 = 1;
            } else {
                JOptionPane.showMessageDialog(null, "The Phone Field Must Be a Number", "Invalid Entry", 0);
            }

            if(FileOperation.checkNameNotExist(nameTextField.getText().trim())){
                validation5 = 1;
            }else{
                JOptionPane.showMessageDialog(null, "This FullName Already Exists", "Invalid Entry", 0);
            }

            if(Operation.isNumeric(paymentTextField.getText().trim() )&& Operation.isNumeric(feesTextField.getText().trim())){
                validation6 =1;
            }else{
                JOptionPane.showMessageDialog(null, "The Payment and fees Fields Must Be a Number", "Invalid Entry", 0);
            }

            // create student, level, payment
            if (validation1 == 1 && validation2 == 1 && validation3 == 1 && validation4 == 1 && validation5 ==1 && validation6 ==1) {
                Student student = new Student(FileOperation.getID(0), nameTextField.getText().trim(), phoneTextField.getText().trim(), paymentDateTextField.getText().trim(),feesTextField.getText().trim());
                student.addStudentInFile();

                Payment payment = new Payment(FileOperation.getID(1), paymentTextField.getText().trim(), paymentDateTextField.getText().trim(), student.id);
                payment.addPaymentInFile(payment);

                //JCompoBox
                if (levelsCompoBox.getSelectedItem().toString() == "A1") {
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"1",student.id);
                    level.addLevelInFile(level);
                }else if(levelsCompoBox.getSelectedItem().toString() == "A2"){
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"2",student.id);
                    level.addLevelInFile(level);
                }else if(levelsCompoBox.getSelectedItem().toString() == "B1"){
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"3",student.id);
                    level.addLevelInFile(level);

                }else if(levelsCompoBox.getSelectedItem().toString() == "B2"){
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"4",student.id);
                    level.addLevelInFile(level);
                }else if(levelsCompoBox.getSelectedItem().toString() == "C1"){
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"5",student.id);
                    level.addLevelInFile(level);
                }else if(levelsCompoBox.getSelectedItem().toString() == "C2"){
                    LevelIDWithStudentID level = new LevelIDWithStudentID(FileOperation.getID(2),"6",student.id);
                    level.addLevelInFile(level);
                }


                JOptionPane.showMessageDialog(null, "The Student Is Saved Successfully");
                nameTextField.setText("");
                phoneTextField.setText("");
                paymentTextField.setText("");
                paymentDateTextField.setText("");
                feesTextField.setText("");

            }


        }
        if (event.getSource() == backButton) {
            this.setVisible(false);
        }


    }

}