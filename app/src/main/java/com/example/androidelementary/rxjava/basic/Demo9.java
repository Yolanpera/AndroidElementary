package com.example.androidelementary.rxjava.basic;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onComplete();
        })
                .map(integer -> integer.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String x) throws Exception {
                        System.out.println(x);
                    }
                });

        Thread.sleep(1000);


    }
}
