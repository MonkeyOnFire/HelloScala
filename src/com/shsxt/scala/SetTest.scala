package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object SetTest {

  def main(args: Array[String]) {

    //创建
    val set1 = Set(1,2,3,4,4)
    val set2 = Set(1,2,5)
    //遍历
    //注意：set会自动去重
    set1.foreach { println}
    for(s <- set1){
      println(s)
    }

    println("*******")
    /**
      * 方法举例
      */

    //交集
    val set3 = set1.intersect(set2)
    set3.foreach{println}
    val set4 = set1.&(set2)
//    val set5 = set1 & set2
    set4.foreach{x=>print(x+" ")}
    println("1***差集***")
    //差集
    set1.diff(set2).foreach{x=>println(x+" ")}
    println("2***差集***")
    set1.&~(set2).foreach{x=>println(x+" ")}
    println("3***差集***")
    set2.&~(set1).foreach{x=>println(x+" ")}
    println("4***差集***")
    //子集
    println(set1.subsetOf(set2))
    //是否包含
    println("是否包含:"+set1.contains(3))


    //最大值
    println(set1.max)
    //最小值
    println(set1.min)
    println("****")

    //转成数组，list
    set1.toArray.foreach{println}
    println("****")
    set1.toList.foreach{println}
//    set1.toList.toSet

    //mkString
    println(set1.mkString)
    println(set1.mkString("\t"))


  }

}
