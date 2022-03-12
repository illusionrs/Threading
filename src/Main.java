import utils.IOUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread{

    public void run(){
       for(int i=0;i<1000;i++){
           System.out.print("A");
       }
    }
}

//Interface runnable
class MyTask implements Runnable{

    public void run(){
        for(int i=0;i<1000;i++){
            System.out.print("-");
        }
    }
}

class Copy implements Runnable{
    String src;
    String dest;

    Copy(String src, String dest){
        this.src = src;
        this.dest =  dest;
    }

    public void run(){
        try{
            IOUtils.copy(src,dest);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
public class Main {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        Thread thread = new Thread(new MyTask());
//        thread.start();
//
//        for(int i=0;i<1000;i++)
//            System.out.print("R");

        String src1 = "a.txt";
        String src2 = "b.txt";

        String dest1= "c.txt";
        String dest2 =  "d.txt";

//        Thread t1 = new Thread(new Copy(src1,dest1));
//        t1.start();
//
//        Thread t2 = new Thread(new Copy(src2,dest2));
//        t2.start();

        /**
         * Creating thread is not easy and suppose you have 100 files to copy then
         * you can not create 100 threads so to control this we use Executer Service
         */

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Copy(src1,dest1));
        executorService.execute(new Copy(src2,dest2));
        System.out.println("DONE");
        executorService.shutdown();
    }

}
