package com.shsxt.scala

/**
  * Created by Layne on 2018/5/29.
  */

//定义类
class Person {
  val name = "zhangsan"
  val age = 18
  def sayName() = {
    "my name is " + name
  }
}



object Test{

  def main(args: Array[String]) {
    //创建对象
    val p = new Person()
    println(p.age)
    println(p.sayName())
  }
}
