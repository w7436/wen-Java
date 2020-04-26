package lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Sever
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/18 9:33
 * @Version 1.0
 **/
public class Sever {
    private static final int PORT = 9000;

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true){
            //阻塞等待，直到所有的客户端连接
            Socket client = server.accept();
            POOL.execute(new Task(client));

        }
    }
    private  static class Task implements Runnable{

        private Socket client;

        public Task(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));//从客户端读取的数据（客户端发送给服务端）
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);//发送给客户端的数据

                String str;
                //阻塞等待
                int i =1;
                while((str = in.readLine()) != null){
                    System.out.println(str);
                    out.println(i + "是啊");
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


















