public class Main2 {
    public static void main(String[] args) {
        NumberGenerator n = new NumberGenerator();
        Thread tNoG1 = new Thread(n, "1");
        Thread tNoG2 = new Thread(n, "2");
        tNoG1.start();
        tNoG2.start();
        try {
            tNoG1.join(); // main thread shall wait until tNoG1 thread finishes it's execution
            tNoG2.join(); // main thread shall wait until tNoG2 thread finishes it's execution
        } catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Thread has generate " + n.number1);
        System.out.println("Thread has generate " + n.number2);
    }
}
