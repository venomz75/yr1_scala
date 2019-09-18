import scala.io.StdIn.readInt

object MultiDimensionalTimesTable {
  def main(args: Array[String]): Unit = {
    println("Rows? ")
    var rows = readInt();	
    rows += 1
    println("Cols? ")
    var cols = readInt()
    cols += 1
    var table = Array.ofDim[Int](rows,cols) 
    var i = 0

    while (i < table.length) {	     //could be i < rows
      var j = 0
      while (j < table(i).length) {  //could be j < cols
        table(i)(j) = i * j
        j += 1
      }
      i += 1
    }
    

    i = 1
    
    while (i < table.length) {
      var j = 1
      while (j < table(i).length) {
        print(f"${table(i)(j)}%4d")
        j += 1
      }
      print("\n")
      i += 1
    }
  }
}