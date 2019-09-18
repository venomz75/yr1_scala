

object FlatMapCaesar {
  def main(args: Array[String]): Unit = {
    var shift = readInt()
    var words = Array("Mse", "crete", "t", "messiah", "s", "ageing");
    var validChars = words.flatMap(_.take(3)).filter(x => x.isLower)
    for (i <- 0 until validChars.length){
      println(validChars(i)+ " -> " +(validChars(i)+shift).toChar )
    }
  }
}