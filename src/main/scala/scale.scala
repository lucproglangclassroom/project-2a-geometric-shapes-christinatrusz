package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(w, h) =>
      Rectangle((w * factor).toInt, (h * factor).toInt)

    case Ellipse(rx, ry) =>
      Ellipse((rx * factor).toInt, (ry * factor).toInt)

    case Location(x, y, shape) =>
      Location((x * factor).toInt, (y * factor).toInt, apply(shape, factor))

    case Group(shapes*) =>
      Group(shapes.map(apply(_, factor))*)
end scale
