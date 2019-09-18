

object Speed {
  def main(args: Array[String]): Unit = {
    var v: Double = 0; var u: Double = 0; var a: Double = 0; var t: Double = 0;
    println("Value for u: ")
    u = readDouble();
    println("Value for a: ")
    a = readDouble();
    println("Value for t: ")
    t = readDouble();
    println("v is "+(u+a)*t)
  }
}