import scala.io.StdIn.readLine

object FilterAndReplace {
  def main(args: Array[String]): Unit = {
    println("Enter a sentence: ")
    var sentence = readLine()
    
    //if used as a guard to filter iterated elements
    var filtered = for (x <- sentence if x != ' ') yield x
    println(filtered)
    
    //if clause used on yielded value to replace certain elements
    var replaced = for (x <- sentence) yield if (x != ' ') x else '*'
    println(replaced)

    //splits sentence into an array of words and yields the length of each into a list
    var lengths = for (word <- sentence.split(" ").toList) yield word.length
    println(lengths)
    
    var invert = for (x <- sentence) yield if (x.isUpper) x.toLower else x.toUpper
    println(invert)
  }
}