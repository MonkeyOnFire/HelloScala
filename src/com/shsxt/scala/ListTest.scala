package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object ListTest {

  def main(args: Array[String]) {

    //创建
    val list = List(1,2,3,4,5)
    val list2 = Nil

    println(list)
    println(list2)

    //遍历
    list.foreach { x => println(x)}
    //    list.foreach { println}

    for(i <- list){
      print(i+" ")
    }

    //filter
    val list1  = list.filter { x => x>3 }
    list1.foreach { println}

    //count
    val value = list1.count { x => x>3 }
    println(value)

    //map
    val nameList = List(
      "hello shsxt",
      "hello xasxt",
      "hello shsxt"
    )
    val mapResult:List[Array[String]] = nameList.map{ x => x.split(" ") }
    mapResult.foreach{println}

    //flatmap
    val flatMapResult : List[String] = nameList.flatMap{ x => x.split(" ") }
    flatMapResult.foreach { println }

    val c1 = "百度"
    val c2 = "谷歌"
    val c3 = "搜狗"
    val c4 = "必应"

    val tmp1 = List(c1,c2,c3,c4)
    //Nil必须放在最后
    //顺序问题
    val tmp2 = c2 :: c1 :: c3 :: c4 :: Nil
    println(tmp1)
    println(tmp2)
    println("360" :: tmp2)

    //可变集合
    import scala.collection.mutable.ListBuffer
    import scala.collection.mutable.MapBuilder
    import scala.collection.mutable.ArrayBuffer
    val listBuffer = ListBuffer("a","b","c")
    listBuffer.insert(0,"d")
    listBuffer.update(0,"z")
    println(listBuffer)

    //删除
    println(tmp2.drop(1))
    //取前几
    println(tmp2.take(2))
    //修改
    println(tmp2.updated(0,"360"))
    println(tmp2)

    //:: 元素
    //::: 集合
    println(tmp1 ::: tmp2)

    //反转
    println(tmp2.reverse)
  }

}
