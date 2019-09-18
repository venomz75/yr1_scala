

object LetterMatcher {
  def main(args: Array[String]): Unit = {
    var input: Char = ' '
    var output: String = ""
    
    print("Enter a character: "); input = readChar();
    
    if ((input > 64 && input < 123) && !(input > 90 && input < 97)) {
      output = input match {
        case 'a' => "VOWEL"
        case 'e' => "VOWEL"
        case 'i' => "VOWEL"
        case 'o' => "VOWEL"
        case 'u' => "VOWEL"
        case 'A' => "VOWEL"
        case 'E' => "VOWEL"
        case 'I' => "VOWEL"
        case 'O' => "VOWEL"
        case 'U' => "VOWEL"
        case _ => "CONSONANT"
      }
    }
    else {
      output = "Character is non-alphabetic."
    }
    
    print(output)
  }
}