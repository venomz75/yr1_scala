import scala.io.StdIn.readInt

object OneToX {
  def main(args: Array[String]): Unit = {
    println("Type in a maximum between 2 - 1000: ")
    var max = readInt()
    
    var count: Int = 1 //start value - of the counter
    
    while (count <= max) { //condition - iterate whilst true
      println(f"$count%4d")
      count = count + 1 //update - by incrementing count
    }
  }
}