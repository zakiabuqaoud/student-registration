import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class MainGui extends JFrame implements ActionListener {
    Container container;
    JLabel titlePartOneLabel, titlePartTwoLabel, ArcadiaPartOneLabel,ArcadiaPartTwoLabel;
    JButton createStudentButton, showStudentsData;

    //external gui
    CreateStudentGui createStudentGui;
    GetAllStudentGui getAllStudentGui;

    MainGui(){
        container = getContentPane();
        setTitle("German Student Registration");
        setLayout(null);
        setVisible(true);
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        container.setBackground(Theme.lightBlueColor);


        //JLabel
        titlePartOneLabel = new JLabel("German Student");
        titlePartOneLabel.setFont(Theme.bigFont);
        titlePartOneLabel.setForeground(Theme.darkBlueColor);

        titlePartTwoLabel = new JLabel("Registration");
        titlePartTwoLabel.setFont(Theme.bigFont);
        titlePartTwoLabel.setForeground(Theme.darkBlueColor);

        ArcadiaPartOneLabel = new JLabel("مركز اركيديا");
        ArcadiaPartOneLabel.setFont(Theme.MediumFont);
        ArcadiaPartOneLabel.setForeground(Theme.darkBlueColor);

        ArcadiaPartTwoLabel = new JLabel("للتطوير واللغات");
        ArcadiaPartTwoLabel.setFont(Theme.MediumFont);
        ArcadiaPartTwoLabel.setForeground(Theme.darkBlueColor);

        titlePartOneLabel.setBounds(100,140,400,80);
        titlePartTwoLabel.setBounds(130,220,310,80);
        ArcadiaPartOneLabel.setBounds(680,30,200,50);
        ArcadiaPartTwoLabel.setBounds(680,80,200,50);



        container.add(titlePartOneLabel);
        container.add(titlePartTwoLabel);
        container.add(ArcadiaPartOneLabel);
        container.add(ArcadiaPartTwoLabel);

        //image
        JLabel arcadiaImg = new JLabel("arcadia Image");
        arcadiaImg.setBounds(850, 30, 100, 100);
        arcadiaImg.setIcon(new ImageIcon("arc.png"));
        container.add(arcadiaImg);

        JLabel boyAndGirlImg = new JLabel("");
        boyAndGirlImg.setBounds(350, 180, 660, 570);
        boyAndGirlImg.setIcon(new ImageIcon("boyAndGirl.png"));
        container.add(boyAndGirlImg);



        //JButton
        createStudentButton = new JButton("Create Student");
        createStudentButton.setBackground(Theme.lightBrownColor);
        createStudentButton.setForeground(Theme.darkBlueColor);
        createStudentButton.setFont(Theme.fontSmallBold);

        showStudentsData = new JButton("Show Students Data");
        showStudentsData.setBackground(Theme.lightBrownColor);
        showStudentsData.setForeground(Theme.darkBlueColor);
        showStudentsData.setFont(Theme.fontSmallBold);

        createStudentButton.setBounds(100,370,250,50);
        showStudentsData.setBounds(100,470,250,50);


        container.add(createStudentButton);
        container.add(showStudentsData);

        createStudentButton.addActionListener(this);
        showStudentsData.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createStudentButton){
            createStudentGui = new CreateStudentGui(this);
            createStudentGui.setVisible(true);
        }
        if(e.getSource() == showStudentsData){
            getAllStudentGui = new GetAllStudentGui(this);
            getAllStudentGui.setVisible(true);

        }

    }
    public static void main(String[] argument){
        new MainGui();
    }
}
