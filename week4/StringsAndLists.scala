

object StringsAndLists {
  def main(args: Array[String]): Unit = {
    var s1: List[String] = List("The","quick","brown","fox","jumped","over","the","lazy","dog")  
    for (i <- 1 to (s1.length-1)){
      var temp: String = s1(i).substring(0,1).toUpperCase
      print(temp+ " ")
    }
  }
}