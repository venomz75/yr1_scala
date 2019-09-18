object OddIndex {
  def main(args: Array[String]): Unit = {
     var nums = Array(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0)
   
     var i = nums.length - 1
     while (i >= 0) {
       println("Index: " + i + " ; Value: " + nums(i))
       i -= 1
     }
  }
}