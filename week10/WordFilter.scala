

object WordFilter {
  def main(args: Array[String]): Unit = {
    var inputStrings = new Array[String](5)
    var inputChars = new Array[Char](5)
    for (x <- 0 to 4) {
      println("String #" +(x+1))
      inputStrings(x) = readLine()
    }
    
    for (x <- 0 to 4) {
      println("Char #" +(x+1))
      inputChars(x) = readChar()
    }
    (0 to 4).filter(inputStrings(1).contains).foreach(println)
  }
}