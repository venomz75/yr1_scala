object MultipleGenerators {
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 5; y <- 1 to 5) {
      println("x: " + x + ", y: " + y)
    }
    
    println()
    
    var xs =  for (x <- ('a' to 'g').toList; y <- 'a' to 'g') yield x + "" + y
    println(xs) 
  }
}