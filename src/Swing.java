import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing extends JFrame{

    private JPanel panel1;
    private JTable table1;

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
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
