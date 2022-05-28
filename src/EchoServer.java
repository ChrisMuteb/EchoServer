import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8002);

            while (true){
                Socket s = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

                pw.println("Hello.. Welcome to Chris' server.");
                pw.println("Print BYE to exit");
                pw.flush();

                while (true){
                    String str = br.readLine();
                    if(str == null)
                        break;

                    int v = count(str);
                    System.out.println(s.getInetAddress() +"says-> " + str);
                    pw.println("Echo: " + str + " has " + v + " vowels");
                    pw.flush();

                    if(str.trim().equals("BYE"))
                        break;
                }

                br.close();
                pw.close();
                s.close();
            }
        }catch (Exception e){}
    }
    public static int count(String names){
        int count = 0;
        for(int i = 0; i < names.length(); i++){
            switch (names.charAt(i)){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    count++;
            }
        }

        return count;
    }
}
