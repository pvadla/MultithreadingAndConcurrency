package IntroductionToThreads.Asgn6;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(2, 8, 1, 5, 6, 3, 7, 4);
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        MergeSorter ms = new MergeSorter(list, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(ms);

        // i am free to do anything which doesn't depend on the list

        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);

        executorService.shutdown();
    }
}
