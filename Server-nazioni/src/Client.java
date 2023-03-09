import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //socket e buffer
        DatagramSocket sk = new DatagramSocket();
        byte[] buffer = new byte[65536];
        String msg = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Di quale nazione vuoi sapere la capitale? ");
        msg = input.nextLine(); //input nazione
        DatagramPacket packet =
        new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8080); //pacchetto
        packet.setData(msg.getBytes()); //riempio il pacchetto con i dati
        sk.send(packet);
        byte[] bufferRisposta = new byte[65536]; //buffer
        DatagramPacket packetRisposta = new DatagramPacket(bufferRisposta, bufferRisposta.length);
        sk.receive(packetRisposta);
        byte[] data = packetRisposta.getData();
        int len = packetRisposta.getLength();
        String risposta = new String(data, 0, len);
        System.out.println("La capitale di " + msg + " è: " + risposta);
    }
}
