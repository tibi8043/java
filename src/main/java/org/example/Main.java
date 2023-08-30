package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello multithreading!");

        MyThread thread1 = new MyThread();

        MyRunable runable1 = new MyRunable();
        Thread thread2 = new Thread(runable1);

        //

        //Starting threads

        //thread1.start();
        //thread2.start();

        //default priority is 5
        thread2.setPriority(6);


        //if a thread getting an exception another threads still running.

        //join() if we call this method main thread will wait until that specific thread finished.
        //join(5000) in this case the main thread wait 5000 seconds.

        /*try {
            thread1.start();
            thread1.join(5000);
            System.out.println("asd");
            thread2.start();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        //jvm won't exit till one user thread is running
        //but if we change these threads to daemon threads
        thread1.setDaemon(true);
        thread2.setDaemon(true);

        //and creating an error
        System.out.println(5 / 0);

        thread1.start();
        thread2.start();
        //jvm terminate cuz there is no more user threads

    }
}