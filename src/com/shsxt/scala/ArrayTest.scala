package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object ArrayTest {

  def main(args: Array[String]) {
    /**
      * 创建数组两种方式：
      * 1.new Array[String](3)
      * 2.直接Array
      */
    /*

    //创建类型为Int 长度为3的数组
    val arr1 = new Array[Int](3)
    //创建String 类型的数组，直接赋值
    val arr2 = Array[String]("s100","s200","s300")

    //赋值
    arr1(0) = 100
    arr1(1) = 200
    arr1(2) = 300

    //数组的遍历
    //基于元素方式的遍历
    for(i <- arr1){
      println(i)
    }

    //基于下标方式的遍历
    for(index <- 0 to arr1.length-1){
      println(index + ":" + arr1(index))
    }
    //注意Range左闭右开
    for(index <- Range(0,arr1.length)){
      println(index + ":" + arr1(index))
    }

    //高阶函数
    arr1.map(_*2).foreach(print)
    arr1.foreach(print)
    arr1.foreach(print)

*/


    /**
      * 创建二维数组和遍历
      */
    val arr3 = new Array[Array[String]](3)
    arr3(0) = Array("1", "2", "3")
    arr3(1) = Array("4", "5", "6")
    arr3(2) = Array("7", "8", "9")
    for (i <- 0 until arr3.length) {
      for (j <- 0 until arr3(i).length) {
        print(arr3(i)(j) + "	")
      }
      println()
    }

    //高阶函数遍历
    println("==============")
    arr3.foreach(x=>{x.foreach(y=>print(y + "	"));println()})

    var count = 0
    for (arr <- arr3; i <- arr) {
      if (count % 3 == 0) {
        println()
      }
      print(i + "	")
      count += 1
    }

    arr3.foreach { arr => {
      arr.foreach {
        println
      }
    }
    }


    val arr4 = Array[Array[Int]](Array(1, 2, 3), Array(4, 5, 6))
    arr4.foreach { arr => {
      arr.foreach(i => {
        println(i)
      })
    }
    }
    println("-------")
    for (arr <- arr4; i <- arr) {
      println(i)

    }


    val printArray = (arr:Array[Array[Int]])=>{arr.foreach(arr=>{arr.foreach(y=>print(y + "	"));println()})}
    val arr5 = new Array[Int](5)
    printArray(Array.fill(5,5)(1))
    Array.copy(Array.fill(5)(1),0,arr5,0,5)
    arr5.foreach(print)
  }
}
