import scala.io.StdIn.readInt

object CircleCalc2 {
  def main(args: Array[String]): Unit = {
    var pi: Double = 3.14; var r: Double= 0;
    print("Enter the radius of your circle: ")
    r = readInt()
    println("Your circle has a diameter of: " +("%1.0f" format (2 * r)) + ".")
    println("Your circle has a circumference of: " +("%1.2f" format (2 * pi * r))+ ".")
    println("Your circle has an area of: " +("%1.2f" format (pi * (r * r)))+ ".")
  }
}