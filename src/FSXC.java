import javax.swing.*;
import java.net.*;

public class FSXC implements Runnable{
    String text;
    public FSXC(String text) {
        this.text=text;
    }

    public FSXC(String text, JPanel nr) {
    }

    @Override
    public void run() {
        MulticastSocket kdgs = null;
        try {
            kdgs = new MulticastSocket();
            byte[] sj = text.getBytes();
//            byte[] textBytes = text.getBytes();
//            System.arraycopy(textBytes, 0, sj, 0, textBytes.length);
            DatagramPacket bg = new DatagramPacket(sj, sj.length, InetAddress.getByName("224.0.0.1"), 10314);
            kdgs.send(bg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (kdgs != null) {
                kdgs.close();
            }
        }
    }
}
