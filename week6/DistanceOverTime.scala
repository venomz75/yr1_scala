object DistanceOverTime {
  def main(args: Array[String]): Unit = {
    var d,v,t: Int = 0
    var known1, known2, temp, result: Char = ' '
    var knownVariables: String = ""
    
    println("Which two variables are known? (e.g. 'd' and 't' to solve d/t)")
    known1 = readChar()
    known2 = readChar()
    knownVariables = (known1.toString + known2.toString)
    println(knownVariables)
    if(knownVariables.contains('d') && knownVariables.contains('t')) {
      result = 'v'
      if (known1 == 't' && known2 == 'd') {
        temp = known1
        known1 = known2
        known2 = temp
      }
      println("Enter value for d: "); d = readInt();
      println("Enter value for t: "); t = readInt();
      v = d/t
      println(known1+ " = " +d+ "\n" +known2+ " = " +t+ "\n" +result+ " = " +v)
    }
  }
}