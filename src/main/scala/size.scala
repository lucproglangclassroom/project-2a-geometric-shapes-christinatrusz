package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.Logger

object size:
  private val logger = Logger("Size")

  def apply(s: Shape): Int =
    val result = s match
      case Rectangle(_, _) | Ellipse(_, _) => 1
      case Location(_, _, shape) => apply(shape)
      case Group(shapes*) => shapes.foldLeft(0)((acc, shape) => acc + apply(shape)) // Use of foldLeft

    logger.info(s"Size of $s => $result")
    result
end size
