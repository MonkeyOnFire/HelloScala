package com.shsxt.scala

/**
  * Created by Layne on 2018/5/30.
  */
object IfOrElse {

  def main(args: Array[String]) {
    val age = 17
    if(age < 18){
      println("no allow")
    }else if(18 <= age && age <= 20){
      println("allow with other")
    }else{
      println("allow self")
    }
  }

}
