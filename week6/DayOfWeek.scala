import scala.io.StdIn.readInt

object DayOfWeek {
  def main(args: Array[String]): Unit = {
    
    println("Type in a day number ")
    var choice = readInt()
    
    val day = choice match {
      case 1 | 2 | 3 | 4 | 5 => "Weekday"
      case 6 | 7 => "Weekend"
      case _ => "Unknown day"
    }
    
    println(day)
  }
}  