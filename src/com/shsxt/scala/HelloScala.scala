package com.shsxt.scala

/**
  * Created by Layne on 2018/5/29.
  */
object HelloScala {
  def main(args: Array[String]) {
    val a = "str";var b = "shsxt"
    var c = 1


    // 常量不能重新赋值a = "new"
    println(a)
    println(b)
    b = "new"
    println(b)
    println(c)

    //指定类型
    val d : Long = 1
    println(d.getClass)
    println(c.getClass)

  }
}
