package demo

object Picture6 {
  
  import gfx.Layer
  import gfx.Image
  import gfx.Compass._
  
  def main(args: Array[String]): Unit = {
    val layers = (0 to 9) map (i => new Layer(40, 15, (i+48).toChar, ' ', N, true))
    
    for (i <- 0 to 9) {
      layers(i).setXY(i*3, i)
      layers(i).filledSquare(5)
    }
    
    val image = new Image(layers(9))
    for (i <- 8 to 0 by -1)
      if (i%2==1) {
        image.push(layers(i))
        //image.paint()
      }


    /*
     * Create the mask
     */
    val mask = new Layer(40, 15)
    mask.startWriting()
    for (i <- 0 to 30 by 2) {
      mask.setXY(i, 0)
      mask.setDirection(N)
      mask.move(40)
      mask.setXY(0, i)
      mask.setDirection(E)
      mask.move(40)
    }
    
    /*
     * Apply the mask to every layer
     */
    for (i <- 0 to 9) {
      layers(i).mask(mask)
    }
    
    image.paint()
  }
}