package org.romeo.spiral

/**
  * User: tylerromeo
  * Date: 9/22/16
  * Time: 9:50 PM
  *
  */
object Main {

  def main(args: Array[String]): Unit = {
    println(directions.take(20).toList)
    println(North.next)
    println(South.next)
    println(East.next)
    println(West.next)
  }

  sealed abstract class Direction(
                                   val next: Direction,
                                   val move: (Int, Int) => (Int, Int)
                                 )

  //directions move counterclockwise
  case object North extends Direction(West, (x, y) => (x, y + 1))
  case object South extends Direction(East, (x, y) => (x, y - 1))
  case object East extends Direction(North, (x, y) => (x + 1, y))
  case object West extends Direction(South, (x, y) => (x - 1, y))

  def directionFromNumber(n: Int): Direction = {
    n % 4  match {
      case 0 => West
      case 1 => South
      case 2 => East
      case 3 => North
    }
  }

  //Because of "Math" we know that the number of spaces that need to be moved is 1, 1, 2, 2, 3, 3, 4, 4 etc.
  //Assuming the first direction is east (english reads left to right) lets build the set of directions we'll follow when
  //moving from position to position
  val directions = Stream.from(1).map(x => (directionFromNumber(x), x/2)).flatMap{
    case (dir, n) => Stream.fill[Direction](n)(dir.next)
  }

  def makeSpiral(num: Int): String = {
    val arrayLength = scala.math.sqrt(num).ceil.toInt
    val a = Array.ofDim[Int](arrayLength, arrayLength)
    var (row, col) = findMidPoint(arrayLength)
    a(row)(col) = 1
    sprint2DArray(a)
  }

  /**
    * given the edge size of a square, find the coordinates of the midpoint. round up for row and down for column
    *
    * @param size
    * @return
    */
  def findMidPoint(size: Int): (Int, Int) = {
    ((size.toFloat / 2.0).toInt, size / 2)
  }

  /**
    * Takes a 2d array of numbers, and prints them in order with each array as a row. Takes into account line space
    *
    * @param numbers
    * @return
    */
  def sprint2DArray(numbers: Array[Array[Int]]): String = {
    val maxDigits = numbers.flatten.max.toString.length
    numbers.map(_.map { x: Int => rightPad(maxDigits, x.toString) }.mkString(" ")).mkString("\n")
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
