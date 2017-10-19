package course.homework9;

import java.util.Scanner;

public class ChatRoom {
    private static final Scanner scan = new Scanner(System.in);
    static public void run() {
        int mode = 0;

        while (mode != 1 && mode != 2) {
            System.out.println("请选择模式：1. 客户端 2. 服务端");

            if (scan.hasNextInt()) {
                mode = scan.nextInt();
            }
        }

        switch (mode) {
            case 1:
                runClient();
                break;
            case 2:
                runServer();
                break;
        }
    }

    static public void runClient() {
        System.out.print("请输入服务器端口号：");

        int port = scan.nextInt();
        scan.nextLine();

        System.out.print("请输入房间名：");

        String roomName = scan.nextLine();

        ChatClient client = new ChatClient(port, roomName);

        client.start();
    }

    static public void runServer() {
        System.out.print("请输入监听端口号：");

        int port = scan.nextInt();

        ChatServer server = new ChatServer(port);

        server.start();
    }
}
