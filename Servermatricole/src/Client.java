import java.io.*;
import java.net.Socket;

/**
 * @author simone.riggio
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String[] dati=new String[9100]; //numero di matricole e nome e cognome presenti nel file
        String[] tel=new String[9100];
        try (FileReader f=new FileReader("src/DatiClient.csv");
             BufferedReader b = new BufferedReader(f)) {
            String line;
            int i=0;
            while((line=b.readLine()) !=null){
                dati[i]=line;
                i++;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        int j=0;
        while(j != 9100) {
            try (Socket s = new Socket("localhost", 4000)){
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                InputStreamReader isr= new InputStreamReader(s.getInputStream());
                BufferedReader in=new BufferedReader(isr);
                out.println(dati[j].split(";")[0]);
                tel[j]= in.readLine();
                j++;
                out.close();
                in.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        try (FileWriter fw = new FileWriter("src/DatiUtenti.csv")) {
            for (int i = 0; i < dati.length; i++) {
                fw.write(dati[i]+ ";"+tel[i]+"\n");
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("File creato");
    }
}
