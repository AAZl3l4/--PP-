import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class login extends JFrame implements Runnable {
    private int xz;
    private JTextField my;
    private JButton bt;
    private JLabel srk;
    private JPanel lg;

    login(){
        super();
        this.setContentPane(this.lg);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon II = new ImageIcon("src/PP.jpg");
        Image IM = II.getImage();
        this.setTitle("PP聊天室");
        this.setIconImage(IM);
        xz = 0;
    }

    @Override
    public void run() {
        this.setVisible(true);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = my.getText();
                if (text.equals("10314")){
                    srk.setText("密钥正确");
                    login.this.setVisible(false);
                    SwingUtilities.invokeLater(new PP());
                    login.this.dispose();
                }else {
                    xz++;
                    int a =3-xz;
                    srk.setText("密钥错误请重新输入,输入"+a+"次后关闭程序");
                    if (xz>=3){
                        System.exit(0);
                    }
                }
            }
        });

    }
}
