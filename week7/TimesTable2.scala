import scala.io.StdIn.readInt

object TimesTable2 {
  def main(args: Array[String]): Unit = {
    print("Select how many units for the height and width of the square? ")
    val tableSize = readInt()
    
    println()
    
    var row: Int = 1
    
    while (row <= tableSize) {
      
      var col: Int = 1
      
      while (col <= tableSize) {
        var result = row * col
        print(f"$result%4d"+ " ")
        col += 1
      }
      
      print("\n")
      row += 1
    }
    
  }
}