package com.shsxt.scala.actor

import scala.actors.Actor

/**
  * Created by Layne on 2018/4/28.
  */
object ActorTest {

  def main(args: Array[String]): Unit = {

    //创建actor的消息接收和传递
    val actor =new myActor()
    //启动
    actor.start()
    //发送消息写法
    actor ! "i love you !"
    println(actor !? true)

  }
}


class myActor extends Actor{

  def act(){
    while(true){
      receive {
        case x:String => println("save String ="+ x)
        case x:Int => println("save Int")
        case Boolean =>  reply("im fine !")
        case _ => println("save default")
      }
    }
  }
}


