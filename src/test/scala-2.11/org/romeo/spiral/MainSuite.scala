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
    """
      |1
    """.stripMargin.trim)
  }

  test("test parameter 2") {
    assert(Main.makeSpiral(2) ==
    """
      |1 2
    """.stripMargin.trim)
  }

  test("test parameter 3") {
    assert(Main.makeSpiral(3) ==
      """
        |  3
        |1 2
      """.stripMargin.trim)
  }

  test("test parameter 4") {
    assert(Main.makeSpiral(4) ==
      """
        |4 3
        |1 2
      """.stripMargin.trim)
  }

  test("test parameter 5") {
    assert(Main.makeSpiral(5) ==
      """
        |5 4 3
        |  1 2
      """.stripMargin.trim)
  }

  test("test parameter 6") {
    assert(Main.makeSpiral(6) ==
      """
        |5 4 3
        |6 1 2
      """.stripMargin.trim)
  }

  test("test parameter 9") {
    assert(Main.makeSpiral(9) ==
      """
        |5 4 3
        |6 1 2
        |7 8 9
      """.stripMargin.trim)
  }

  test("test parameter 15") {
    assert(Main.makeSpiral(15) ==
      """   15 14 13
        |5  4  3  12
        |6  1  2  11
        |7  8  9  10
      """.stripMargin.trim)
  }

  test("test parameter 17") {
    assert(Main.makeSpiral(17) ==
      """17 16 15 14 13
        |   5  4  3  12
        |   6  1  2  11
        |   7  8  9  10
      """.stripMargin.trim)
  }

  test("test parameter 21") {
    assert(Main.makeSpiral(21) ==
      """17 16 15 14 13
        |18 5  4  3  12
        |19 6  1  2  11
        |20 7  8  9  10
        |21
      """.stripMargin.trim)
  }

  test("test parameter 27") {
    assert(Main.makeSpiral(27) ==
      """17 16 15 14 13
        |18 5  4  3  12
        |19 6  1  2  11
        |20 7  8  9  10 27
        |21 22 23 24 25 26
      """.stripMargin.trim)
  }

  //String conversion Tests
  test("test sprint array 1x1") {
    val a = Array.ofDim[Int](1, 1)
    a(0)(0) = 1
    assert(Main.sprint2DArray(a) ==
    """1""")
  }

  test("test sprint array 1x2") {
    val a = Array.ofDim[Int](1, 2)
    a(0)(0) = 1
    a(0)(1) = 2
    assert(Main.sprint2DArray(a) ==
      """1 2""")
  }

  test("test sprint array 2 x 1") {
    val a = Array.ofDim[Int](2, 1)
    a(0)(0) = 1
    a(1)(0) = 2
    assert(Main.sprint2DArray(a) ==
      """1
        |2""".stripMargin)
  }

  test("test sprint array 2 x 3") {
    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 3
    a(1)(1) = 4
    a(0)(2) = 5
    a(1)(2) = 6
    assert(Main.sprint2DArray(a) ==
      """1 3 5
        |2 4 6""".stripMargin)
  }

  test("test sprint array 2 x 3, two digit") {
    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 30
    a(1)(1) = 4
    a(0)(2) = 5
    a(1)(2) = 6
    assert(Main.sprint2DArray(a) ==
      """1  30 5
        |2  4  6""".stripMargin)
  }

  test("test sprint array with 0s") {

    val a = Array.ofDim[Int](2, 3)
    a(0)(0) = 1
    a(1)(0) = 2
    a(0)(1) = 3
    a(1)(1) = 0
    a(0)(2) = 0
    a(1)(2) = 0
    assert(Main.sprint2DArray(a) ==
      """1 3
        |2""".stripMargin)
  }
}

