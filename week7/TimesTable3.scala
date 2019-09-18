import scala.io.StdIn.readInt

object TimesTable3 {
  def main(args: Array[String]): Unit = {
    print("Select how many units for the height and width of the square? ")
    val tableSize = readInt()
    
    println()
    
    var row: Int = 1
    var topLine = 1
    var topLine2 = 1
    while (row <= tableSize) {
      
      var col: Int = 1
      var line: Int = 1
      
      while (topLine <= 1) {
      print("        ")  
        while (topLine2 <= tableSize) {
          print(f"$topLine2%2d" + "   ")
          topLine2 += 1
        }
        print("\n")
        println("     " + ("-----" * tableSize))
        topLine += 1
      }
      
      while (col <= tableSize) {
        
        while (line <= 1) {
          print(f"$row%2d" + "   |")
          line += 1
        }
        
        var result = row * col
        print(f"$result%4d"+ " ")
        col += 1
      }
      
      print("\n")
      row += 1
    }
    
  }
}