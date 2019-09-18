import scala.util.Random

object HighLow {
  def main(args: Array[String]): Unit = {
    val secret = new Random().nextInt(100)
    var guess = 0
    
    do {
      print("Guess: "); guess = readInt()
      
      if (guess > secret) {
        println("Lower")
      } else if (guess < secret){
        println("Higher")
      }
    } while(guess != secret)
    
    println("Correct!")
  }
}