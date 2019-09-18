

object NumericSequence {
  def main(args: Array[String]): Unit = {
    var x,y = 0
    print("Number #1: "); x = readInt()
    print("Number #2: "); y = readInt()
    if (x<y) {
      for (i <- x to y) {
        println(i)
      }
    } else if (x>y){
      for (i <- y to x by -1) {
        println(i)
      }
    }  
  }
}