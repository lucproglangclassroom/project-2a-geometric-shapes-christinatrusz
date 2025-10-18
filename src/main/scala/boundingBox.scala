package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object boundingBox:
  private val logger = Logger("BoundingBox")

  def apply(s: Shape): Location =
    val result: Location = s match
      case Rectangle(width, height) =>
        Location(0, 0, Rectangle(width, height))

      case Ellipse(rx, ry) =>
        Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

      case Location(x, y, shape) =>
        val Location(x0, y0, Rectangle(w, h)) = apply(shape).asInstanceOf[Location] // <-- fix
        Location(x + x0, y + y0, Rectangle(w, h))

      case Group(shapes*) =>
        val boxes = shapes.map(apply)
        val xs = boxes.map(_.x)
        val ys = boxes.map(_.y)
        val ws = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
        val hs = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)

        val minX = xs.min
        val minY = ys.min
        val maxX = ws.max
        val maxY = hs.max

        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

    logger.info(s"Bounding box for $s => $result")
    result
end boundingBox
