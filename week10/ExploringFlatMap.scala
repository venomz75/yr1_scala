object ExploringFlatMap {
  def main(args: Array[String]): Unit = {
    
    println("1. Flattening:")
    
    var xs = List("apple", "banana", "pear", "grape", "kiwi")
    
    //a list of strings is converted to a list of characters
    var ys: List[Char] = xs.flatMap(x => x)
    println(ys)
    println(xs.flatten) //this is also achieved more simply with the flatten operation
    
    //a list of lists of numbers is flattened to simply a list of numbers
    var nums = List(List(1,2,3),List(4,5,6))
    println(nums.flatMap(x => x))
    
    
    println("\n2. Flat mapping:")
    
    //the original elements are mapped prior to being flattened into a list of characters
    println(xs.flatMap(x => x.take(3)))
    
    //here flatmap is used to create a new list of numbers based on the existing list
    var nums2 = List(1,2,3,4,5,6)
    println(nums2.flatMap(x => List(x, x+1)))
   
    
    println("\n3. Flatmap followed by map:")
    
    //the original elements are mapped and then flattened. 
    //The flattened structure of characters is then mapped
    println(xs.flatMap(x => x.take(3)).map(y => y.toUpper))
    
    
    println("\n4. Combining operations:")
    
    //ensure you understand what each of these chained operations does
    nums.flatMap(x => x.dropRight(1)).map(x => x * 2).filter(x => x > 5).foreach(x => print(x + " "))
    
    println()
    
    //this produces a new flattened sequence and then maps each element before printing it
    (1 to 5).flatMap(i => (1 to i)).map(j => j * 2).foreach(x => print(x + " "))
   
    println()
    
    //this produces the same output however it maps each element before flattening it
    (1 to 5).flatMap(i => (1 to i).map(j => j * 2)).foreach(x => print(x + " "))
    
    println()
    
    //the latter approach above may be beneficial as it allows both i and j to be referred to by the map
    //(i.e. the value of the original sequence and the newly created sequence), e.g. see i * j below
    (1 to 5).flatMap(i => (1 to i).map(j => i * j)).foreach(x => print(x + " "))
    
    
     /* EXPERIMENT FURTHER BELOW */
    
  }
}