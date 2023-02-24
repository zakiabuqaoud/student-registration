import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangePasswordGui extends JFrame implements ActionListener {
    Container container;
    JLabel titleLabel, oldUserNameLabel, newUserNameLabel, newUserNameRepeatLabel, oldPasswordLabel, newPasswordLabel, newPasswordRepeatLabel;
    JPasswordField oldPasswordField, newPasswordField, newPasswordRepeatField;
    JTextField oldUserNameTextField, newUserNameTextField, newUserNameRepeatTextField;
    JButton changePasswordButton, resetButton, backButton;

    MainGui prop;
    ChangePasswordGui(MainGui prop) {
        container = getContentPane();

        this.prop = prop;

        setTitle("Change Password Page");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        container.setBackground(Theme.lightBlueColor);


        //add icon for interface
        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);

        //Arced image
        ImageIcon arcImgIcon = new ImageIcon(getClass().getResource("/Resource/arc.png"));
        JLabel arcadiaImg = new JLabel("Arcadia Image");
        arcadiaImg.setBounds(430, 110, 100, 100);
        arcadiaImg.setIcon(arcImgIcon);
        container.add(arcadiaImg);

        //all JLabel
        titleLabel = new JLabel("Change User Name And Password");
        titleLabel.setFont(Theme.bigFont);
        titleLabel.setForeground(Theme.blackColor);
        titleLabel.setBounds(255, 25, 554, 52);
        container.add(titleLabel);

        oldUserNameLabel = new JLabel("Old User Name");
        oldUserNameLabel.setFont(Theme.smallFont);
        oldUserNameLabel.setForeground(Theme.blackColor);
        oldUserNameLabel.setBounds(259, 250, 135, 28);
        container.add(oldUserNameLabel);

        oldPasswordLabel = new JLabel("Old Password");
        oldPasswordLabel.setFont(Theme.smallFont);
        oldPasswordLabel.setForeground(Theme.blackColor);
        oldPasswordLabel.setBounds(259, 300, 135, 28);
        container.add(oldPasswordLabel);

        newUserNameLabel = new JLabel("New User Name");
        newUserNameLabel.setFont(Theme.smallFont);
        newUserNameLabel.setForeground(Theme.blackColor);
        newUserNameLabel.setBounds(259,350,135,28);
        container.add(newUserNameLabel);

        newUserNameRepeatLabel= new JLabel("Repeat User Name");
        newUserNameRepeatLabel.setFont(Theme.smallFont);
        newUserNameRepeatLabel.setForeground(Theme.blackColor);
        newUserNameRepeatLabel.setBounds(259,400,135,28);
        container.add(newUserNameRepeatLabel);

        newPasswordLabel= new JLabel("New Password");
        newPasswordLabel.setFont(Theme.smallFont);
        newPasswordLabel.setForeground(Theme.blackColor);
        newPasswordLabel.setBounds(259,450,135,28);
        container.add(newPasswordLabel);

        newPasswordRepeatLabel= new JLabel("Repeat Password");
        newPasswordRepeatLabel.setFont(Theme.smallFont);
        newPasswordRepeatLabel.setForeground(Theme.blackColor);
        newPasswordRepeatLabel.setBounds(259,500,135,28);
        container.add(newPasswordRepeatLabel);

        //all JTextField
        oldUserNameTextField = new JTextField();
        oldUserNameTextField.setBackground(Theme.whiteColor);
        oldUserNameTextField.setForeground(Theme.blackColor);
        oldUserNameTextField.setFont(Theme.inputColor);
        oldUserNameTextField.setBounds(428, 250, 283, 28);
        container.add(oldUserNameTextField);

        newUserNameTextField = new JTextField();
        newUserNameTextField.setBackground(Theme.whiteColor);
        newUserNameTextField.setForeground(Theme.blackColor);
        newUserNameTextField.setFont(Theme.inputColor);
        newUserNameTextField.setBounds(428, 350, 283, 28);
        container.add(newUserNameTextField);

        newUserNameRepeatTextField = new JTextField();
        newUserNameRepeatTextField.setBackground(Theme.whiteColor);
        newUserNameRepeatTextField.setForeground(Theme.blackColor);
        newUserNameRepeatTextField.setFont(Theme.inputColor);
        newUserNameRepeatTextField.setBounds(428,400,283,28);
        container.add(newUserNameRepeatTextField);

        //all JPasswordField
        oldPasswordField = new JPasswordField();
        oldPasswordField.setBackground(Theme.whiteColor);
        oldPasswordField.setForeground(Theme.blackColor);
        oldPasswordField.setFont(Theme.inputColor);
        oldPasswordField.setBounds(428, 300, 283, 28);
        container.add(oldPasswordField);

        newPasswordField = new JPasswordField();
        newPasswordField.setBackground(Theme.whiteColor);
        newPasswordField.setForeground(Theme.blackColor);
        newPasswordField.setFont(Theme.inputColor);
        newPasswordField.setBounds(428,450,283,28);
        container.add(newPasswordField);

        newPasswordRepeatField = new JPasswordField();
        newPasswordRepeatField.setBackground(Theme.whiteColor);
        newPasswordRepeatField.setForeground(Theme.blackColor);
        newPasswordRepeatField.setFont(Theme.inputColor);
        newPasswordRepeatField.setBounds(428,500,283,28);
        container.add(newPasswordRepeatField);

        //all JButton
        changePasswordButton = new JButton("Update");
        changePasswordButton.setBackground(Theme.lightBrownColor);
        changePasswordButton.setForeground(Theme.blackColor);
        changePasswordButton.setFont(Theme.fontSmallBold);
        changePasswordButton.setBounds(259,580,130,28);
        container.add(changePasswordButton);
        changePasswordButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setBackground(Theme.lightBrownColor);
        resetButton.setForeground(Theme.blackColor);
        resetButton.setFont(Theme.fontSmallBold);
        resetButton.setBounds(428,580,130,28);
        container.add(resetButton);
        resetButton.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setBackground(Theme.lightBrownColor);
        backButton.setForeground(Theme.blackColor);
        backButton.setFont(Theme.fontSmallBold);
        backButton.setBounds(597,580,130,28);
        container.add(backButton);
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == resetButton) {
           reset();
        }
        if (event.getSource() == backButton) {
            this.setVisible(false);
        }
        if (event.getSource() == changePasswordButton) {
            //if empty field
            if (!oldUserNameTextField.getText().trim().equals("") && !oldPasswordField.getText().trim().equals("") && !newUserNameTextField.getText().trim().equals("") && !newUserNameRepeatTextField.getText().trim().equals("") && !newPasswordField.getText().trim().equals("") && !newPasswordRepeatField.getText().trim().equals("")) {
                //if old value correct, then call change password
                ArrayList<String> authArrayList = FileOperation.storage("auth.txt");
                String[] authArray = authArrayList.get(0).split("#");
                if (authArray[0].equals(oldUserNameTextField.getText().trim()) && authArray[1].equals(oldPasswordField.getText().trim())) {
                    changePassword(newUserNameTextField.getText().trim(), newUserNameRepeatTextField.getText().trim(), newPasswordField.getText().trim(), newPasswordRepeatField.getText().trim());

                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Old User Name and Old Password Is Incorrect", "Invalid Entry", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Complete All Information", "Invalid Entry", 0);

            }
        }
    }

    // this method take new auth and change
    private void changePassword(String newUserName, String newUserNameRepeat, String newPassword, String newPasswordRepeat) {
        if (newUserName.equals(newUserNameRepeat)) {
            if (newPassword.equals(newPasswordRepeat)) {
                ArrayList<String> newAuth = new ArrayList<String>();
                newAuth.add(newUserName + "#" + newPassword);
                FileOperation.writeToFile("auth.txt", newAuth);
                JOptionPane.showMessageDialog(null,"Update Successfully");
                reset();
            }else{
                JOptionPane.showMessageDialog(null, "The New Password Does Not Match", "Invalid Entry", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The New User Name Does Not Match", "Invalid Entry", 0);
        }
    }
    public void reset(){
        oldUserNameTextField.setText("");
        oldPasswordField.setText("");
        newUserNameTextField.setText("");
        newUserNameRepeatTextField.setText("");
        newPasswordField.setText("");
        newPasswordRepeatField.setText("");
    }

}
