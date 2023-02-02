import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Server {
    public static void main(String[] args) throws IOException {
        String[] dati = new String[9100];
        File f = new File("src/DatiServer.csv");

        try (BufferedReader br =new BufferedReader(new FileReader(f))) {
            String line;
            int i = 0;
            while ((line = br.readLine())) {
                dati[i] = line;
                i++;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}