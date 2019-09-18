

object DigitsToWords {
  def main(args: Array[String]): Unit = {
    val outputs: List[String] = List("ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE")
    var input: Int = 0 
    
    println("Enter a number between 0-9.")
    input = readInt()
    
    if (input > 9 || input < 0) {
      println("Your input was outside of the acceptable range (0-9).")
    } else {
      println(outputs(input))
    }
  }
}