object UseCounter {
    
  def main(args: Array[String]): Unit = {
    println(Counter.getValue)
    Counter.inc()
    println(Counter.getValue)
    Counter.inc()
    println(Counter.getValue)
    Counter.inc()
    println(Counter.getValue)
    Counter.inc(2)
    println(Counter.getValue)
    Counter.setValue(100)
    Counter.inc()
    println(Counter.getValue)
    Counter.inc()
    println(Counter.getValue)
    Counter.reset()
    Counter.inc()
    println(Counter.getValue)
  }
}