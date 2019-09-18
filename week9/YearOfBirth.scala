

object YearOfBirth {
  def main(args: Array[String]): Unit = {
    print("Enter your year of birth: "); var birthYear = readInt(); var currentYear = 2018; var x = 0
    for (i <- birthYear to currentYear) {
      print(i+ " ")
      x += 1
    }
    print("\nYou are " +(x-2)+ "/" +(x-1)+ "  years old.")
  }
}