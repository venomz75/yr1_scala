object FlatMap {
  def main(args: Array[String]): Unit = {
    var xs = List("apple","pear","banana", "kiwi")
    
    //similar to flatten
    var chars = for (x <- xs; y <- x) yield y
    println(chars)
    
    //similar to flatMap
    chars = for (x <- xs; y <- x.take(3)) yield y
    println(chars)
    
   
    //similar to flatMap followed by map
    chars = for (x <- xs; y <- x.take(3)) yield y.toUpper
    println(chars)

  }
}