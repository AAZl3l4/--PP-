import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class JSXC implements Runnable{
    private final JTextArea mb;
    private MulticastSocket kdgs;

    public JSXC(JTextArea mb) {
        this.mb = mb;
    }

    @Override
    public void run() {
        try {
            kdgs = new MulticastSocket(10314);
            kdgs.joinGroup(InetAddress.getByName("224.0.0.1"));
            byte[] zj = new byte[1024];
            DatagramPacket bg = new DatagramPacket(zj, zj.length);
            while (true){
                kdgs.receive(bg);
                String ip = bg.getAddress().getHostAddress();
                int port = bg.getPort();
                String nr = new String(bg.getData(), 0, bg.getLength());
                String name = bg.getAddress().getHostName();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String s = ip +"::"+ port+"["+name+"]"+ "说:" + nr;
                        mb.append(s+"\n");
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (kdgs != null) {
                kdgs.close();
            }
        }
    }
}
