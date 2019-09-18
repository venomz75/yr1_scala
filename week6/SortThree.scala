

object SortThree {
  def main(args: Array[String]): Unit = {
    var a,b,c: Int = 0
    
    println("Enter 3 numbers: ")
    a = readInt(); b = readInt(); c = readInt(); 
    
    if (a>b && b>c) {
        println(a+ " > " +b+ " > " +c)
    }
    else
    if (a>c && c>b) {
        println(a+ " > " +c+ " > " +b)
    }
    else
    if (b>a && a>c) {
        println(b+ " > " +a+ " > " +c)
    }
    else
    if (b>c && c>a) {
        println(b+ " > " +c+ " > " +a)
    }
    else
    if (c>a && a>b) {
        println(c+ " > " +a+ " > " +b)
    }
    else
    if (c>b && b>a) {
        println(c+ " > " +b+ " > " +a)
    }
  }
}