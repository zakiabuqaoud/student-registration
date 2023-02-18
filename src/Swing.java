import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing extends JFrame{

    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;

    public Swing(){
        Container container = getContentPane();

        setVisible(true);
        setResizable(false);
        setSize(1000,700);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
