

object TimesTable {
  def main(args: Array[String]): Unit = {
    var input, i: Int = 1
    
    print("Enter a number: ")
    input = readInt()
    
    while (i <= 12) {
      println(f"$i%2d"+ " x " +input+ " = " +(input*i))
      i += 1
    }
  }
}