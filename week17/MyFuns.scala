

object MyFuns {
  def incr(x: Int): Int = x+1
  def decr(x: Int): Int = x-1
  def sqr(x: Int): Int = x*x
  def dbl(x: Int): Int = x*2
  
  def even(x: Int): Boolean = ((x % 2) == 0)
  def odd(x: Int): Boolean = ((x % 2) == 1)
  def inv(x: Boolean): Boolean = if (x == false) true else false
  def neg(x: Int): Boolean = if (x<0) true else false
  def pal(x:String): Boolean = {
    var y = 0
    var head = 0; var tail = x.length()
    for (i <- head to tail-1) //rotor
      if (x.substring(i,i+1) == x.substring(tail-i-1,tail-i)) { 
        (y = y + 0)
      } else {
        (y = y + 1)
      }
    if (y == 0) true else false
  }
  def strlen(x: String): Int = x.length()
  def bracket(x: String): String = "[" + x + "]"

  def countDivisors(n: Int): Int = {
   var d: Int = 0
   for (k <- 1 until n)
     if (n%k==0)
       d = d+1
   d
  }
  
  def prime(x: Int): Boolean = {
   var d: Int = 0
   for (k <- 1 until x)
     if (x%k==0)
       d = d+1
     if (d == 2) true else false
  }
  def perfect(x: Int): Boolean = {
    var total: Int = 0
    var divisors: List[Int] = List.empty[Int]
    for (k <- 1 until x) {
      if (x%k==0) {
        divisors = divisors:+ k
      }
    }
    for (j <- 0 until divisors.length) {
      total = total + divisors(j)
    }   
    if (total == x) true else false
  }
  def digitToWord(x: Int): String = {
    var result = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case _ => "not a digit"     
    }
    result
  }
  def wordToDigit(x: String): Int = {
    var result = x match {
      case "zero" => 0
      case "one" => 1
      case "two" => 2
      case "three" => 3
      case "four" => 4
      case "five" => 5
      case "six" => 6
      case "seven" => 7
      case "eight" => 8
      case "nine" => 9
      case _ => 0     
    }
    result
  }
  def leapYear(x: Int): Boolean = {
    if (x % 400 == 0) true else false
  }
  
  def main(args: Array[String]): Unit = {
//    println((1 to 10) map even)
//    println((1 to 10) filter even)
//    println((1 to 10) filter even map sqr)
//    println(inv(false))
//    println(neg(-5))
//    println(neg(5))
//    println(pal("dog"))
//    println(pal("pip"))
//    println(pal("rotor"))
//    println(strlen("dog"))
//    println(bracket("dog"))
//    println(countDivisors(2))
//    println(countDivisors(30))
//    println(perfect(496))
//    println(perfect(58))
//    println(digitToWord(9))
//    println(wordToDigit("two"))
//    println(leapYear(5))
//    println(leapYear(400))
  }
}