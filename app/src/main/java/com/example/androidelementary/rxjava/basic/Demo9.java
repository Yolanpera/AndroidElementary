package com.example.androidelementary.rxjava.basic;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Observer 的创建也有方便方法，虽然有四个抽象方法， 但可以按照顺序传入其中的某几个
 * 比如这里只传入了一个 Consumer，当然也可以用 Lambda 表达式
 */
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onComplete();
        })
                .map(integer -> integer.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(x -> System.out.println(x));

        Thread.sleep(1000);
    }
}
