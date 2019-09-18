

object LowerCaesar {
  def main(args: Array[String]): Unit = {
    var input = readLine("Enter your string: ")
    var inputArray = Array[String]()
    for (x <- 0 to input.length-3) {
      inputArray(x) = input.substring(x,x+1)
    }
    var output = for (x <- 0 to input.length-1)  yield inputArray.toString
    println("Your output: " +output)
  }
}