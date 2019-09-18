

object Logic3 {
  
  def and(a: Int, b: Int): Int = {
    if ((a==2) && (b==2)) 2 else
    if ((a== 0) && (b==2) || (b== 0) && (a==2) || (a== 0) && (b== 0)) 0 else 1
  }
  
  def or(a: Int, b: Int): Int = {
    if (a == 2 || b == 2) 2 else
    if (a == 1 && b == 1) 1 else 0
  }
  
  def not(a: Int): Int = {
    if (a==2) 1 else
    if (a==1) 2 else 0
  }
  
  def main(args: Array[String]): Unit = {
    var symbols: Array[String] = Array("","","")
    println("A\tB\tA^B\tAvB\t¬A")
    for (a <- 0 to 2; b <- 0 to 2) // -1 = null, 0 = false, 1 = true
      
      println(a + "\t" + b + "\t" + and(a,b) + "\t" + or(a,b) + "\t" + not(a))
    }
  }