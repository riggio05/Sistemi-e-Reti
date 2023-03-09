import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        //socket e buffer
        DatagramSocket sk = new DatagramSocket(8080);
        byte[] buffer = new byte[65536];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        sk.receive(packet);
        byte[] data = packet.getData();
        int len = packet.getLength();
        String msg = new String(data, 0, len);
        int port = packet.getPort(); //porta mittente
        InetAddress address = packet.getAddress(); //indirizzo mittente
        File file = new File("src/NazioniCapitali.csv");
        String risposta = "";
        byte[] bufferRisposta = risposta.getBytes();
        DatagramPacket packetRisposta = new DatagramPacket(bufferRisposta, bufferRisposta.length, address, port);
        sk.send(packetRisposta);
        sk.close();
    }
}
