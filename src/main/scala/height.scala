package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) | Ellipse(_, _) => 1
    case Location(_, _, shape) => 1 + apply(shape)
    case Group(shapes*) =>
      1 + (if shapes.isEmpty then 0 else shapes.map(apply).max)
end height
