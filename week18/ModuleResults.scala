

object ModuleResults {
  
  def getResult(a: Int, b: Int): String = {
    var avg = (a+b)/2
    if (avg >= 40) "PASSED" else
    if (avg < 40 && (a<40 && b>=40)) "RESIT COURSEWORK" else
    if (avg < 40 && (b<40 && a>=40)) "RESIT EXAM" else
    if (avg < 40 && (b<40 && a<40)) "RESIT MODULE" else "INVALID INPUTS"
  }
  
  def main(args: Array[String]): Unit = {
    println(getResult(40,40))
    println(getResult(50,30))
    println(getResult(40,30))
    println(getResult(30,40))
    println(getResult(30,30))
  }
}