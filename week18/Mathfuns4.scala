object Mathfuns4 {

 def add(x: Int, y: Int): Int = x+y
 def sub(x: Int, y: Int): Int = x-y
 def mul(x: Int, y: Int): Int = x*y
 val div: (Int,Int) => Int = (x,y) => x/y

 def main(args: Array[String]): Unit = {
   val big: Int = 2147483647
   val small: Int = -2147483648
   val mid0: Int = 46340
   val mid1: Int = 46341

    println( s"$big + 1 = ${add(big, 1)}" )
    println( s"$big + $small = ${add(big, small)}" )
    println( s"$small + (-1) = ${add(small, -1)}" )
    println( s"$small - 1 = ${sub(small, 1)}" )
    println( s"$big * 2 = ${mul(big, 2)}" )
    println( s"$mid0 * $mid0 = ${mul(mid0, mid0)}" )
    println( s"$mid0 * $mid1 = ${mul(mid0, mid1)}" )
    println( s"$mid1 * $mid1 = ${mul(mid1, mid1)}" )
    //println( s"$big / 0 = ${div(big, 0)}" )
   println( (1 to 10) map (add(_,1)) )
   println( (1 to 10) map (sub(0,_)) )
   println( (1 to 10) map (mul(_,2)) )
   println( (1 to 10) map (div(100,_)) )
 }
}