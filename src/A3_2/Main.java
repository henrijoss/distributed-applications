package A3_2;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Main {

    public static Clock clock = new Clock();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(75);
        Socket socket;
        do {
            try {
                socket = serverSocket.accept();
                new Thread(new TimeService(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}

