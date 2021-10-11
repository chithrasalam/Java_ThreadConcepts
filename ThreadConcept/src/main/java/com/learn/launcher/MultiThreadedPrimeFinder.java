package com.learn.launcher;

import com.learn.thread.PrimeThread;

public class MultiThreadedPrimeFinder {
    static final int nThreads = 2;

    public static void main(final String[] args) {
        final PrimeThread[] pthreads = new PrimeThread[nThreads];

        final long starttime = System.nanoTime();
        for (int i = 0; i < nThreads; i++) {
            pthreads[i] = new PrimeThread();
            pthreads[i].start();
        }
        try {
            for (int i = 0; i < nThreads; i++)
                pthreads[i].join();
            System.out.println(System.nanoTime()+"Joined");
        } catch (InterruptedException e) {
        }
        
        final long endtime = System.nanoTime(); // measure only actual execution, without any system calls

        System.out.println("The run time is " + ((endtime - starttime) / 1000000L) + " milliseconds");

        for (int i = 0; i < nThreads; i++)
            System.out.println("Thread " + i + "  Prime count: " + pthreads[i].count); // output each thread's count
        
       System.out.println("Total prime count: " + PrimeThread.totalCount.get()); // output total count
       
        for (int i = 0; i < PrimeThread.totalCount.get(); i++)
               System.out.println(""+i+": "+PrimeThread.primes[i]);
    }
}