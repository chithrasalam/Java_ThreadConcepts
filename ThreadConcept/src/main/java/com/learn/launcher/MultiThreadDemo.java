package com.learn.launcher;

import com.learn.thread.SimpleThread;
import com.learn.thread.SimpleThreadRunnable;

public class MultiThreadDemo {

	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			SimpleThread thread = new SimpleThread();
			thread.start();
		}
		
		 for (int i = 0; i < n; i++) {
	            Thread runnable
	                = new Thread(new SimpleThreadRunnable());
	            runnable.start();
	        }

	}

}
