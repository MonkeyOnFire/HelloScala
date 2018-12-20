package com.shsxt.scala

/**
  * Created by Layne on 2018/6/2.
  */
object StringTest {

  def +(a:Int): Unit ={
    a
  }

  def main(args: Array[String]) {

    /**
      * String && StringBuilder
      */
    val str = "abcd"
    val str1 = "ABCD"

    println(str.indexOf(97))
    println(Char.char2int('A'))
    println(str.indexOf("b"))

    println(str==str1)
    /**
      * compareToIgnoreCase
      *
      * 如果参数字符串等于此字符串，则返回值 0；
      * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
      * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
      *
      */
    println(str.compareToIgnoreCase(str1))

    val strBuilder = new StringBuilder
    strBuilder.append("abc")
    //    strBuilder.+('d')

    //返回新的StringBuilder对象
    strBuilder+ 'd'
    //    strBuilder.++=("efg")
    //追加字符串到结尾
    strBuilder++= "efg"
    //    strBuilder.+=('h')

    //追加一个字符到结尾
    strBuilder+= 'h'
    strBuilder.append(1.0)
    strBuilder.append(18f)
    println(strBuilder)

    println(strBuilder.append("abc") == strBuilder.append("b"))
    println(strBuilder.append("abc").hashCode())
    println((strBuilder+ 'd').hashCode())

    //定义+号的方法
    println(StringTest + 1 )

  }



}
