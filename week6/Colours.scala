

object Colours {
  def main(args: Array[String]): Unit = {
      val colours: List[String] = List("none","red","orange","yellow","green","blue","indigo","violet")
      var input: Int = 0
      
      print("Enter a number between 1-7: ")
      input = readInt()
      if (input > 7 || input < 1) {
        println("Illegal number.")
      } else {
        var answer: String = readLine("Now enter the colour of the rainbow corresponding to your number(with red = 1, violet = 7): ")
        if (answer == colours(input)) {
          println("Correct!")
        } else {
          println("Incorrect...")
        }
      }      
  }
}