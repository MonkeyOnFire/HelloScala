package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object MapTest {

  def main(args: Array[String]) {

    val map = Map(
      //K->V
      "1" -> "shsxt",
      2 -> "shsxt",
      //二元组
      (3,"xasxt")
    )

    //获取值
    println(map.get("1").get)
    println(map.get("1"))
    println(map.get("4").getOrElse("None"))
    val result = map.get(8).getOrElse("no value")
    println(result)

    //遍历
    for(x <- map){
      println("====key:"+x._1+",value:"+x._2)
    }
    map.foreach(f => {
      println("key:"+ f._1+" ,value:"+f._2)
    })



    //遍历key
    val keyIterable = map.keys
    keyIterable.foreach { key => {
      println("key:"+key+", value:"+map.get(key).get)
    } }
    println("---------")


    //遍历value
    val valueIterable = map.values
    valueIterable.foreach { value => {
      println("value: "+ value)
    } }


    //合并map
    val map1 = Map(
      (1,"a"),
      (2,"b"),
      (3,"c")
    )
    val map2 = Map(
      (1,"aa"),
      (2,"bb"),
      (2,90),
      (4,22),
      (4,"dd")
    )
    map1.++:(map2).foreach(println)
    map2.++:(map1).foreach(println)

    //添加元素
    println("添加=========")
    var map3:Map[Int,String] = Map()
    map3 += (1 -> "z")
    map3.foreach(println)
    map3 += (2 -> "new")
    map3.foreach(println)
    map3 -= 2
    map3.foreach(println)


    //常用API
    /**
      * map方法
      */
    //count
    val countResult  = map.count(p => {
      p._2.equals("shsxt")
    })
    println(countResult)

    //filter
    map.filter(_._2.equals("shsxt")).foreach(println)

    //contains
    println(map.contains(2))

    //exist 与contains不一样的地方在于可以传入一个返回布尔值的函数
    println(map.exists(f =>{
      f._2.equals("xasxt")

    }))





  }

}
