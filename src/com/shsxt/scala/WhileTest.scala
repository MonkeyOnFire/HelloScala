package com.shsxt.scala

/**
  * Created by Layne on 2018/5/30.
  */
object WhileTest {

  def main(args: Array[String]) {

    //while
    var index = 0
    while(index < 100){
      println("循环第 " + (index + 1) + " 遍" )
      index += 1
    }

    //do while
    index = 0
    do{
      index += 1
      println("循环第 " + (index + 1) + " 遍" )
    }while(index < 100)

  }

}
