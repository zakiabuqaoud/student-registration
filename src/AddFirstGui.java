
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddFirstGui  extends JFrame implements ActionListener {
    Container c;
    JPanel p;

    JButton b1,b2,b3;

    Font f;

    JTextField t1,t2,t3,t4,t5,t6,t7;
    JLabel l2,l3,l4,l5,l6,l7,l8,l9;

    public AddFirstGui() {
        c=getContentPane();
        setLayout(null);
        Font font =new Font("Cleaver's_Juvenia_Bloc...",Font.BOLD,40);
        p=new JPanel();
        p.setLayout(null);
        b1=new JButton("OK");
        setResizable(false);
        b2=new JButton("more");
        b3=new JButton("Back");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();


        l2=new JLabel("ID Number");
        l3=new JLabel("FirstName");
        l4=new JLabel("lastName");
        l5=new JLabel("Mid.Mark(50)");
        l6=new JLabel("FinalMark(50)");
        l7=new JLabel("Total From(100)");
        l8=new JLabel("Add New Student At Top");
        l9=new JLabel("Grade");

        //this.s1=t1.getText();

	/*this.s2=t4.getText();
	this.s3=t5.getText();*/



        Color color = new Color(255,176,176);

        f=new Font("Cleaver's_Juvenia_Bloc...",Font.HANGING_BASELINE,20);
        l8.setFont(f);

        c.setBackground(new Color(213,213,255));

        p.setSize(550,450);
        p.setBounds(0,70,600,450);
        p.setBackground(new Color(150,224,252));
        l2.setBounds(30,55,100,50);
        l3.setBounds(270,55,100,50);
        l4.setBounds(30,155,100,50);
        l5.setBounds(270,155,100,50);
        l6.setBounds(30,255,100,50);
        l7.setBounds(270,255,100,50);
        l8.setBounds(140,0,300,100);
        l9.setBounds(270,305,100,50);

        t1.setBounds(140,60,100,30);
        t2.setBounds(389,60,100,30);

        t3.setBounds(140,160,100,30);
        t4.setBounds(389,160,100,30);

        t5.setBounds(140,260,100,30);
        t6.setBounds(389,260,100,30);

        t7.setBounds(389,310,100,30);


        b1.setBounds(140,390,100,30);
        b2.setBounds(260,390,100,30);
        b3.setBounds(380,390,100,30);

        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        p.add(l2);
        p.add(t1);

        p.add(l3);
        p.add(t2);

        p.add(l4);
        p.add(t3);

        p.add(l5);
        p.add(t4);

        p.add(l6);
        p.add(t5);

        p.add(l7);
        p.add(t6);

        p.add(l9);
        p.add(t7);
        p.add(b1);
        p.add(b2);
        p.add(b3);

        t6.setEditable(false);
        t7.setEditable(false);

        add(p);
        add(l8);

        setSize(600,600);
        setVisible(true);
    }





    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
        }

        if(e.getSource()==b1){
            int m1=-1;
            int m2=-1;
            int m3=-1;
            int m4=-1;
            int m5=-1;
            int m6=-1;
            int id=0,mid=0,fn=0;

            //If Statements For Checking Inputs****************************************************************

            if(t1.getText()==null||t2.getText()==null||t3.getText()==null||t4.getText()==null||t5.getText()==null)
                JOptionPane.showMessageDialog(null,"Complete All Informations","Error",0);
            else
                m6=1;




            //If All Inputs Are Right*******************************************************************



        }

        if(e.getSource()==b3)
            this.setVisible(false);

    }

    public static void main(String[]args) {
        new AddFirstGui();
    }
}