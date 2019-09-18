object MultipleArgs {

 def largerOf(a: Int, b: Int): Int = if (a>b) a else b
 
 def smallerOf(a: Int, b: Int): Int = if (b>a) a else b

 def smallerOf3(a: Int, b: Int, c: Int): Int = if ((a<b || a==b) && (a<c || a==c)) a else
                                               if ((b<a || b==a) && (b<c || b==c)) b else c
                                               
                                               
 def medianOf3(a: Int, b: Int, c: Int): Int = if (((b>a || b==a) && (a>c || a==c)) || ((c>a || c==a) && (a>b || a==b))) a else
                                              if (((a>b || a==b) && (b>c || b==c)) || ((c>b || c==b) && (b>a || b==a))) b else c
                                               
 
 def main(args: Array[String]): Unit = {

   for(a <- 1 to 3; b <- 1 to 3; c <- 1 to 3)
     //println(s"Larger of $a and $b is ${largerOf(a,b)}")
     //println(s"Smaller of $a and $b is ${smallerOf(a,b)}")
     //println(s"Smallest of $a, $b and $c is ${smallerOf3(a,b,c)}")
     println(s"Median of $a, $b and $c is ${medianOf3(a,b,c)}")
 }
}