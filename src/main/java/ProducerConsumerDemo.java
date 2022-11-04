import java.util.Random;

public class ProducerConsumerDemo {
    public static void main(String[] args) {

        Runnable r = new Runnable() {

            int number = 0;
            boolean produced = false, consumed = false;
            @Override
            public void run() {
                if(Thread.currentThread().getName().equals("Producer")){
                    produce();
                } else if(Thread.currentThread().getName().equals("Consumer")){
                    consume();
                }
            }

            public synchronized void produce(){ // generate a number
                for(int i = 0; i<10; i++) {
                    if(!produced) {
                        number = new Random().nextInt();
                        produced= true;
                        notifyAll(); // it sends signal to the waiting thread
                    }
                    System.out.println(ThreadColor.ANSI_PURPLE + "Producer has generated the number " + number);
                    if(!consumed){
                        try {
                            wait(); // putting thread into the sleep mode, waiting for external signal
                            consumed = false;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            public synchronized void consume() { // check whether the no. is odd or even
                for (int i = 0; i < 10; i++) {
                    if(!produced){
                        try {
                            wait(10000); // timed wait
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if(!consumed) {
                        if (number % 2 == 0) {
                            System.out.println(ThreadColor.ANSI_CYAN + "No. is even");
                        } else {
                            System.out.println(ThreadColor.ANSI_CYAN + "No. is odd");
                        }
                        System.out.println(ThreadColor.ANSI_CYAN + "No. is consumed");
                        notify();
                        produced = false;
                        consumed = true;
                    }

                }
            }
        };

        Thread producer = new Thread(r, "Producer"); // new state
        Thread consumer = new Thread(r, "Consumer"); // new state
        producer.start(); // runnable
        consumer.start(); // runnable
    }
}
