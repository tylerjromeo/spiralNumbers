package org.romeo.spiral

import org.scalatest._

/**
  * User: tylerromeo
  * Date: 9/22/16
  * Time: 9:51 PM
  *
  */

class MainSuite extends FunSuite {

  test("test parameter 1") {
    assert(Main.makeSpiral(1) ==
    """
      |1
    """.stripMargin.trim)
  }

  test("test parameter 2") {
    assert(Main.makeSpiral(1) ==
    """
      |1 2
    """.stripMargin.trim)
  }

  test("test parameter 3") {
    assert(Main.makeSpiral(1) ==
      """
        |  3
        |1 2
      """.stripMargin.trim)
  }

  test("test parameter 4") {
    assert(Main.makeSpiral(1) ==
      """
        |4 3
        |1 2
      """.stripMargin.trim)
  }

  test("test parameter 5") {
    assert(Main.makeSpiral(1) ==
      """
        |5 4 3
        |  1 2
      """.stripMargin.trim)
  }

  test("test parameter 6") {
    assert(Main.makeSpiral(1) ==
      """
        |5 4 3
        |6 1 2
      """.stripMargin.trim)
  }

  test("test parameter 9") {
    assert(Main.makeSpiral(1) ==
      """
        |5 4 3
        |6 1 2
        |7 8 9
      """.stripMargin.trim)
  }

  test("test parameter 15") {
    assert(Main.makeSpiral(1) ==
      """   15 14 13
        |5  4  3  12
        |6  1  2  11
        |7  8  9  10
      """.stripMargin.trim)
  }

  test("test parameter 17") {
    assert(Main.makeSpiral(1) ==
      """17 16 15 14 13
        |   5  4  3  12
        |   6  1  2  11
        |   7  8  9  10
      """.stripMargin.trim)
  }

  test("test parameter 21") {
    assert(Main.makeSpiral(1) ==
      """17 16 15 14 13
        |18 5  4  3  12
        |19 6  1  2  11
        |20 7  8  9  10
        |21
      """.stripMargin.trim)
  }

  test("test parameter 27") {
    assert(Main.makeSpiral(1) ==
      """17 16 15 14 13
        |18 5  4  3  12
        |19 6  1  2  11
        |20 7  8  9  10 27
        |21 22 23 24 25 26
      """.stripMargin.trim)
  }

}

