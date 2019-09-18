

object YearRange {  
  def main(args: Array[String]): Unit = {
    var yearInput = readInt()
    (yearInput to 2018).filter(x => !(x % 4 == 0)).foreach(println)
  }
}