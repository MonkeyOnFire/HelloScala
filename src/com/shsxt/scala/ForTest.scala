package com.shsxt.scala

/**
  * Created by Layne on 2018/5/30.
  *
  *
  * 1.to until
  * 2.Range(起始值,结束值,步长/差值)
  * 3.for的基本使用 <-
  * 4.嵌套for循环
  * 5.条件判断
  * 6.yield返回值
  *
  *
  */
object ForTest {

  def main(args: Array[String]) {

    //to 生产1 2 3 4 5 6 7 8 9 10的集合 完全封闭
    println(1 to 10)
    //until 生成1 2 3 4 5 6 7 8 9 的集合 坐闭右开
    println(1 until 10)

    //指定步长为2 → 1 3 5 7 9
    println(1 to(10, 2))
    //指定步长为2
    println(1 until(10, 3))

    //遍历集合
    //类似于java的增强for循环
    for (i <- 1 to 10)
      print(i + "\t")

    //for 循环基于元素遍历
    val str = "helloshsxt"
    //    println(str.toArray)
    //  <-  相当于 java 的 in
    for (i <- str) {
      println(i + " ")
    }

    //for 循环基于下标遍历
    for (i <- Range(0, str.length, 1)) {
      print(str.charAt(i) + "_")
    }


    //  多层嵌套for循环
    var count = 0
    for (i <- 1 to 10; j <- 1 until 10) {
      println("i=" + i + ", j=" + j)
//    scala中不支持count++
      count += 1
//    count = count + 1
    }
    println(count)

    for (i <- 1 until 10; j <- 1 until 10) {
      if (i >= j) {
        print(i + " * " + j + " = " + i * j + "\t")
      }
      if (i == j) {
        println()
      }
    }

    //    for循环的条件过滤
    //java版
    for (i <- 1 to 10) {
      if (i % 2 == 0) {
        print(i + " ")
      }
    }
    //scala版
    for(i <- 1 to 10;if(i%2) == 0;if(i == 4)) {
      print(i + "\t")
    }

    //yield 获取值
    //java版
    var tmp = ""
    for(i <- 1 to 10;if(i%5==0)){
      tmp += "  " + i
    }
    println(tmp)

    //scala
    val list = for(i <- 1 to 10;if(i%5==0)) yield i
    println(list)

  }
}
