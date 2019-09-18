import scala.io.StdIn.readInt

object Triangle2 {
  def main(args: Array[String]): Unit = {
    print("Select how many units for the base and height of the triangle? ")
    val baseHeight = readInt()
    
    println()
    
    var row: Int = 1
    
    while (row <= baseHeight) {
      
      var col: Int = baseHeight
      
      while (col >= row) {
        print("* ")
        col -= 1
      }
      
      print("\n")
      row += 1
    }
    
  }
}
