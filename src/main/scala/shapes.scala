package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Ellipse(rx, ry) | Location(x, y, Shape) | Group(shapes...) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(rx: Int, ry: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)
end Shape
