

object InputPrompts {
  def main(args: Array[String]): Unit = {
    var title: String = readLine("Enter your title: ")
    var firstName: String = readLine("Enter your first name: ")
    var lastName: String = readLine("Enter your last name: ") 
    println("Your name is " +title+ " " + firstName + " " + lastName+ ".")
  }
}