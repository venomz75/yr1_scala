

object Relational {
  def main(args: Array[String]): Unit = {
    println("Enter a number 1/2: ")
    var x: Int = readInt();
    println("Enter a number 1/2: ")
    var y: Int = readInt();
    var t: Boolean = false;
    t = x < y
    println(x+ " < " +y+ " is " +t);
    t = x > y
    println(x+ " >  " +y+ " is " +t);
    t = x <= y
    println(x+ " <= " +y+ " is " +t);
    t = x >= y
    println(x+ " >= " +y+ " is " +t);
    t = x == y
    println(x+ " == " +y+ " is " +t);
    t = x != y
    println(x+ " != " +y+ " is " +t);
    
  }
}