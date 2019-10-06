package A1_2;

import java.util.Random;

public interface F {
    public int f(int x);
}

class Calculator implements F {

    private int n = new Random().nextInt(100);

    public int f(int x) {
        n = n + x;
        return n;
    }
}
