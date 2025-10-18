package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale simple ellipse by 2") {
    val scaled = scale(simpleEllipse, 2.0)
    assert(scaled == Ellipse(100, 60))
  }

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

  test("scale basic group by 2") {
    val scaled = scale(basicGroup, 2.0)
    scaled match
      case Group(Ellipse(rx, ry), Rectangle(w, h)) =>
        assert(rx == 100)
        assert(ry == 60)
        assert(w == 40)
        assert(h == 80)
      case _ => fail("unexpected group structure")
  }

  test("scale simple group by 0.5") {
    val scaled = scale(simpleGroup, 0.5)
    scaled match
      case Group(Location(x1, y1, Ellipse(rx1, ry1)), Location(x2, y2, Rectangle(w2, h2))) =>
        assert(x1 == 100)
        assert(y1 == 50)
        assert(rx1 == 25)
        assert(ry1 == 15)
        assert(x2 == 200)
        assert(y2 == 150)
        assert(w2 == 50)
        assert(h2 == 25)
      case _ => fail("unexpected group structure")
  }

  test("scale complex group by 0.5") {
    val scaled = scale(complexGroup, 0.5)
    scaled match
      case Location(x, y, Group(shapes*)) =>
        assert(x == 25)
        assert(y == 50)
        assert(shapes.length == 3)
      case _ => fail("unexpected shape structure")
  }

end TestScale
