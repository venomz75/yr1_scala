import scala.io.StdIn.readInt

object CircleCalc {
  def main(args: Array[String]): Unit = {
    var pi: Double = 3.14; var r: Double= 0; var d: String = ""; var c: String = ""; var a: String = "";
    print("Enter the radius of your circle")
    r = readInt()
    d = "%1.0f" format (2 * r)
    println("Your circle has a diameter of: "+d+".")
    c = "%1.2f" format (2 * pi * r)
    println("Your circle has a circumference of: "+c+".")
    a = "%1.2f" format (pi * (r * r))
    println("Your circle has an area of: "+a+".")
  }
}