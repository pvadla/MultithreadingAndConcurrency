package IntroductionToThreads.Asgn4;

public class NumberPrinter implements Runnable {
    int numberToPrint;
    NumberPrinter(int numberToPrint){
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " printed by: + " + Thread.currentThread().getName());
    }
}
