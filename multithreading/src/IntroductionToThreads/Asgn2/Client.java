package IntroductionToThreads.Asgn2;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World. Printed by: " + Thread.currentThread().getName());

        HelloWorldPrinter hwp = new HelloWorldPrinter();
//        Thread t = new Thread(hwp);
//        t.start();
        hwp.run();

        System.out.println("Before closing. Printed by: " + Thread.currentThread().getName());
    }
}
