package com.example.androidelementary.rxjava.basic;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 操作符
 * concat 将四个以下 Observable 组合为一个
 * merge  也是组合，没有个数限制，而且按时间顺序组合
 * intervalRange 发送一序列事件，可以设置发送初始值，个数，初始延迟，周期和线程等参数
 */
public class demo6 {
    public static void main(String[] args) throws InterruptedException {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6), Observable.just(7, 8, 9)).subscribe(System.out::println);
//        Observable.merge(
//                Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
//                    emitter.onNext(1);
//                    Thread.sleep(1000);
//                }).subscribeOn(Schedulers.io()),
//                Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
//                    emitter.onNext(2);
//                    Thread.sleep(1000);
//                }).subscribeOn(Schedulers.computation()))
//                .subscribe(System.out::println);

        // merge（）：组合多个被观察者（＜4个）一起发送数据
        // 注：合并后按照时间线并行执行
        Observable.merge(
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS,Schedulers.computation()), // 从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS,Schedulers.io())) // 从2开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                .observeOn(Schedulers.newThread()).subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("\n接收到了d事件");
                        System.out.println(d.toString());
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

        Thread.sleep(10000);

    }
}
