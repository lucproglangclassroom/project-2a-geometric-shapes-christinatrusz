package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale simple rectangle by 2") {
    val scaled = scale(simpleRectangle, 2.0)
    assert(scaled == Rectangle(160, 240))
  }

  test("scale simple location by 0.5") {
    val scaled = scale(simpleLocation, 0.5)
    scaled match
      case Location(x, y, Rectangle(w, h)) =>
        assert(x == 35)
        assert(y == 15)
        assert(w == 40)
        assert(h == 60)
      case _ => fail("unexpected shape structure")
  }

  test("scale group by 2") {
    val scaled = scale(basicGroup, 2.0)
    scaled match
      case Group(Ellipse(rx, ry), Rectangle(w, h)) =>
        assert(rx == 100)
        assert(ry == 60)
        assert(w == 40)
        assert(h == 80)
      case _ => fail("unexpected group structure")
  }

end TestScale
