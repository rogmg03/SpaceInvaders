package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;

    public static void serverShoot() {
        try {
            ss = new ServerSocket(7800);
            while (true) {
                s = ss.accept();
                isr = new InputStreamReader(s.getInputStream());
                br = new BufferedReader(isr);
                message = br.readLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean shot(){
        if (message == "shoot"){
            return true;
        }else{
            return false;
        }
    }



}
