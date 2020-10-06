package com.example.androidelementary.rxjava.basic;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 链式调用
 * 可以使用 map flatMap 等操作符将发送的数据转换成其他形式
 * 这里对发送的每一个 Integer 转换为两个 String
 */
public class demo5 {
    public static void main(String[] args) throws InterruptedException {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            System.out.println(Thread.currentThread().getName());
            emitter.onNext(2);
            emitter.onNext(3);
        }).subscribeOn(Schedulers.io()).flatMap((Function<Integer, ObservableSource<String>>) integer -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                list.add("event" + (4- integer) + ": flat" + i);
            }
            return Observable.fromIterable(list);
        }).subscribe(System.out::println);
        Thread.sleep(1000);
    }
}
