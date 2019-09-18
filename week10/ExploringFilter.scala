object ExploringFilter {
  def main(args: Array[String]): Unit = {
    
    println("1. Filtering list elements:")
   
    var words = List("apple", "banana", "pear", "grape", "kiwi")
    
    //filter returns a new list
    var filteredWords = words.filter(x => x.length() > 4)
    println(filteredWords)
    
    //filter can be chained with foreach in a single expression
    words.filter(x => !x.startsWith("b")).foreach(println)
    
    //shorthand lambda expression - same as x => x % 3 == 0
    var nums = List.range(1, 30).filter(_ % 3 == 0)
    println(nums)
    
    
    println("\n2. Filtering characters in string:")
    
    //shorthand notation - _.isLetter same as x => x.isLetter
    "Some kind of sentence".filter(_.isLetter).foreach(x => print(x.toUpper + "-"))
    
    
    println("\n\n3. Filtering array elements:")
    
    Array(2.0, 5.0, -1.5, 6.6, -2, 0).filter(_ >= 0).foreach(x => print(x + " "))
    
    
    /* EXPERIMENT FURTHER BELOW */
    
  }
}