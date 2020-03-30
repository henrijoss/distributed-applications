//package A2_1;
//
//import java.io.*;
//import java.net.Socket;
//
//public class TimeService implements Runnable {
//    Socket socket;
//    String input;
//
//    TimeService(Socket _socket) {
//        this.socket = _socket;
//    }
//
//    public void run() {
//        service();
//    }
//
//    public void service() {
//        try {
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//            writer.write("time service\n");
//            writer.flush();
//            while (true) {
//                input = reader.readLine();
//                if (input != null) {
//                    switch (input) {
//                        case "date":
//                            writer.write(Clock.date() + "\n");
//                            writer.flush();
//                            break;
//                        case "time":
//                            writer.write(Clock.time() + "\n");
//                            writer.flush();
//                            break;
//                        default:
//                            socket.close();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
