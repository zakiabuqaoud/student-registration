import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    GetAllStudentGui prop;
    public GetDetailsUser(GetAllStudentGui prop){
        this.prop = prop;
        container = getContentPane();

        setTitle("Students Details");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(true);
        container.setBackground(Theme.lightPurpleColor);


        // JTable
        levelModel =new DefaultTableModel();
        levelsTable = new JTable(levelModel);
        levelScroll = new JScrollPane(levelsTable);

        paymentModel = new DefaultTableModel();
        paymentsTable = new JTable(paymentModel);
        paymentScroll = new JScrollPane(paymentsTable);

        levelScroll.setBounds(30,274,320,250);
        paymentScroll.setBounds(400,274,570,250);

        container.add(levelScroll);
        container.add(paymentScroll);

        levelModel.addColumn("Level");

        paymentModel.addColumn("Payment");
        paymentModel.addColumn("Payment Date");

        //JLabel
        titleLabel = new JLabel("Student Name");
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

        paymentTextField.setBounds(497,140,165,28);
        paymentDateTextField.setBounds(810,140,115,28);

        container.add(paymentTextField);
        container.add(paymentDateTextField);

        //JCompoBox
        levelsCompoBox = new JComboBox<String>();
        levelsCompoBox.setModel(new DefaultComboBoxModel(levels));
        levelsCompoBox.setBounds(140,140,140,28);
        container.add(levelsCompoBox);

        //JButton
        addLevelButton = new JButton("Add");
        addLevelButton.setBackground(Theme.darkPurpleColor);
        addLevelButton.setForeground(Theme.blackColor);
        addLevelButton.setFont(Theme.smallFont);

        updateLevelButton = new JButton("Update");
        updateLevelButton.setBackground(Theme.darkPurpleColor);
        updateLevelButton.setForeground(Theme.blackColor);
        updateLevelButton.setFont(Theme.smallFont);

        deleteLevelButton = new JButton("Delete");
        deleteLevelButton.setBackground(Theme.darkPurpleColor);
        deleteLevelButton.setForeground(Theme.blackColor);
        deleteLevelButton.setFont(Theme.smallFont);

        addPaymentButton = new JButton("Add Payment");
        addPaymentButton.setBackground(Theme.darkPurpleColor);
        addPaymentButton.setForeground(Theme.blackColor);
        addPaymentButton.setFont(Theme.smallFont);

        updatePaymentButton = new JButton("Update Payment");
        updatePaymentButton.setBackground(Theme.darkPurpleColor);
        updatePaymentButton.setForeground(Theme.blackColor);
        updatePaymentButton.setFont(Theme.smallFont);

        deletePaymentButton = new JButton("Delete Payment");
        deletePaymentButton.setBackground(Theme.darkPurpleColor);
        deletePaymentButton.setForeground(Theme.blackColor);
        deletePaymentButton.setFont(Theme.smallFont);

        backButton = new JButton("Back");
        backButton.setBackground(Theme.darkPurpleColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);

        choosePaymentDateButton = new JButton("+");
        choosePaymentDateButton.setBackground(Theme.darkPurpleColor);
        choosePaymentDateButton.setForeground(Theme.blackColor);

        addLevelButton.setBounds(30,216,100,28);
        updateLevelButton.setBounds(140,216,100,28);
        deleteLevelButton.setBounds(250,216,100,28);
        addPaymentButton.setBounds(400,216,190,28);
        updatePaymentButton.setBounds(600,216,190,28);
        deletePaymentButton.setBounds(800,216,170,28);
        backButton.setBounds(815,580,150,28);
        choosePaymentDateButton.setBounds(925,140,45,28);

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

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == backButton){
            this.setVisible(false);
        }

    }
}
