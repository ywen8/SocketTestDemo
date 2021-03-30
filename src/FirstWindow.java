import javax.swing.*;
import java.awt.*;

public class FirstWindow extends JFrame {

    public FirstWindow() throws HeadlessException {
        this.setTitle("socket操作窗口");
        this.setBounds(0,0,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
