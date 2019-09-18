import scala.io.StdIn.readInt

object InputXandY {
  def main(args: Array[String]): Unit = {
    var x :Int = 0; var y :Int = 0
    print("Enter a number: ")
    x = readInt()
    print("Enter another number: ")
    y = readInt()
    
    println("The numbers you've entered are: " +x+ " and " +y+ ".")
    println("The sum of these numbers is: " +(x+y)+ ".")
    println("The product of these numbers is: " +(x*y)+ ".")
  }
}