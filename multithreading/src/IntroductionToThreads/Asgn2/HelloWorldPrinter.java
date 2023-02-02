package IntroductionToThreads.Asgn2;

public class HelloWorldPrinter implements Runnable {
    static  void doSomething(){
        System.out.println("Doing Something. Printed by: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hello World. Printed by: " + Thread.currentThread().getName());
        doSomething();
    }
}
