import java.util.Random;

public class NumberGenerator implements Runnable {
    int number1;
    int number2;

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("1"))
            number1 = generateNo1();
        else if(Thread.currentThread().getName().equals("2"))
            number2 = generateNo2();
    }

    int generateNo1(){
        return new Random().nextInt();
    }

    int generateNo2(){
        return new Random().nextInt();
    }
}
