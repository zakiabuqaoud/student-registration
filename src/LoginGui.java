import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginGui extends JFrame implements ActionListener {

    Container container;

    JLabel titleLabel, userNameLabel, passwordLabel;
    JTextField userNameTextField;
    JPasswordField passwordField;
    JButton loginButton, resetButton;

    public LoginGui(){
        container = getContentPane();

        setTitle("Login Page");
        setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        container.setBackground(Theme.lightBlueColor);

        //add icon for interface
        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);

        // all JLabel
        titleLabel = new JLabel("Login Page");
        titleLabel.setFont(Theme.bigFont);
        titleLabel.setForeground(Theme.blackColor);

        userNameLabel = new JLabel("User Name");
        userNameLabel.setFont(Theme.smallFont);
        userNameLabel.setForeground(Theme.blackColor);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(Theme.smallFont);
        passwordLabel.setForeground(Theme.blackColor);

        titleLabel.setBounds(405, 25, 554, 52);
        userNameLabel.setBounds(259, 250, 115, 28);
        passwordLabel.setBounds(259, 300, 115, 28);

        container.add(titleLabel);
        container.add(userNameLabel);
        container.add(passwordLabel);

        //all JTextField
        userNameTextField = new JTextField();
        userNameTextField.setBackground(Theme.whiteColor);
        userNameTextField.setForeground(Theme.blackColor);
        userNameTextField.setFont(Theme.inputColor);

        passwordField = new JPasswordField();
        passwordField.setBackground(Theme.whiteColor);
        passwordField.setForeground(Theme.blackColor);
        passwordField.setFont(Theme.inputColor);

        userNameTextField.setBounds(398, 250, 283, 28);
        passwordField.setBounds(398, 300, 283, 28);

        container.add(userNameTextField);
        container.add(passwordField);

        //all JButton
        loginButton =new JButton("Login");
        loginButton.setBackground(Theme.lightBrownColor);
        loginButton.setForeground(Theme.blackColor);
        loginButton.setFont(Theme.fontSmallBold);

        resetButton = new JButton("Reset");
        resetButton.setBackground(Theme.lightBrownColor);
        resetButton.setForeground(Theme.blackColor);
        resetButton.setFont(Theme.fontSmallBold);

        loginButton.setBounds(402, 400, 97, 28);
        resetButton.setBounds(544, 400, 105, 28);

        container.add(loginButton);
        container.add(resetButton);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        //Arced image
        ImageIcon arcImgIcon = new ImageIcon(getClass().getResource("/Resource/arc.png"));
        JLabel arcadiaImg = new JLabel("Arcadia Image");
        arcadiaImg.setBounds(430, 110, 100, 100);
        arcadiaImg.setIcon(arcImgIcon);
        container.add(arcadiaImg);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        //call Login function
        if(event.getSource() == loginButton){
            login(userNameTextField.getText().trim(), passwordField.getText().trim());
        }
        if(event.getSource() == resetButton){
            userNameTextField.setText("");
            passwordField.setText("");
        }



    }
    // Login Process
    private void login(String userName,String password){
        if(userName.equals("") && password.equals("")){
            JOptionPane.showMessageDialog(null,"Complete All Information","Invalid Entry",0);
        }else {
            ArrayList<String> authArrayList = FileOperation.storage("auth.txt");
            String[] authArray = authArrayList.get(0).split("#");
            if(authArray[0].equals(userName)&& authArray[1].equals(password)){
                this.setVisible(false);
                new MainGui().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry, User Name or Password Is Incorrect","Invalid Entry",0);
            }
        }
    }

    public static void main(String[] argument){
        new LoginGui();
    }
}
