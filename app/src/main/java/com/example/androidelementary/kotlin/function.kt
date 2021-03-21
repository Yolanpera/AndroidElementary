package com.example.androidelementary.kotlin

/**
 * Created by ypp on 2021/3/18
 */

fun main() {
    val b = Holder(2)
    val a = Adapter(1, b)
    a.f1()
}

class Adapter(var n: Int, private val h: Holder) {

    private fun f() {
        n = 3
        println("n: $n")
        print("data set success")
    }

    fun f1(){
        h.bind(::f)
    }
}

class Holder(val n: Int){
    fun bind(callback: () -> Unit) {
        callback.invoke()
    }
}