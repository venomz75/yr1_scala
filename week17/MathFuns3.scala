

object MathFuns3 {
  
  def main(args: Array[String]): Unit = {
    println((1 to 10) map (x => x-1))
    println((1 to 10) map (x => x-1) map (x => x-1))
    println((1 to 10) map (x => x*x))
    println((1 to 10) map (x => x*x) map (x => x*x))
    println((1 to 10) map (x => x*x) map (x => x+1))
    println((1 to 10) map (x => x*2))
    println((1 to 10) map (x => x+1) map (x => x*2))
    println((1 to 10) map (x => x*2) map (x => x-1))
    println((1 to 10) map (x => x*x) map (x => x+1) map (x => x*2))
  }
}