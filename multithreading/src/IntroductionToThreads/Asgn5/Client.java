package IntroductionToThreads.Asgn5;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random r = new Random();
        GreetingsCreator gc = new GreetingsCreator(r);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 1; i <= 100; i++){
            Future<String> greetingFuture = executor.submit(gc);
            System.out.println(greetingFuture.get());
        }

        executor.shutdown();
    }
}
