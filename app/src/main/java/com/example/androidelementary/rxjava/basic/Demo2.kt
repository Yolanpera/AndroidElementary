package com.example.androidelementary.rxjava.basic

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.schedulers.Schedulers

fun main(){
    Observable.create(ObservableOnSubscribe<Int>(fun(emitter: ObservableEmitter<Int>) {
        (1..3).forEach { emitter.onNext(it) }
    }))
            .map { i -> "I am value $i" }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe(::println)
    Thread.sleep(10000)
}