import scala.io.StdIn.readInt

object XToOne {
  def main(args: Array[String]): Unit = {
    var max,i : Int = 0
    println("Enter a maximum number")
    max = readInt()
    i = max
    while (i > 0) {
      println(f"$i%4d")
      i -= 1 //decrement
    }
  }
}