package com.shsxt.scala.actor

/*

  最基本的actor开发模型

 */

import scala.actors.Actor

/*
给Actor发消息
 */
class HelloActor extends Actor{
  def act(){
    while (true){
      Thread.sleep(2000)
      receive{
        case name:String => println("Hello, " + name)
        case money:Int => println("How much? " + money)
      }
    }
  }
}

object HelloActor{
  def main(args: Array[String]) {
    val helloActor = new HelloActor
    helloActor.start()
    helloActor ! 100
    var msg = ""
    while (true){
      msg = readLine()
      helloActor ! msg
    }
  }
}