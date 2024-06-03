import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PP extends JFrame implements Runnable {
    private final ExecutorService xcc;
    private JTextArea mb;
    private JPanel PP;
    private JTextArea xxk;
    private JButton bt;
    private JScrollPane nr;

    PP(){
        ImageIcon II = new ImageIcon("img/PP.jpg");
        Image IM = II.getImage();
        this.setContentPane(this.PP);
        this.setTitle("PP聊天室");
        this.setIconImage(IM);
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mb= new JTextArea();
        mb.setLineWrap(true); // 启用自动换行
        mb.setWrapStyleWord(true);
        mb.setLayout(new BoxLayout(mb, BoxLayout.Y_AXIS));
        mb.setEditable(false);
        mb.setFocusable(false);
        nr.setViewportView(mb);
        xcc = Executors.newFixedThreadPool(16);
        xcc.submit(new JSXC(mb));
    }
    @Override
    public void run() {
        this.setVisible(true);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xcc.submit(new FSXC(xxk.getText()));
                xxk.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                xcc.shutdown(); // 关闭线程池
                System.exit(0); // 退出程序
            }
        });
        xxk.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()) {
                    bt.doClick();
                }
            }
        });
    }
}
