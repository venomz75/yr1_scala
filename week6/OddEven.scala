import scala.io.StdIn.readInt

object OddEven {
  def main(args: Array[String]): Unit = {
    println("Type in a number ")
    var number: Int = readInt()
    var posneg: String = ""
    var result = if (number % 2 == 0)
      "even"
    else
      "odd"
    
    if (number > 0) {
      posneg = "positive"
    } else {
      posneg = "negative"
    }
      
    if (number == 0) {
      println("Your number is zero.")
    } else {
      println("Your number is" +result+ " and " +posneg+ ".") 
    }
      
  }
}
