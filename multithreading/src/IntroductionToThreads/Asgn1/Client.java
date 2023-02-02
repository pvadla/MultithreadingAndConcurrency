package IntroductionToThreads.Asgn1;

public class Client {

    static void doSomething(){
        System.out.println("Doing Something. Printed by: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Hello World. Printed by: " + Thread.currentThread().getName());
        doSomething();
    }
}
