

object Lottery2 {
  def main(args: Array[String]): Unit = {
    var lottery = Array(23,16,18,19,26,13,22,    /*  1 ..  7 */
                      20,14,22,18,21,15,17,    /*  8 .. 14 */
                      24,15,18,20,13,14,20,    /* 15 .. 21 */
                      18,22,20,16,19,11,20,    /* 22 .. 28 */
                      16,28,22,20,15,17,17,    /* 29 .. 35 */
                      21,21,19,20,14,22,25,    /* 36 .. 42 */
                      19,17,26,18,20,23,12);   /* 43 .. 49 */
    var i = 0
    var x = 0
    print(("\t    ")+("_" * lottery(i)+ "\n"))
    while(i < lottery.length){
      if ((lottery(i) < lottery(i+1)) && lottery(i) < 49) {
        x = (lottery(i+1) - lottery(i)) - 1
      } else {
        x = 0
      }
      var num = i + 1
      print(f"$num%2d" + "  (" +lottery(i)+ ")   |" + ("_" * lottery(i))+ "|" +("_" * x))
      print("\n")
      i += 1     
    }
  }
}