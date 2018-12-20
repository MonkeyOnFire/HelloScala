package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object CaseClassesTest {


  trait Run{
    var num = 1
    var run_type = () => println("慢跑")
    def run:Unit
    def running(run_type: ()=>Unit): Unit = {
      run_type()
    }
  }

  case class Person3(name:String,age:Int) extends Run {
    override def run = println("runing")
  }

  case class Person2(name:String,age:Int,mon:String){
    def sayMyMon(): Unit ={
      println(mon)
    }
  }

  case class Person1(name:String,age:Int)

  def main(args: Array[String]): Unit = {
    val p1 = new Person1("zhangsan",10)
    val p2 = Person1("lisi",20)
    val p3 = Person1("wangwu",30)
    val p4 = Person3("runner",30)
    p4.run_type = ()=> println("快跑")
    val p5 = Person3("runner",30)
    p5.run_type = ()=> println("慢跑")

    val list = List(p1,p2,p3,p4,p5)
    list.foreach { x => {
      x match {
        case Person1("zhangsan",10) => println("zhangsan")
        case Person1("lisi",20) => println("lisi")
        //多态
        case _:Run => {
          //asInstanceOf 对象转换为指定class类
          val pp2 = x.asInstanceOf[Person3]
          pp2.run
          pp2.running(pp2.run_type)
          println("i'm " + pp2.num)
        }
        case _ => println("no match")
      }
    } }

    val pp2 = new Person2("xiaoming",28,"xiaofang")
    pp2.sayMyMon()
    Person3("runner",30).run


  }

}
