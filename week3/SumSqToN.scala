

object SumSqToN {
  def main(args: Array[String]): Unit = {
    var sumSq: Double = 0; var N: Double = 4;
    sumSq = N * (N + 1) * (2 * N + 1) / 6
    println(sumSq)
  }
}