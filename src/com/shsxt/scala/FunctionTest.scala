package com.shsxt.scala

import java.util.Date

/**
  * Created by Layne on 2018/5/30.
  */
object FunctionTest {

  //基本的函数定义
  def baseFunc(a:Int,b:Int):Int={
    //注意：有return时必须指定返回值类型
    return a + b
  }

  //省略retuen，默认返回最后一行的值
  //当没有return时，可以省略返回值类型的定义，scala会做自动类型推断
  def noReturnFunc(a:Int,b:Int)={
    // 形式参数为val 所以不允许重新赋值 a = 1
    a + b
  }

  //当只有一行的方法体时，可以省略{}
  def oneLineFunc(a:Int,b:Int):Int=a+b


  //当去掉方法体前的等号是，所有的返回值都会转为Unit，并且值会被抛弃
  def noDenghaoFunc(a:Int,b:Int){
    a + b
  }


  //递归函数
  def func1(num:Int):Int={
    if(num == 1){
      num
    }else{
      num * func1(num - 1)
    }
  }

  //默认值参数函数
  def func2(a:Int=1,b:Int=0) : String = {
    "y = " + a + "x+" + b
  }

  //可变长度参数的函数
  def func3(initNum:Int,nums:Int*):Int={
    var sum = 0 + initNum
    for(i <- nums){
      sum += i
    }
    sum
  }

  //嵌套函数
  def func4(num:Int):Int = {

    def funcInFunc4(a:Int,b:Int):Int = {
      if(a==1)
        b
      else
        funcInFunc4(a-1,a*b)
    }
    funcInFunc4(num,1)

  }


  // 匿名函数

  //有参匿名函数
  val func5 = (x:Int) => x*2

  //无参匿名函数
  val func6 = () => println("无参数匿名函数")

  //当函数声明的时候如果没有括号，则调用的时候也不需要括号
  def func8: Unit ={
      println("无参数匿名函数")
  }

  def func9 = 1

  //有返回值的匿名函数
  val func7 = (x:Int) => x*2


  /**
    * 高阶函数
    * 函数的参数是函数		或者函数的返回是函数		或者函数的参数和返回都是函数
    */

  //函数的参数是函数
  def hightFun(f : (Int,Int) =>Int, a:Int ) : Int = {
    f(a,100)
  }

  //函数的返回是函数
  //1，2,3,4相加
  def hightFun2(a : Int,b:Int) : (Int,Int)=>Int = {
    def f2 (v1: Int,v2:Int) :Int = {
      v1+v2+a+b
    }
    f2
  }

  //函数的参数是函数，函数的返回是函数
  def hightFun3(f : (Int ,Int) => Int) : (Int,Int) => Int = {
    f
  }

  /**
    * 偏应用函数
    */
  def log(date :Date, s :String)= {
    println("date is "+ date +",log is "+ s)
  }


  def getMysqlConection(
                         ip:String,
                         port:String,
                         username:String,
                         password:String,
                         dbName:String,
                         charset:String,
                         table:String,
                         field1:String,
                         field2:String,
                         field3:String,
                         field4:String,
                         field5:String,
                         field6:String
                       )= {
    ip+" "+port+" "+ username +" "+ password +" "+ dbName +" "+ charset
  }


  /**
    * 柯里化函数
    */
  //柯里化前
  def fun11(a :Int,b:Int,c:Int,d:Int) = {
    a+b+c+d
  }

  //柯里化后
  def fun12(a :Int,b:Int)(c:Int,d:Int) = {
    a+b+c+d
  }



  def main(args: Array[String]) {
    /*
    println("基本函数定义:"+baseFunc(1,2))
    println("没有return关键字:" + noReturnFunc(2,3))
    println("只有一行方法体:" + oneLineFunc(3,4))
    println("noDenghaoFunc:" + noDenghaoFunc(4,5))

    println("递归函数-阶乘"+func1(5))
    println("等式 :"+func2(5,2))
    println("求和 :" + func3(10,1,2,3,4,5,6,7,8,9,10))

    //匿名函数
    println(func5(2))
    func6
    func8

    //高阶函数
    def f(v1 :Int,v2: Int):Int  = {
      v1+v2
    }




    //f : (Int,Int) =>Int, a:Int
    println("参数为函数："+hightFun( (x:Int,y:Int)=>{x*y} ,10))
    println("参数为函数："+hightFun( f ,10))
    println("返回值为函数："+hightFun2(4,5))
    println("返回值和参数为函数："+hightFun3(f)(4,5))

    println(hightFun3(f)(100,200))
    println(hightFun3((a,b) =>{a+b})(200,200))
    //以上这句话还可以写成这样
    //如果函数的参数在方法体中只使用了一次 那么可以写成_表示
    println(hightFun3(_+_)(200,200))

    val list = List(1,2,3,4,5,6,7,8,9,10)
    println("求和："+list.reduce(_+_))
    println("求和："+list.reduce( (x,y)=>x+y) )

    println("行矩阵*2"+list.map(x=>x*2))

    println("偶数"+list.filter( _%2==0 ))

    val words = List("a c s d w q e s z c s a c a q w e z x c s","a c s d w q e s z c s a c a q w e z x c s")
    words.map(_.split(" "))

    println(
      words.flatMap(_.split(" ")) //List(a,c,s,d,w,q,e,s...z,x,c,s)
        .map(x=>(x,1))    //  List((a,1),(c,1),(s,1)...)
        .groupBy(_._1)    //根据第一个元素分组，返回Map  如 { a:List[(a,1),(a,1),(a,1),(a,1)] , b:[(b,1),(b,1)] .. }
        .map(x=>(x._1,x._2.length))) //返回Map(a:5,b:2....)



    val date = new Date()
    log(date ,"log1")
    log(date ,"log2")
    log(date ,"log3")

    //想要调用log，以上变化的是第二个参数，可以用偏应用函数处理
    val logWithDate = log(date,_:String)
    logWithDate("log11")
    logWithDate("log22")
    logWithDate("log33")

    //192.168.100.111 生产环境的库
    //192.168.100.112 开发环境的库
    val mysqlClientPRO =  getMysqlConection("192.168.100.111","3306","root","123456","test_db","test","utf-8","a","a","a","a","a","a")
    val mysqlClientDEV =  getMysqlConection("192.168.100.111","3306","root","123456","test_db","test","utf-8","a","a","a","a","a","a")

    val getMysqlConectionPRO = getMysqlConection("192.168.100.111","3306",_:String,_:String,_:String,_:String,"utf-8","a","a","a","a","a","a")
    val getMysqlConectionDev = getMysqlConection("192.168.100.112","3306",_:String,_:String,_:String,_:String,"utf-8","a","a","a","a","a","a")

    println(getMysqlConectionPRO("test01","test01","test01_db","test01_tab"))
    println(getMysqlConectionDev("test0","test01","test01_db","test01_tab"))
*/

    println(fun11(1,2,3,4))
    println(fun12(1,2)(3,4))

    //高阶函数实现 柯里化的核心思想，逐个传参处理
    val func13 = (a:Int) => (b:Int) => a+b

    println(func13(1)(2))

    //简化高阶函数实现柯里化
    def func14(a:Int)(b:Int) = a+b

    def func15(f:(Int,Int)=>Unit)(b:Int)(c:Int) = f(b,c)

    func15((a,b)=> println("y="+a+"*x+"+b))(1)(2)


  }

}
