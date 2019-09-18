

object LogicalOperators {
  def main(args: Array[String]): Unit = {
    var a: Boolean = false; var b: Boolean = false; var c: Boolean = false;
    println("True of false? 1/2")
    a = readBoolean();
    println("True of false? 1/2")
    b = readBoolean()
    c = a && b;
    println(a+ " AND " +b+ " is " +c);
    c = a || b;
    println(a+ " OR " +b+ " is " +c);
  }
}