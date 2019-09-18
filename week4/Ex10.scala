

object Ex10 {
  def main(args: Array[String]): Unit = {
    var firstName: String = ""; var secondName: String = ""; var initials: String = "";
    var x: Int = 0; var y: Int = 0;
    var input: String = readLine();
    x = input.indexOf(" ")
    firstName = input.substring(0,x)
    secondName = input.substring(x+1)
    initials = firstName.substring(0,1).toUpperCase + secondName.substring(0,1).toUpperCase
    var email: String = (initials.substring(0,1) + "." + secondName + "@email.dmu.ac.uk").toLowerCase
    println(firstName + " " + secondName + " " + initials + " " + email)
  }
}