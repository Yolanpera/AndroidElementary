package com.example.androidelementary.rxjava.basic;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 清楚 Observer 接口的四个抽象方法的含义
 * 1 onSubscribe(Disposable d) 为Observer提供以同步和异步方式取消与Observable的连接的方法。
 * 2 onNext(T t) 为Observer提供一个新的观察对象
 * 3 onError(Throwable e) 通知 Observer Observable 发生错误情况。
 * 4 onComplete() 通知 Observer Observable 已经发送完毕
 */
public class demo4 {
    public static void main(String[] args) {

        Observer<Integer> observer = new Observer<Integer>() {
            // 1. 定义Disposable类变量
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                // 2. 对Disposable类变量赋值
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                System.out.println(value);
                if (value == 2) {
                    // 设置在接收到第二个事件后切断观察者和被观察者的连接
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        Observable.just(1, 2, 3, 5).subscribe(observer);

    }
}
