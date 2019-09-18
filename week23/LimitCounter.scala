

object LimitCounter {
  //default variables
  
  private val DEFAULT_LOWER = 0
  private val DEFAULT_UPPER = 10
  private val DEFAULT_COUNTER = 0
  
  private var lower = DEFAULT_LOWER
  private var upper = DEFAULT_UPPER
  private var counter = DEFAULT_COUNTER
  
  //mutator methods
  def resetDefault() {
    lower = DEFAULT_LOWER
    upper = DEFAULT_UPPER
    counter = DEFAULT_COUNTER
  }
  
  def reset (lo: Int, up: Int) {
    if (lo<up) {
    lower = lo
    upper = up
    counter = lo 
    }
  }
  
  def setLowerLimit(lo: Int) {
    if (lo<upper)
    lower = lo
    if (counter<lo) counter = lo
  }
  
  def setUpperLimit(up: Int) {
    if (up>lower)
    upper = up
    if (counter>up) counter = up
  }
  
  def setValue(newValue: Int) {
    if (newValue < upper && newValue > lower) {
      counter = newValue
    }
  }
  
  def setToLowerLimit() {
    counter = lower
  }
  
  def setToUpperLimit() {
    counter = upper
  }
  
  def inc() {
    if (counter<upper) counter += 1
    else counter = lower
  }
  
  def dec() {
    if (counter>lower) counter -= 1
    else counter = upper
  }
  
  //accessor methods
  def getLowerLimit: Int = lower
  
  def getUpperLimit: Int = upper
  
  def getValue: Int = counter
  
  def isAtLowerLimit: Boolean = (counter == lower)
  
  def isAtUpperLimit: Boolean = (counter == upper)
}