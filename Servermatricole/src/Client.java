import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String[] dati = new String[9100];
        File file = new File("src/datiClient.csv");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while((line = br.readLine()) != null) {
                dati[i] = line;
                i = i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket s = new Socket("localhost", 3000);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        int j = 0;
        while(j != dati.length) {
            out.println(dati[j]);
            j++;
        }
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        System.out.println("il client riceve " + in.readLine());
        s.close();
    }
}
