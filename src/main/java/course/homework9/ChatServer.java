package course.homework9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {
    private static final String defaultRoom = "default";

    private int port;
    private ServerSocket serverSocket;
    private HashMap<String, ArrayList<ChatConnection>> rooms = new HashMap<>();

    public ChatServer(int port) {
        this.port = port;
        this.initRoom();
    }

    public void start() throws IOException {
        try {
            serverSocket = new ServerSocket(port);

            queryConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待链接并创建线程
     * @throws IOException
     */
    public void queryConnection() throws IOException {
        while (true) {
            Socket s = serverSocket.accept();
            (new ChatConnection(s)).start();
        }
    }

    private void initRoom() {
        rooms.put(defaultRoom, new ArrayList<>());
    }

    class ChatConnection extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String room;

        /**
         * 初始化
         * @param socket
         * @throws IOException
         */
        public ChatConnection(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream());
            switchRoom(defaultRoom);
        }

        /**
         * 切换房间
         * @param nextRoom - 下一个房间
         */
        public void switchRoom(String nextRoom) {
            if (room != null) {
                rooms.get(room).remove(this);
            }
            if (!rooms.containsKey(nextRoom)) {
                rooms.put(nextRoom, new ArrayList<>());
            }
            rooms.get(nextRoom).add(this);

            room = nextRoom;
        }

        public void read() throws IOException {
            String str;
            while ((str = in.readLine()) != null) {
                // 以 : 开头的视为命令
                if (str.substring(0, 1) == ":") {
                    if (str == ":q") {
                        exit();
                    } else if (str.substring(0, 4) == ":room") {
                        String roomName = str.substring(6);

                        switchRoom(roomName);
                    } else {
                        broadcast(str);
                    }
                } else {
                    broadcast(str);
                }
            }
        }

        public void send(String msg) {
            out.println(msg);
        }

        /**
         * 向同房间广播消息
         * @param msg
         */
        public void broadcast(String msg) {
            for (ChatConnection c : rooms.get(room)) {
                c.send(msg);
            }
        }

        public void exit() throws IOException {
            send(socket.getInetAddress() + "下线");
            socket.close();
            this.interrupt();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    this.exit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

