package A1;

public class Sleep extends Thread {
    private int sec;
    private String text;

    public Sleep(int _sec, String _text) {
        this.sec = _sec;
        this.text = _text;
    }

    public void run() {
        int timeLeft = sec;
        for(int i = 0; i < sec; i++) {
            System.out.println(timeLeft);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            timeLeft--;
        }
        System.out.print(text);
    }

    public static void schlafen(int m) {
        try {
            Thread.sleep(1000*m);
        } catch (InterruptedException t) {

        }
    }
}
