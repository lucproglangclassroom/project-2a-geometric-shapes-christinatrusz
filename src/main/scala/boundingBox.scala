package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) =>
      Location(0, 0, Rectangle(width, height))

    case Ellipse(rx, ry) =>
      // Ellipse bounding box: top-left (-rx, -ry), width=2*rx, height=2*ry
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

    case Location(x, y, shape) =>
      val Location(x0, y0, Rectangle(w, h)) = apply(shape)
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
end boundingBox

