import scala.io.StdIn.readInt

object InXOutX {
  def main(args: Array[String]): Unit = {
    print("Enter a number ")
    var x: Int = readInt()
    
    println("You entered " + x)
    println("Your number squared is " + (x * x))
  }
}