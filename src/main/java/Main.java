public class Main {
    public static void main(String[] args) { // process with main thead
        System.out.println(ThreadColor.ANSI_BLUE+"Main thread has started the execution " + Thread.currentThread().getName());
        ThreadDemo td = new ThreadDemo();
//        td.functionA();
//        td.functionB();
        Thread t = new Thread(td, "A");
        t.start();
//        t.interrupt(); // main thread is stopping the execution of thread t
        Thread t2 = new Thread(td, "B");
        t2.start();



    }
}
