

object InputTenNumbersIntoList {
  def main(args: Array[String]): Unit = {
    var xs: List[Int] = List()
    for (i <- 1 to 10) {
    println("Number? ")
    xs = xs :+ readInt()
    }
    //read remaining numbers here
 
    println(xs.reverse)
  }
}