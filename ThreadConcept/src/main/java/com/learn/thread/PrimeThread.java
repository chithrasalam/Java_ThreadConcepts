package com.learn.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PrimeThread extends Thread {
    final public static long[] primes = new long[100000]; 
    static {
        primes[0] = 2; // init 1st prime only 1 time
    };

    final static AtomicLong nextNumber = new AtomicLong(3L);
    final static long MAX = 100L;

    public int count = 0; // non static local count
    public static AtomicInteger totalCount = new AtomicInteger(); // static global count
    
    public void run() {
    	
    	
        long myNumber;
        while ((myNumber = nextNumber.getAndAdd(2L)) <= MAX)
        {
        	//System.out.println("Thread " + Thread.currentThread().getId() +" - "+ myNumber+" is running");
            if (prime(myNumber)) {
                primes[totalCount.incrementAndGet()] = myNumber; // note increment and get instead of get and increment
            	
            	System.out.println("totalCount is "+totalCount);
            	
            	count++;
            }
        }
    }

    public static boolean prime(final long n) {
        final long maxI = (long) Math.sqrt(n); // faster than calculation of i*i each time
        for (long i = 3; i <= maxI; i += 2)
            if (n%i==0) return false;
        return true;
    }
}