package course.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static final String ip = "127.0.0.1";

    private Socket s;
    private int port;
    private PrintWriter out;
    private BufferedReader in;
    private String room;
    private boolean stopFlag = false;

    ChatClient(int port, String room) {
       this.port = port;
       this.room = room;
    }

    public ChatClient(int port) {
        this.port = port;
    }

    public void start() {
        try {
            s = new Socket(ip, port);

            out = new PrintWriter(s.getOutputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            if (!room.isEmpty()) {
                out.println(":room " + room);
                out.flush();
            }

            new Thread(() -> {
                String str;
                while (!stopFlag) {
                    try {
                        while (!(str = in.readLine()).isEmpty()) {
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        stop();
                    }
                }
            }).start();

            System.out.println("链接成功，房间名：" + room);

            Scanner scan = new Scanner(System.in);
            while (!stopFlag) {
                out.println(scan.nextLine());
                out.flush();

                System.out.println("发送成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    public void stop() {
        System.out.println("断开链接");
        try {
            if (!s.isClosed()) {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        stopFlag = true;
    }
}
