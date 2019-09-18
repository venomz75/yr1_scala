object UsingArrays2 {
  def main(args: Array[String]): Unit = {
    var letters = new Array[Int](5)
    letters(0) = readInt()
    letters(1) = readInt()
    letters(2) = readInt()
    letters(3) = readInt()
    letters(4) = readInt()
    
    println("The numbers in your array are:")
    println(letters(0))
    println(letters(1))
    println(letters(2))
    println(letters(3))
    println(letters(4))
  }
}