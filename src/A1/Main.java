package A1;

public class Main {

	public static void main(String[] args) {
		eieruhr(5000, "Eieruhr gestoppt");
	}

	public static void eieruhr(int millisec, String text) {
	    int sec = millisec/1000;
		Sleep t = new Sleep(sec, text);
		t.start();
	}
}
