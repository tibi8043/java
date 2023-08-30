package org.example;

//Another way to create a thread
public class MyRunable implements Runnable{

    @Override
    public void run(){
        for (int i = 10; i != 0; i--) {
            System.out.println("Thread 2 "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread 2 is finished");
    }
}
