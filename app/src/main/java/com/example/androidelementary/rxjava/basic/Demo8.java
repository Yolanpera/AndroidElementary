package com.example.androidelementary.rxjava.basic;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Demo8 {
    public static void main(String[] args) {
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onError(new Throwable("发生错误了"));
//            e.onComplete();
        })
                // 1. 当Observable每发送1次数据事件就会调用1次
                .doOnEach(integerNotification -> System.out.println("doOnEach: " + integerNotification.getValue()))
                // 2. 执行Next事件前调用
                .doOnNext(integer -> System.out.println("doOnNext: " + integer))
                // 3. 执行Next事件后调用
                .doAfterNext(integer -> System.out.println("doAfterNext: " + integer))
                // 4. Observable正常发送事件完毕后调用
                .doOnComplete(() -> System.out.println("doOnComplete: "))
                // 5. Observable发送错误事件时调用
                .doOnError(throwable -> System.out.println("doOnError: " + throwable.getMessage()))
                // 6. 观察者订阅时调用
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: "))
                // 7. Observable发送事件完毕后调用，无论正常发送完毕 / 异常终止
                .doAfterTerminate(() -> System.out.println("doAfterTerminate: "))
                // 8. 最后执行
                .doFinally(() -> System.out.println("doFinally: "))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        System.out.println("接收到了事件" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("对Complete事件作出响应");
                    }
                });

    }
}
