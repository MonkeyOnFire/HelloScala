package com.shsxt.scala.actor

/*

  actor
      发送消息
         !  不接受返回消息（异步）
         !? 发送信息（同步）
         !! 接收返回消息（异步）

      接收消息
         receive {模式匹配}

      回复消息
         reply("gagagagag");

 */

import scala.actors.Actor._
object Actor1 {
  def main(args: Array[String]) = {
    val badActor =
      actor {
        while (true) { //nexttpule
          receive {
            case msg =>
              println(msg);
              //回复消息
              reply("gagagagag");
          }
          Thread.sleep(5000)
        }
      }

    println("Do ya feel lucky, punk?");
    println("!?"+(badActor !? "dddddddddddddd")); //! 异步发送消息
    //这里的println打印的是返回来的值，也就是reply中的值
    println(("!!"+(badActor !! "mmmmmmmmmmmmmmm")()));
    //不接受回复的信息
    println("!"+(badActor ! "mmmmmmmmmmmmmmm"));

  }
}  
