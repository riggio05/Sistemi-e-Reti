//Server
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author simone.riggio
 */
public class Server {
    static ArrayList<String> dati= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss= new ServerSocket(4000);
        Scanner fileReader=new Scanner(new File("src/DatiServer.csv"));
        while(fileReader.hasNextLine()){
            dati.add(fileReader.nextLine());
        }
        fileReader.close();
        while(true){
            try{
                Socket s=ss.accept();
                InputStreamReader input=new InputStreamReader(s.getInputStream());
                BufferedReader br=new BufferedReader(input);
                String datiClient=br.readLine();
                PrintStream out=new PrintStream(s.getOutputStream(), true);
                String matricola = riceviMatricola(datiClient);
                if(matricola==null){
                    out.println("Null");
                }else{
                    out.println(matricola);
                }
                input.close();
                br.close();
                out.close();
                s.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static String riceviMatricola(String matricola){
        int i=0;
        while(i<dati.size()){
            if(dati.get(i).split(";")[0].equals(matricola)){
                return dati.get(i).split(";")[1];
            }
            i++;
        }
        return null;
    }
}