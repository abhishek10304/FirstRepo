package com.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class CallableDemo implements Callable<String> {

	private long waitTime;
	
	public CallableDemo(int timeInMillis){
		this.waitTime=timeInMillis;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
	}

}

public class FutureTaskExample {

	public static void main(String[] args) {
		CallableDemo callable1 = new CallableDemo(1000);
		CallableDemo callable2 = new CallableDemo(2000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		
		while (true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){
					System.out.println("Done");
					//shut down executor service
					executor.shutdown();
					return;
				}
				
				if(!futureTask1.isDone()){
				//wait indefinitely for future task to complete
				System.out.println("FutureTask1 output="+futureTask1.get());
				}
				
				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if(s !=null){
					System.out.println("FutureTask2 output="+s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
/*
 * When we run above program, you will notice that it doesn’t print anything for sometime because 
 * get() method of FutureTask waits for the task to get completed and then returns the output object. 
 * There is an overloaded method also to wait for only specified amount of time and we are using it for futureTask2. 
 * Also notice the use of isDone() method to make sure program gets terminated once all the tasks are executed.*/
