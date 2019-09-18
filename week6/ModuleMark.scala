

object ModuleMark {
  def main(args: Array[String]): Unit = {
    //assign variables
    var coursework, exam, total: Int = 0
    var comments: String = ""
    
    //inputs
    print("Enter your coursework mark(%): "); coursework = readInt()
    print("Enter your examination mark(%): "); exam = readInt()
    total = (coursework + exam) / 2
    
    //decision making
    if (total >= 40) {
      comments += "You have passed the module.\n"
    } else {
      comments += "You have failed the module.\n"
      if (coursework < 40 && exam >= 40) {
        comments += "You need to resit your coursework.\n"
      } else if (exam < 40 && coursework >= 40) {
        comments += "You need to resit your examination.\n"
      } else {
        comments += "Your need to resit both your coursework and examination.\n"
      }
    }
    
    //outputs
    println("\nYour total mark is " +total+ "%.")
    println(comments)
  }
}