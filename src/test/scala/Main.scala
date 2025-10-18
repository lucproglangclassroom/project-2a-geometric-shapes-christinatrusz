package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.Rectangle

object Main:
  def main(args: Array[String]): Unit =
    // Bounding box
    println("=== Bounding Boxes ===")
    println(boundingBox(simpleRectangle))
    println(boundingBox(simpleEllipse))
    println(boundingBox(simpleLocation))
    println(boundingBox(basicGroup))
    println(boundingBox(simpleGroup))
    println(boundingBox(complexGroup))

    // Size
    println("\n=== Sizes ===")
    println(s"simpleRectangle size: ${size(simpleRectangle)}")
    println(s"complexGroup size: ${size(complexGroup)}")

    // Height
    println("\n=== Heights ===")
    println(s"simpleRectangle height: ${height(simpleRectangle)}")
    println(s"complexGroup height: ${height(complexGroup)}")

    // Scale
    println("\n=== Scaling ===")
    println(s"simpleRectangle scaled by 2: ${scale(simpleRectangle, 2.0)}")
    println(s"complexGroup scaled by 0.5: ${scale(complexGroup, 0.5)}")
end Main
