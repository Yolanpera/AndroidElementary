package com.example.androidelementary.rxjava.basic;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class demo5 {
    public static void main(String[] args) throws InterruptedException {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            System.out.println(Thread.currentThread().getName());
            emitter.onNext(2);
            emitter.onNext(3);
        }).subscribeOn(Schedulers.io()).flatMap((Function<Integer, ObservableSource<String>>) integer -> {
            final List<String> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                list.add("event" + (4- integer) + ": flat" + i);
            }
            return Observable.fromIterable(list);
        }).subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
