object ProcessingArrays {
  def main(args: Array[String]): Unit = {
    var nums = new Array[Int](50)
    
    var i = 0
    while (i < nums.length) {
      nums(i) = i
      i += 1
    }
    
    i = nums.length - 1
    while (i >= 0) {
      println(i)
      i -= 1
    }
  }
}