package A3_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        TimeServiceClient timeService = new TimeServiceClient("127.0.0.1", 75);

        String date = timeService.dateFromServer();
        String time = timeService.timeFromServer();

        System.out.println(date);
        System.out.println(time);
        timeService.closeService();
    }
}
