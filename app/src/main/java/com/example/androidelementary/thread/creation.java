package com.example.androidelementary.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ypp on 2021/3/10
 */
public class creation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1
        Thread thread1 = new FirstThread();
        thread1.start();

        //2
        SecondThread thread2 = new SecondThread();
        Thread thread = new Thread(thread2);
        thread.start();

        new Thread(() -> System.out.println("second thread - 2")).start();

        //3
        FutureTask<String> future = new FutureTask<>(new ThirdThread());
        Thread thread3 = new Thread(future);
        thread3.start();

        String value = future.get();
        System.out.println(value);

        //4
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()-> System.out.println("fourth thread"));
        executorService.shutdown();

        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                2,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.execute(()-> {
                    System.out.println(Thread.currentThread().getName() + " I'm in");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
        Thread.sleep(1000);
    }

    public static class FirstThread extends Thread{
        @Override
        public void run() {
            System.out.println("first thread");
        }
    }

    public static class SecondThread implements Runnable{
        @Override
        public void run() {
            System.out.println("second thread");
        }
    }

    public static class ThirdThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("third thread");
            Thread.sleep(10000);
            return "return value";
        }
    }

}
