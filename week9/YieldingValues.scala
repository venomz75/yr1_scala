object YieldingValues {
  def main(args: Array[String]): Unit = {
    
    var nums = for (x <- 1 to 10) yield x * 2
    println("1. " + nums)
    
    var nums2 = for (x <- (10 until 0 by -3).toList) yield x
    println("2. " + nums2)
    
    var nums3 = for (x <- (10 to 0 by -2).toList if x < 5) yield x
    println("3. " + nums3)
    
    var nums4 = for (x <- (1 until 10).toArray) yield x
    println("4. Array: " + nums4.mkString(" ")) //printing values of array
    
    var nums5 = for (x <- List(10, 20, 30, 40, 100)) yield x / 10
    println("5. " + nums5)
    
    var chars = for (x <- ('a' to 'n').toList) yield x.toUpper
    println("6. " + chars)
    
    var str = for (x <- "HellO World" if x.isLower) yield x
    println("7. " + str)
  }
}