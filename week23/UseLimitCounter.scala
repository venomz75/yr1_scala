import LimitCounter._

object UseLimitCounter {
  def main(args: Array[String]): Unit = {
    reset(20,30)
    inc()
    println(getValue)
    setToUpperLimit()
    println(getValue)
    inc()
    println(getValue)
    println(isAtLowerLimit)
    reset(40,20)
    println(getLowerLimit)
    println(getUpperLimit)
    setValue(25)
    println(getValue)
    setValue(80)
    println(getValue)
  }
}