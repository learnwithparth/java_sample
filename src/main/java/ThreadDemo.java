public class ThreadDemo implements Runnable {
    int count = 0; // instance variable is shared by the threads

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A"))
            functionA();
        else if (Thread.currentThread().getName().equals("B"))
            functionB();
    }

    void functionA() {
        for (int i = 0; i < 10; i++) {
            doIncrement();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.ANSI_BLUE + "functionA execution has been stopped");
                return;
            }
        }
    }

    void functionB() {
        for (int i = 0; i < 10; i++) {
            doIncrement();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void doIncrement(){ // put a lock
        System.out.println();
        synchronized (this){
            if (Thread.currentThread().getName().equals("A")) {
                System.out.println(ThreadColor.ANSI_PURPLE + "functionA is running by thread " + Thread.currentThread().getName());
                System.out.println(ThreadColor.ANSI_PURPLE + "" + (++count));
            }
            else if (Thread.currentThread().getName().equals("B")) {
                System.out.println(ThreadColor.ANSI_CYAN + "functionB is running by thread " + Thread.currentThread().getName());
                System.out.println(ThreadColor.ANSI_CYAN + "" + (++count));
            }
        }
        System.out.println();
    } // release a lock
}
