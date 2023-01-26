import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IntServer {
    public static void main(String[] args) {
        //creare il server
        try {
            ServerSocket ss = new ServerSocket(3000);
            while (true) {
                //accettare connessioni dal client
                Socket s = ss.accept();
                //leggere i dati passati
                System.out.println("Server: " + s.getInetAddress() + " "+  s.getInputStream().read());
                s.close();
                //tornare all'inizio per accettare una nuova connessione
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }



    }
}