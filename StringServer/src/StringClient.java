import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class StringClient {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket s = new Socket("localhost", 3000);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("ciao " + Math.random());

        //ricerca del testo
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        System.out.println("Il client riceve: " + in.readLine());
        s.close();
    }
}
