import java.net.*;
public class MyInetAddress {
    public static void main(String[] args) {
        try{
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
        }catch (Exception ex){}

    }
}
