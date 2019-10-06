package A1_2;

public class NewThread extends Thread {

    private int n;
    private F f;
    private Result r;

    public NewThread(int _n, F _f, Result _r) {
        this.n = _n;
        this.f = _f;
        this.r = _r;
    }

    public void run() {
        r.discardResult(f.f(n));
    }
}
