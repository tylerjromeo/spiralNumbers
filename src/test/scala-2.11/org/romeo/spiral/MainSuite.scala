package org.romeo.spiral

import org.scalatest._

/**
  * User: tylerromeo
  * Date: 9/22/16
  * Time: 9:51 PM
  *
  */

class MainSuite extends FunSuite {

  //Main tests
  test("test parameter 1") {
    assert(Main.makeSpiral(1) ==
    """1""".stripMargin)
  }

  test("test parameter 2") {
    assert(Main.makeSpiral(2) ==
    """1 2""".stripMargin)
  }

  test("test parameter 3") {
    assert(Main.makeSpiral(3) ==
      """1 2
        |  3""".stripMargin.replace("\r", ""))
  }

  test("test parameter 4") {
    assert(Main.makeSpiral(4) ==
      """1 2
        |4 3""".stripMargin.replace("\r", ""))
  }

  test("test parameter 5") {
    assert(Main.makeSpiral(5) ==
      """  1 2
        |5 4 3""".stripMargin.replace("\r", ""))
  }

  test("test parameter 6") {
    assert(Main.makeSpiral(6) ==
      """6 1 2
        |5 4 3""".stripMargin.replace("\r", ""))
  }

  test("test parameter 9") {
    assert(Main.makeSpiral(9) ==
      """7 8 9
        |6 1 2
        |5 4 3""".stripMargin.replace("\r", ""))
  }

  test("test parameter 15") {
    assert(Main.makeSpiral(15) ==
      """7  8  9  10
        |6  1  2  11
        |5  4  3  12
        |   15 14 13""".stripMargin.replace("\r", ""))
  }

  test("test parameter 17") {
    assert(Main.makeSpiral(17) ==
      """   7  8  9  10
        |   6  1  2  11
        |   5  4  3  12
        |17 16 15 14 13""".stripMargin.replace("\r", ""))
  }

  test("test parameter 21") {
    assert(Main.makeSpiral(21) ==
      "21           \n20 7  8  9  10\n19 6  1  2  11\n18 5  4  3  12\n17 16 15 14 13")
  }

  test("test parameter 27") {
    assert(Main.makeSpiral(27) == "21 22 23 24 25 26\n20 7  8  9  10 27\n19 6  1  2  11  \n18 5  4  3  12  \n17 16 15 14 13  ")
  }

  //String conversion Tests
  test("test sprint array 1x1") {
    val a = Array.ofDim[Int](1, 1)
    a(0)(0) = 1
    val expected = """1"""
    assert(expected == Main.sprint2DArray(a))
  }

  test("test sprint array 1x2") {
    val a = Array.ofDim[Int](1, 2)
    a(0)(0) = 1
    a(0)(1) = 2
    val expected = """1 2"""
    assert(expected == Main.sprint2DArray(a))
  }

  test("test sprint array 2 x 1") {
    val a = Array.ofDim[Int](2, 1)
    a(0)(0) = 1
    a(1)(0) = 2
    val expected = """1
                     |2""".stripMargin.replace("\r", "")
    assert(expected == Main.sprint2DArray(a))
  }

  test("test sprint array 2 x 3") {
    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 3
    a(1)(1) = 4
    a(0)(2) = 5
    a(1)(2) = 6
    val expected = """1 3 5
                     |2 4 6""".stripMargin.replace("\r", "")
    assert(expected == Main.sprint2DArray(a))
  }

  test("test sprint array 2 x 3, two digit") {
    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 30
    a(1)(1) = 4
    a(0)(2) = 5
    a(1)(2) = 6
    val expected = """1  30 5
                     |2  4  6""".stripMargin.replace("\r", "")
    assert(expected == Main.sprint2DArray(a))
  }

  test("test sprint array with 0s") {

    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 3
    a(1)(1) = 0
    a(0)(2) = 0
    a(1)(2) = 0
    val expected = "1 3  \n2    "
    assert(expected == Main.sprint2DArray(a))
  }
}

