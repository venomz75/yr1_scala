

object curry1 {
  
  def add(x: Int)(y: Int) = x+y
  def eq(c:Char)(d:Char) = c>d
  def bracket(left: String)(right: String)(whatever: String) = left + whatever + right
  
  def main(args: Array[String]): Unit = {
    println((1 to 10) map (add(2)))
    println("hello world".toList filter (eq('l')))
    println(List("apple","pear","orange") map (bracket("\\") ("/")))
  }
}