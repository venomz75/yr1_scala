object ProcessingArrays2 {
  def main(args: Array[String]): Unit = {
    var strings = new Array[String](10)
    
    var i = 0
    while (i < strings.length) {
      strings(i) = readLine("Enter word #" +(i+1)+ ":")
      i += 1
    }
    
    i = 0
    while (i < strings.length) {
      print(strings(i)+ " ")
      i += 1      
    }
  }
}