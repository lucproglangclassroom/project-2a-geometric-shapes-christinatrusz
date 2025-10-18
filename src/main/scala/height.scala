package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object height:
  private val logger = Logger("Height")

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _) | Ellipse(_, _) => 1
      case Location(_, _, shape) => 1 + apply(shape)
      case Group(shapes*) =>
        1 + (if shapes.isEmpty then 0 else shapes.map(apply).max)

    logger.info(s"Height of $s => $result")
    result
end height
