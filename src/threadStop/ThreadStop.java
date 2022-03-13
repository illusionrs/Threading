package threadStop;

class MyThread extends Thread{

    public void run(){

        for(;;){
            if(interrupted())
            {
                System.out.println("break");
                break;
            }

            System.out.println("A");
        }
    }
}
public class ThreadStop {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * WE can not  use stop it will not give time to stop for thread so we will use interrupt
         */
        thread.interrupt();
    }
}
