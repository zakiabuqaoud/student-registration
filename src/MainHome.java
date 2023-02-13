
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainHome extends JFrame implements ActionListener {


    JMenuItem createStudent, editStudent, deleteStudent, studentsTable;
    JMenu operation, displayStudent;

//    CreateStudentGui cs ;


    //The List We Work On *****************************************


    public MainHome() {


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setVisible(true);
        setResizable(false);

//        cs = new CreateStudentGui(this);
//        cs.setVisible(false);



        //creatList.list = this.list;


        //*****************************menu****************************//
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(0, 0, 794, 29);
        add(menuBar);

        //*************************JMenu*******************************//
        operation = new JMenu("Operation");
        menuBar.add(operation);

        displayStudent = new JMenu("Display");
        menuBar.add(displayStudent);

        //************************JMenuItem*************************//
        createStudent = new JMenuItem("Create");
        operation.add(createStudent);

        editStudent = new JMenuItem("Edit");
        operation.add(editStudent);

        deleteStudent = new JMenuItem("delete");
        operation.add(deleteStudent);

        studentsTable = new JMenuItem("table");
        displayStudent.add(studentsTable);

        //***************************************************************//

        //***************************img********************************//
        JLabel l1 = new JLabel("New label");
        l1.setBounds(0, 28, 350, 305);
        l1.setIcon(new ImageIcon("C:\\Users\\MS\\Desktop\\book.png"));
        add(l1);
        //**************************************************************//

        JPanel panel = new JPanel();
        panel.setBounds(0, 333, 350, 188);
        panel.setBackground(Theme.lightBlueColor);
        add(panel);
        panel.setLayout(null);

        //*************************panel******************************//
        JPanel panel2 = new JPanel();
        panel2.setBounds(351, 28, 443, 493);
        panel2.setBackground(new Color(255, 255, 255));
        add(panel2);
        panel2.setLayout(null);
        //***********************************************************//

        //*********************Label: Register students*************//
        JLabel l2 = new JLabel("Registationr students");
        l2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 19));
        l2.setForeground(Color.WHITE);
        l2.setBounds(88, 0, 182, 72);
        panel.add(l2);
        //*************************************************************//

        //********************Label:By: Zake************//

        JLabel l3 = new JLabel("--By : Zake--");
        l3.setForeground(Color.WHITE);
        l3.setBounds(105, 68, 166, 14);
        panel.add(l3);
        //************************************************************//

        //*************************Label:About The System :**********//
        JLabel l4 = new JLabel("About The System :");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setForeground(Color.BLACK);
        l4.setBounds(10, 5, 433, 37);
        panel2.add(l4);
        //**********************************************************//

        createStudent.addActionListener(this);
        editStudent.addActionListener(this);
        deleteStudent.addActionListener(this);
        studentsTable.addActionListener(this);

	/*if(list == null||list.first == null) {
		creat.setEnabled(true);
	}
	else {
		Delet.setEnabled(true);
		Print.setEnabled(true);
		atfirst.setEnabled(true);
		atseccound.setEnabled(true);
		atlast.setEnabled(true);
	}*/
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == createStudent) {
//            cs.setVisible(true);
        }

    }


    public static void main(String[] args) {
        MainHome m = new MainHome();
    }
}

