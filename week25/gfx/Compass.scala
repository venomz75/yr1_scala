package gfx

object Compass {
  
  class Direction
  case object N  extends Direction
  case object NE extends Direction
  case object E  extends Direction
  case object SE extends Direction
  case object S  extends Direction
  case object SW extends Direction
  case object W  extends Direction
  case object NW extends Direction

  def left(d: Direction): Direction = d match {
    case N  => NW
    case NE => N
    case E  => NE
    case SE => E
    case S  => SE
    case SW => S
    case W  => SW
    case NW => W
  }
  
  def right(d: Direction): Direction = d match {
    case N  => NE
    case NE => E
    case E  => SE
    case SE => S
    case S  => SW
    case SW => W
    case W  => NW
    case NW => N
  }
  
}