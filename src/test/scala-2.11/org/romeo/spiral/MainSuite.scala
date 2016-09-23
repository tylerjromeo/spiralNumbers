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
}

