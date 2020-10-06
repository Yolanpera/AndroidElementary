package com.example.androidelementary.rxjava.basic;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 最基本的使用
 * 1 创建 Observable
 * 2 创建 Observer
 * 3 实现订阅 subscribe
 */
public class Demo1 {

    private static Observable<Integer> observable;
    private static Observer<Integer> observer;
    private static Subscriber<Integer> subscriber;

    public static void main(String[] args) {
        createObservable();
        createObserver();
        observable.subscribe(observer);
    }

    private static void createObservable() {
        // 1.基础的创建 Observable 的方式
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        // 2. RxJava 扩展方法之 just
//        Observable observable = Observable.just("A", "B", "C");
//         将会依次调用：
//         onNext("A");
//         onNext("B");
//         onNext("C");
//         onCompleted();

        // 3. RxJava 扩展方法之 from
//        Integer[] words = {2, 3, 4};
//        observable = Observable.fromArray(words);
    }

    private static void createObserver() {
        observer = new Observer<Integer>() {
            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("开始采用subscribe连接");
            }

            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onNext(Integer integer) {
                System.out.println(integer.toString());
            }

            // 当被观察者生产Error事件& 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onError(Throwable e) {
                System.out.println("对Error事件作出响应");
            }

            // 当被观察者生产Complete事件& 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onComplete() {
                System.out.println("对Complete事件作出响应");
            }
        };
    }



}
