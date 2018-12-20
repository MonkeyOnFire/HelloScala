package com.shsxt.scala

/**
  * Created by Layne on 2018/5/29.
  *
  * 1.类的主构造器在类名后定义
  * 2.辅助构造器使用this关键字定义，并且必须调用主构造器（在第一行调用）
  * 3.object 定义的对象为单例对象
  * 4.伴生对象和伴生类—— 类和对象的名字一致
  * 5.scala 类中默认为public的访问权限
  * 6.伴生类可以通过import 访问伴生对象中的成员和方法
  * 7.伴生对象可以直接访问伴生类中的私有成员（属性和方法）
  *
  */
class Student(xname:String,xage:Int) {
  import Student.account

  var name = xname
  val age = xage
  var gender = "m"

  private def job = "it"
  private val sun = "jingjing"

  def this(name:String,age:Int,g:String){
    this(name,age) // this 类似于 super
    gender = g
  }

  def sayName() = {
    "my name is " + name
  }

  private def sayAccount() ={
    account
  }

}


object Student{
  val name = "zhangsanfeng"
  val account = 1800

  def printAccount(s:Student) = {
    s.sayAccount()
  }

  def printJob(s:Student) = {
    s.job
  }

  def main(args: Array[String]) {
    var stud = new Student("xiaoming",19,"f")

    println(stud.age)
    println(stud.gender)
    println(stud.sayAccount())
    println(stud.sayName())
    println(Student.name)

    println(stud)
    println(Student)
    println(Student.printAccount(stud))
    println(Student.printJob(stud))

  }

}
