object ProcessingArrays {
  def main(args: Array[String]): Unit = {
    var size = readInt()
    var nums = new Array[Int](size)
    
    for (i <- 0 until nums.length) {
      nums(i) = i + 1
    }
    
    for (x <- nums) {
      print(x + " ")
    }
  }
}