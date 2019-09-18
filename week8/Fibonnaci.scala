

object Fibonnaci {
  def main(args: Array[String]): Unit = {
      var fibs = new Array[Int](40)
    fibs(0) = 1; fibs(1) = 1
    print(fibs(0)+ " " + fibs(1)+ " ")
    var i = 2
    while (i < fibs.length) {
      fibs(i) = fibs(i-1) + fibs(i-2)
      print(fibs(i)+ " ")
      i += 1
    }
  }
}