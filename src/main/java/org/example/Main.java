package org.example;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello threads!");

        //active threads
        System.out.println(Thread.activeCount());

        //get active threads names
        System.out.println( Thread.currentThread().getName());

        //set the priority low 1-10 high
        Thread.currentThread().setPriority(10);

        //set the name of the threads
        Thread.currentThread().setName("Main");
        System.out.println("");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());
        System.out.println("Priority of our main thread is : "+Thread.currentThread().getPriority());

        //Check is if alive
        System.out.println("Currnet thread is alive: "+Thread.currentThread().isAlive());

        //countdown
        /*for (int i = 10; i != 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }*/

        //Creating thread
        System.out.println("\n Creating threads");

        MyThread myThread = new MyThread();

        //set name of myThread thread
        myThread.setName("2nd thread");
        System.out.println(myThread.getName());
        System.out.println(myThread.getName()+"is alive?? "+myThread.isAlive());

        //no, we have to start our thread
        System.out.println("Starting "+myThread.getName());
        myThread.start();
        System.out.println(myThread.getName()+" is alive?? "+myThread.isAlive());

        //start() executes run function and the thread will be alive,
        //but run() won't start the thread.


        System.out.println("\n priority");
        //priority inherited from Thread class
        System.out.println(myThread.getPriority());
        myThread.setPriority(2);
        System.out.println(myThread.getPriority());

        System.out.println(Thread.activeCount());


        //User threads vs Daemon threads
        // default is suer thread but we can change it
        System.out.println("\n daemon threads");
        System.out.println(myThread.getName()+" thread is a daemon therad? :"+myThread.isDaemon());
        System.out.println( "set to daemon ");
        myThread.setDaemon(true);
        System.out.println(myThread.getName()+" thread is a daemon therad? :"+myThread.isDaemon());

        
    }
}