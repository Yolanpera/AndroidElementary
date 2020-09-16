package com.example.androidelementary.rxjava;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class HiRxjava {

    public static void main(String[] args) {
//        create_one();
//        create_two();
        create_three();
    }

    public static void create_one() {
        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                boolean disposed = d.isDisposed();
                System.out.println("onSubscribe:" + d.toString() + ";disposed值为 :" + disposed);
                System.out.println("1");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s);
                System.out.println("2");

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
                System.out.println("3");

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                System.out.println("4");

            }
        };

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hi");
                emitter.onComplete();
//                emitter.onError(new Exception("error"));
            }
        });

        observable.subscribe(observer);
    }

    public static void create_two() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello 2");
                emitter.onComplete();
            }
        });
        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("accept:s值为：" + s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("accept:throwable的值为:" + throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("run 工作");
            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                System.out.println("disposable的值为:" + disposable.isDisposed());
            }
        });
    }

    private static void create_three() {
        Observable<String> observable = Observable.just("just1", "just2");
        observable.subscribe(s -> System.out.println(s));
    }



}
