object ExploringForEach {
  def main(args: Array[String]): Unit = {
    
    println("1. For each on ranges:")
    
    //x => print(x + " ") is a lambda expression - essentially a function
    (1 to 10).foreach(x => print(x + " "))
    
    println()
    
    //equivalent to x => print(x) using shorthand notation
    (1 until 10).foreach(print(_))
    
    println()
    
    //in this case an even more shorthand version is available
    (1 to 10 by 2).foreach(print)
    
    
    println("\n\n2. For each on lists:")
    
    //if the function's body requires multiple lines use a block
    List.range(1, 10).foreach(x => {
      print(x + " ")
      print((x * 2) + " ")
    })
    
    println()
    
    var words = List("apple", "banana", "pear")
    words.foreach(x => println(x.substring(0, 3)))
    
    
    println("\n3. For each on strings:")
    
    //shorthand notation cannot be used when wanting to operate 
    //on each element within another method call
    "Hello World".foreach(x => print(x.toUpper))
    
    println()
    
    "abcdefg".foreach(x => print(x.toInt + " "))
    
    
    println("\n\n4. For each on arrays:")
    
    Array('a', 'b', 'c').foreach(x => print((x + 1).toChar))
    
    println()
    
    var nums = Array(Array(1,2,3), Array(4,5,6,7))
    nums.foreach(x => print(x.length + " "))
    
    println()
    
    //for each array, print each element
    nums.foreach(arr => arr.foreach(elem => print(elem)))
    
    println()
    
    //scala's shorthand syntax allows this as an equivalent
    nums.foreach(_.foreach(print(_)))
    
    
    println()
    
    nums.foreach(x => print(x + " "))
    
  }
}