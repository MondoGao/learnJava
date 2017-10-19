package course.homework9;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {
    private int port;
    private HashMap<String, ArrayList<ChatConnection>> rooms = new HashMap<>();

    public ChatServer(int port) {
        this.port = port;
        this.initRoom();
    }

    private void initRoom() {
        rooms.put("default", new ArrayList<>());
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
                if (str.substring(0, 1) == ":") {
                    if (str == ":q") {
                        exit();
                    } else if (str.substring(0, 4) == ":room") {
                        String roomName = str.substring(6);

                        switchRoom(roomName);
                    } else {
                        out.println("错误的命令");
                    }
                } else {
                    broadcast(str);
                }
            }
        }

        public void send(String msg) {
            out.println(msg);
        }

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

