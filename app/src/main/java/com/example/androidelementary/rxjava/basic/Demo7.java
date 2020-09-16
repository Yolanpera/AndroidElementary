package com.example.androidelementary.rxjava.basic;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Observable.merge(
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS, Schedulers.computation()), // 从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS,Schedulers.io())) // 从2开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                .observeOn(Schedulers.newThread()).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("接收到了d事件");
            }

            @Override
            public void onNext(Long value) {
                System.out.println("接收到了事件" + value);
                System.out.println(Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("接收到了e事件");
            }

            @Override
            public void onComplete() {
                System.out.println("接收到了c事件");
                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread.sleep(5000);
    }
}
