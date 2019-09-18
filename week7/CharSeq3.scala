import scala.io.StdIn.readChar

object CharSeq3 {
  def main(args: Array[String]): Unit = {
    println("Start character? ")
    var start: Char = readChar()
    
    println("End character? ")
    var end: Char = readChar()
    
    if (start > end) {
      while (end <= start) {
        print(start + " ")
        start = (start - 1).toChar
      }
    } else {
      while (start <= end) {
        print(start + " ")
        start = (start + 1).toChar
      }
    }
    
  }
}