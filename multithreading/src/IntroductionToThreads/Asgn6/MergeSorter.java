package IntroductionToThreads.Asgn6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> numbersToSort;
    ExecutorService executorService;
    public MergeSorter(List<Integer> numbersToSort, ExecutorService executorService){
        this.numbersToSort = numbersToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(numbersToSort.size() <= 1){
            return numbersToSort;
        }

        System.out.println(numbersToSort + " for " + Thread.currentThread().getName());

        List<Integer> firstHalf = new ArrayList<Integer>();
        List<Integer> secondHalf = new ArrayList<Integer>();

        int mid = numbersToSort.size() / 2;
        for(int i = 0; i < numbersToSort.size(); i++){
            if(i < mid){
                firstHalf.add(numbersToSort.get(i));
            } else {
                secondHalf.add(numbersToSort.get(i));
            }
        }

        MergeSorter firstHalfSorter = new MergeSorter(firstHalf, executorService);
        MergeSorter secondHalfSorter = new MergeSorter(secondHalf, executorService);

        Future<List<Integer>> firstSortedHalfFuture = executorService.submit(firstHalfSorter);
        Future<List<Integer>> secondSortedHalfFuture = executorService.submit(secondHalfSorter);


        List<Integer> firstSortedHalf = firstSortedHalfFuture.get();
        List<Integer> secondSortedHalf = secondSortedHalfFuture.get();

        List<Integer> sortedArray = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i < firstSortedHalf.size() && j < secondSortedHalf.size()){
            if(firstSortedHalf.get(i) < secondSortedHalf.get(j)){
                sortedArray.add(firstSortedHalf.get(i));
                i++;
            } else {
                sortedArray.add(secondSortedHalf.get(j));
                j++;
            }
        }

        while(i < firstSortedHalf.size()){
            sortedArray.add(firstSortedHalf.get(i));
            i++;
        }

        while(j < secondSortedHalf.size()){
            sortedArray.add(secondSortedHalf.get(j));
            j++;
        }

        return sortedArray;
    }
}
