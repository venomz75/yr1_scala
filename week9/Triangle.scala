import scala.io.StdIn.readInt

object Triangle {
  def main(args: Array[String]): Unit = {
    print("Select how many units for the base and height of the triangle? ")
    val baseHeight = readInt()
 
    println()
    
    for (row <- 1 to baseHeight) {
      for (col <- 1 to row) {
        print("* ")
      }
      print("\n")
    }
    
  }
}