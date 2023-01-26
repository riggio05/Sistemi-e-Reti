import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class StringServer {
    public static void main(String[] args) throws IOException {
        //creo un server di connessione
        ServerSocket ss = new ServerSocket(3000);
        while (true) {
            //rigenera la connessione
            Socket s = ss.accept();
            //ricerca del test
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            System.out.println("Il server riceve: " + in.readLine());
            //riparto

        }
    }
}