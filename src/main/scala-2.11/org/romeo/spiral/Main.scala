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
  }

  sealed abstract class Direction(
                                   val move: (Int, Int) => (Int, Int)
                                 )

  //directions move counterclockwise
  case object East extends Direction((x, y) => (x, y + 1))
  case object South extends Direction((x, y) => (x + 1, y))
  case object West extends Direction((x, y) => (x, y - 1))
  case object North extends Direction((x, y) => (x - 1, y))

  def directionFromNumber(n: Int): Direction = {
    n % 4  match {
      case 0 => East
      case 1 => South
      case 2 => West
      case 3 => North
    }
  }

  //Because of "Math" we know that the number of spaces that need to be moved is 1, 1, 2, 2, 3, 3, 4, 4 etc.
  //Assuming the first direction is east (english reads left to right) lets build the set of directions we'll follow when
  //moving from position to position
  val directions = Stream.from(0).map(x => (directionFromNumber(x), 1 + x/2)).flatMap{
    case (dir, n) => Stream.fill[Direction](n)(dir)
  }

  def makeSpiral(num: Int): String = {
    val arrayLength = scala.math.sqrt(num).ceil.toInt
    val a = Array.ofDim[Int](arrayLength, arrayLength)
    val coordinateOrder = directions.take(num - 1).foldLeft(List[(Int, Int)](findMidPoint(arrayLength))){
      (coords, dir) => coords ::: List(dir.move.tupled(coords.last))
    }
    coordinateOrder.zipWithIndex.foreach{
      case ((row, column), count) => a(row)(column) = count + 1
    }
    sprint2DArray(a)
  }

  /**
    * given the edge size of a square, find the coordinates of the midpoint. round up for row and down for column
    *
    * @param size
    * @return
    */
  def findMidPoint(size: Int): (Int, Int) = {
    val point = (size + 1) / 2 - 1
    (point, point)
  }

  /**
    * Takes a 2d array of numbers, and prints them in order with each array as a row. Takes into account line space
    *
    * @param numbers
    * @return
    */
  def sprint2DArray(numbers: Array[Array[Int]]): String = {
    val maxDigits = numbers.flatten.max.toString.length
    val placeholderCharacter = "?"
    def toStringWithEmptyZero(i: Int): String = if (i==0) placeholderCharacter else i.toString
    numbers.map(
      _.map{
        x: Int => rightPad(maxDigits, toStringWithEmptyZero(x))
      }.mkString(" ").trim.replace(placeholderCharacter, " ")
    ).filter(!_.trim.isEmpty).mkString("\n")
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
