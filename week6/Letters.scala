

object Letters {
  def main(args: Array[String]): Unit = {
    var input: Char = ' '
    
    print("Enter a character: "); input = readChar()
    
    if ((input == 'a') || (input == 'e') || (input == 'i') || (input == 'o') || (input == 'u') || (input == 'A') || (input == 'E') || (input == 'I') || (input == 'O') || (input == 'U')) {
      println("VOWEL")
    } 
    else 
    if ((input > 64 && input < 123) && !(input > 90 && input < 97)) {
      println("CONSONANT")
    } 
    else {
    println("Character is non-alphabetic.")
    }  
  }
}