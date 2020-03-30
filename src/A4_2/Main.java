package A4_2;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private static SSLSocket socket;
    private static String host;
    private static String path;
    private static StringBuilder response = new StringBuilder();

    public static void main(String[] args) {
        String url = "https://www.bundestag.de/presse";
        if (urlExists(url)) {
            System.out.println(response.toString());
        } else {
            System.out.println("Something went wrong");
        }
    }

    private static boolean urlExists(String _url) {
        return checkURL(_url) && checkConnection() && checkResponse();
    }

    private static boolean checkURL(String _url) {
            Matcher matcher = Pattern.compile("https:\\/\\/www\\..*?\\..+").matcher(_url);
            if (matcher.find()) {
                try {
                    URL url = new URL(_url);
                    host = url.getHost();
                    path = url.getPath();
                    System.out.println("URL is valid");
                    return true;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    System.out.println("Invalid URL");
                    return false;
                }
            } else {
                System.out.println("Invalid URL");
                return false;
            }
    }

    private static boolean checkConnection() {
        try {
            socket = (SSLSocket) factory.createSocket(host, 443);
            System.out.println("Connection is build up");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection refused");
            return false;
        }
    }

    private static boolean checkResponse() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.write("GET " + path + " HTTP/1.1\nHost: " + host + "\n\n");
            writer.flush();

            String text = reader.readLine();

            while (text != null) {
                response.append(text).append("\n");
                text = reader.readLine();
            }

            if (response.toString().endsWith("</html>\n")) {
                return response.toString().endsWith("</html>\n");
            } else {
                System.out.println("Response does not end with </html>");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
            return false;
        }
    }
}



//            Matcher matcher = Pattern.compile(".*?<html.*?>.*?</html>.*?").matcher(response.toString());
//            if (matcher.find()) {
//                System.out.println("response good");
//                return true;
//            } else {
//                System.out.println("No valid html document");
//                return false;
//            }

