package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object TraitTest {

  trait Read {
    val readType = "Read"
    val gender = "m"
    def read(name:String){
      println(name+" is reading")
    }
  }

  trait Listen {
    val listenType = "Listen"
    val gender = "m"
    def listen(name:String){
      println(name + " is listenning")
    }
  }

  trait Write {
    def write(name:String){
      println(name + " is Write")
    }
  }

  trait Run {
    def run(name:String){
      println(name + " is Run")
    }
  }

  class Person() extends Read with Listen{
    override val gender = "f"
  }

  def main(args: Array[String]): Unit = {
    val person = new Person()
    person.read("zhangsan")
    person.listen("lisi")
    println(person.listenType)
    println(person.readType)
    println(person.gender)

    val person2 = new Person() with Write with Run
    person2.write("wangwu")
    person2.run("wangwu")
  }


}
