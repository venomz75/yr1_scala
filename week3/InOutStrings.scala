import scala.io.StdIn.readChar
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object InOutStrings {
  def main(args: Array[String]): Unit = {
    print("Enter your first name ")
    var firstName: String = readLine()
    var lastName: String = readLine("Enter your last name ")
    println("Enter your initial.")
    var initial : Char = readChar;
    println("What's your house number?")
    var houseNumber : Int = readInt();
    println("What's your address?")
    var address : String = readLine();
    println("What's your phone number?")
    var telephone: String = readLine();
    println("How much do you earn in a year?")
    var salary: Int = readInt();
    
    println("Your name is " +firstName+ " " +lastName+ ", initial: " +initial+ ". Your address is " +houseNumber+ " " +address+ ", and your phone number is " +telephone+ ". You earn £" +salary+ " a year.");
  }
}