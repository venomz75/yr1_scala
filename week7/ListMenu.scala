import scala.io.StdIn._

object ListMenu {
  def main(args: Array[String]): Unit = {
    println("Enter start value of list ")
    var start = readInt()
 
    print("Enter end value of list (exclusive) ")
    var end = readInt()
 
    var xs = List.range(start, end)
 
    var cmd = ""

    do {
      println("\nMenu\n====")
      println("Take: take from list")
      println("TakeR: take from right of list")
      println("Drop: drop from list")
      println("DropR: drop from right of list")
      println("End: exit program")

      cmd = readLine()
      
      if (cmd.substring(0,5) == "Take ") {
        var amount: Int = (cmd.substring(5)).toInt
        println(xs.take(amount))
      } else if (cmd.substring(0,5) == "TakeR") {
        var amount: Int = (cmd.substring(6)).toInt
        println(xs.takeRight(amount))
      } else if (cmd.contains("Drop ")){
        var amount: Int = (cmd.substring(5)).toInt
        println(xs.drop(amount))
      } else if (cmd.contains("DropR")){
        var amount: Int = (cmd.substring(6)).toInt
        println(xs.dropRight(amount))
      }
      
      
    } while (cmd != "End")
 
    println("Exiting program...")
  }
}