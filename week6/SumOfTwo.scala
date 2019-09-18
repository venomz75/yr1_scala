

object SumOfTwo {
  def main(args: Array[String]): Unit = {
    var input1, input2, input3 : Int = 0
    println("Please enter three numbers:")
    input1 = readInt(); input2 = readInt(); input3 = readInt(); 
    
    if ((input1 + input2 == input3) || (input1 + input3 == input2) || (input2 + input3 == input1)) {
      println("YES")
    } else {
      println("NO")
    }
  }
}