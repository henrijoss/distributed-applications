package A1_2;

import java.util.ArrayList;

public class Result {
    private ArrayList<Integer> overallResult = new ArrayList<Integer>();
//    private int amount;
//    private int checksum = 0;

//    public Result(int _amount) {
//        this.amount = _amount;
//    }

    public synchronized void discardResult(int r) {
        this.overallResult.add(r);
//        checksum++;
    }

    public synchronized int[] generateOverallResult() {
//        while(checksum < this.amount) {
//            wait();
//        }
        return overallResult.stream().mapToInt(i -> i).toArray();
    }
}
