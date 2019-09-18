object Counter {
  
  private var counter: Int = 0
    
  def getValue: Int = counter
    
  def inc() {
      counter = counter + 1
  }
  
  def inc(n: Int) {
    for (i <- 1 to n) inc()
  }
  
  def setValue(newValue: Int) {
    counter = newValue 
  }
  
  def reset() {
    counter = 0
  }
}