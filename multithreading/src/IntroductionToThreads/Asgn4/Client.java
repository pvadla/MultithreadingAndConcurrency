package IntroductionToThreads.Asgn4;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(1);

        for(int i = 1; i <= 100; i++){
            NumberPrinter np = new NumberPrinter(i);
//            Thread t = new Thread(np);
//            t.start();
            executor.execute(np);
        }
    }
}
