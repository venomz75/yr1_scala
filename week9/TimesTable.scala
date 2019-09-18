

object TimesTable {
  def main(args: Array[String]): Unit = {
    var x = 0
    x = readInt()
    for (i <- 1 to 12) {
      println(f"$i%2d"+ " x " +x+ " = " +(i*x))
    }
  }
}