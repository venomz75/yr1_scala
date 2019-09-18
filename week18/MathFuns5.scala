object MathFuns5 {

 def add(x: Int, y: Int): Option[Int] = {
   if ((x<0 && y>0) || (x>0 && y<0) || x==0 || y==0)
     // if x and y have different signs or x or y equal zero then cannot overflow
     Some(x+y)      // therefore safe to add
   else if (x>0) {
     // both x and y must be greater than zero and overflow could occur
     if (Int.MaxValue - x >= y)
       Some(x+y)   // it is safe to add
     else
       None        // overflow would occur
   }
   else {
     // both x and y must be less than zero and underflow could occur
     if (Int.MinValue - x <= y)
       Some(x+y)   // it is safe to add
     else
       None        // underflow would occur
   }
 }
 
 def div(x: Int, y: Int): Option[Int] = {
   if (y>0)
     Some(x/y)
   else
     None
 }
 
 def sub(x: Int, y: Int): Option[Int] = {
   if ((x<0 && y>0) || (x>0 && y<0) || x==0 || y==0)
     Some(x-y)
   else if (x>0) {
     if (Int.MaxValue + x >= y)
       Some(x-y)
     else
       None
   }
   else {
     if(Int.MinValue + x <= y)
       Some(x-y)
     else
       None
   }
 }
 
 def mult(x: Int, y: Int): Option[Int] = {
   var check: Long = x*y
   if (x==0 || y==0)
     Some(0)
   else if (Int.MaxValue <= check)
       Some(x*y)
     else
       None
 }
 
 def analyseDiv(x: Int, y: Int): Unit = {
   div(x,y) match {
     case Some(n) => println(s"Dividing $x by $y produces $n")
     case None    => println(s"Dividing by 0 is impossible")
   }
 }
 
 def analyseSub(x: Int, y: Int): Unit = {
   sub(x,y) match {
     case Some(n) => println(s"Subtracting $x by $y produces $n")
     case None    => println(s"Subtracting $x from $y causes under/overflow")
   }
 }
 
 def analyseAdd(x: Int, y: Int): Unit = {
   add(x, y) match {
     case Some(n) => println(s"Adding $x to $y produces $n")
     case None    => println(s"Adding $x to $y causes under/overflow")
   }
 }

  def analyseMult(x: Int, y: Int): Unit = {
   mult(x, y) match {
     case Some(n) => println(s"Multiplying $x by $y produces $n")
     case None    => println(s"Multiplying by 0 always produces 0")
   }
 }
 def main(args: Array[String]): Unit = {
   val big: Int = 2147483647
   val small: Int = -2147483648
   val mid0: Int = 46340
   val mid1: Int = 46341

   analyseSub(small,small)
   analyseSub(small,-1)
   analyseSub(small,big)
   analyseSub(big,big)
   analyseSub(big,1)
   analyseSub(big,small)
   analyseMult(big,0)
   analyseMult(30,2)
 }
}