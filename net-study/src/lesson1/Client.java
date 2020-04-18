package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/18 9:51
 * @Version 1.0
 **/
public class Client {
    private static final String HOST = "localhost";
    private static final int PORT= 9000;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST,PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

        Scanner sc = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    out.println(line);
                }
            }
        }).start();


        String str;
        while((str = in.readLine()) != null){
            System.out.println(str);
        }
    }
}
