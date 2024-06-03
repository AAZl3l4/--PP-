import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class asd {
    public static void main(String[] args) {
        DatagramSocket kdgs = null;
        try {
            kdgs = new DatagramSocket();
            byte[] sj = new byte[1024];
            byte[] textBytes = "你妈妈的".getBytes();
            System.arraycopy(textBytes, 0, sj, 0, textBytes.length);
            DatagramPacket bg = new DatagramPacket(sj, textBytes.length, InetAddress.getByName("255.255.255.255"), 10314);
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
