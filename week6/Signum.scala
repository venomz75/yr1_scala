import scala.io.StdIn.readInt

object Signum {
  def main(args: Array[String]): Unit = {
    println("Type in a number ")
    var number = readInt()
    var result = ""
    
    if (number > 0) {
      result = "positive"
    } else if (number < 0) {
      result = "negative"
    } else {
      result = "zero"
    }
    
    println(number+ " is " +result)
  }
}