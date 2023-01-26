import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class IntClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3000);
            //inviare il numero
            s.getOutputStream().write((int) (Math.random()*10));
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
