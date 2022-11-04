public class AnonymousInnerThread {
    public static void main(String[] args) {

      Runnable r = new Runnable() {
          @Override
          public void run() {
              if(Thread.currentThread().getName().equals("A"))
                  functionA();
              else if (Thread.currentThread().getName().equals("B"))
                  functionB();
          }

          void functionA(){
              for(int i=0; i<10; i++) {
                  System.out.println(ThreadColor.ANSI_PURPLE + "functionA is running by thread " + Thread.currentThread().getName());
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
          }

          void functionB(){
              for(int i=0; i<10; i++)
                  System.out.println(ThreadColor.ANSI_CYAN+"functionB is running by thread " + Thread.currentThread().getName());
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
      };

      Thread t = new Thread(r, "A");
      Thread t2 = new Thread(r, "B");
      t.start();
      t2.start();
    }
}
