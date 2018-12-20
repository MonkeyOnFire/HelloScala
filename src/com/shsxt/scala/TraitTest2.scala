package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object TraitTest2 {

    def main(args: Array[String]): Unit = {
      val p1 = new Point(1,2)
      val p2 = new Point(1,3)
      println(p1.isEqule(p2))
      println(p1.isNotEqule(p2))
    }
  }

  trait Equle{
    def isEqule(x:Any) :Boolean

    def isNotEqule(x : Any)  = {
      !isEqule(x)
    }
  }

  class Point(x:Int, y:Int) extends Equle {
    val xx = x
    val yy = y

    def isEqule(p:Any) = {
      p.isInstanceOf[Point] && p.asInstanceOf[Point].xx==xx
    }

}
