package org.romeo.spiral

/**
  * User: tylerromeo
  * Date: 9/22/16
  * Time: 9:50 PM
  *
  */
object Main {

  def main(args: Array[String]): Unit = {
    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 3
    a(1)(1) = 40
    a(0)(2) = 5
    a(1)(2) = 6
    println(Main.sprint2DArray(a))
  }

  def makeSpiral(num: Int): String = {
    "1"
  }

  /**
    * Takes a 2d array of numbers, and prints them in order with each array as a row. Takes into account line space
    * @param numbers
    * @return
    */
  def sprint2DArray(numbers: Array[Array[Int]]): String = {
    val maxDigits = numbers.flatten.max.toString.length
    numbers.map(_.map{x:Int => rightPad(maxDigits, x.toString)}.mkString(" ")).mkString("\n")
  }

  def rightPad(length: Int, src: String): String = {
    val srcLength = src.length
    if (srcLength < length) {
      src + (" " * (length - srcLength))
    } else {
      src
    }
  }

}
