

object Checkout {
  def main(args: Array[String]): Unit = {
    var count,total,input,i: Double = 0
    var subtotal: List[Double] = List()
    
    print("Price:\t£")
    input = readDouble(); subtotal :+ input; total += input; count += 1
    
    while (input > 0.00) {
      print("Price:\t£")
      input = readDouble(); subtotal :+ input; total += input; count += 1
    }
    
      println("-------------")
      println("Total:\t£" + f"$total%1.2f")
  }
}