package priorityThread;


class FirstTask implements Runnable{

    @Override
    public void run(){
        while (true){
            System.out.println("F");
        }
    }
}

class SecondTask implements Runnable{

    @Override
    public void run(){
        while (true){
            System.out.println("-");
        }
    }
}
public class PriorityThread {
    public static void main(String[] args) {
        /**
         * WE can give priority to thread
         */

       Thread Firstthread = new Thread(new FirstTask());
       Firstthread.setPriority(Thread.NORM_PRIORITY+3);
       Firstthread.start();

        Thread Secondthread = new Thread(new SecondTask());
        Secondthread.start();
    }
}
