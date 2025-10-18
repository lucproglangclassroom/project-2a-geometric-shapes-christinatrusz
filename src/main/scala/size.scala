package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object size:
  private val logger = Logger("Size")

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _) | Ellipse(_, _) => 1
      case Location(_, _, shape) => apply(shape)
      case Group(shapes*) => shapes.map(apply).sum

    logger.info(s"Size of $s => $result")
    result
end size
