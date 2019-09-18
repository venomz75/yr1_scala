

object SumCubesToN {
  def main(args: Array[String]): Unit = {
    var sumcubes: Double = 0;  var n: Double = 0;
    println("enter a number")
    n = readDouble();
    sumcubes = (n*n) * ((n + 1)*(n+1)) / 4
    println(sumcubes)
  }
}