object Operators {
  def main(args: Array[String]): Unit = {
    var y: Int = 0; var z: Int = 0;
    println("Enter a number: ")
    y = readInt()
    println("Enter a second number: ")
    z = readInt()
    println("1 x " + y + " = " + (1 * y))
    println("10 x " + y + " = " + (10 * y))
    println("100 x " + y + " = " + (100 * y))
    println(y + z);
    println(y*z);
    println(y-z);
    println((y*y)+(z*z));
    
  }
}