package com.shsxt.scala.actor

/*

    actor对话样例

 */

import scala.actors.Actor

/*
Actor之间相互收发消息
 */
case class Message(content:String, sender:Actor)

class LaoWangActor extends  Actor{
  def act{
    while (true){
      receive{
        case Message(content,sender) => {println("LaoWang received: " + content);  
                                              sender ! 886}
      }
    }
  }
}

class GagaActor(val LaoWangActor: LaoWangActor)extends Actor{
  def act{
    LaoWangActor ! Message("Hello, LaoWang, I'm gaga. Are you free now?", this)

    var flag = true
    while (flag){
      receive{
        case response:String => println("gaga received: "+ response)
        case response:Int => flag=false
      }
    }
    println("886")
  }
}

object Message {
  def main(args: Array[String]) {
    val LaoWangActor = new LaoWangActor
    val gagaActor = new GagaActor(LaoWangActor)
    LaoWangActor.start()
    gagaActor.start()
  }
}
